package com.cnpc.controller;

import com.cnpc.entity.User;
import com.cnpc.repository.UserRepository;
import com.cnpc.util.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/14 15:51
 * @Version 1.0
 **/

@RestController
@RequestMapping("/")
@Api(value = "user测试")
public class HelloController {

    @Autowired
    UserRepository userRepository;
    @Value( "${server.port}" )
    String port;

    @ApiOperation( value = "欢迎",produces = "application/json",notes = "简单的欢迎语句，用来测试")
    @GetMapping("hello")
    public String hello(@RequestParam(value = "name",defaultValue = "Magic") String name){
        return "你好,我是"+name+",我来自port："+port;
    }

    @ApiOperation( value = "查找所有用户User",produces = "application/json")
    @GetMapping("users")
    public ResultBean findAll(){
        ResultBean resultBean = new ResultBean();
        return resultBean.success( userRepository.findAll() );
    }
    @ApiOperation( value = "添加单个用户",produces = "application/json")
    @PostMapping("user")
    public ResultBean addUser(
            @ApiParam(name = "user",value = "前台传进来，准备添加的User",required = true) @Valid User user,
            @ApiParam(name = "result",value = "是否符合hibernate validation的限定规则") BindingResult result){
        ResultBean resultBean = new ResultBean();
        String errorMsg = "";
        if(result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError e :
                    errorList) {
                errorMsg =errorMsg + e.getCode() +"---"+e.getDefaultMessage()+";";
            }
            return resultBean.fail( errorMsg );
        }
        User u = userRepository.findByEmail( user.getEmail() );
        if(u != null){
            errorMsg = "用户已存在！";
            return resultBean.fail( errorMsg );
        }
        userRepository.save( user );
        return resultBean.success();
    }


}
