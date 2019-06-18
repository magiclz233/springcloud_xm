package com.cnpc.controller;

import com.cnpc.entity.User;
import com.cnpc.repository.UserRepository;
import com.cnpc.util.ResultBean;
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
public class HelloController {

    @Autowired
    UserRepository userRepository;
    @Value( "${server.port}" )
    String port;

    @RequestMapping("hello")
    public String hello(@RequestParam(value = "name",defaultValue = "Magic") String name){
        return "你好,我是"+name+",我来自port："+port;
    }
    @GetMapping("users")
    public ResultBean findAll(){
        ResultBean resultBean = new ResultBean();
        return resultBean.success( userRepository.findAll() );
    }
    @PostMapping("user")
    public ResultBean addUser(@Valid User user, BindingResult result){
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
