package com.cnpc.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName FeignController
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/18 16:11
 * @Version 1.0
 **/
@RestController
public class FeignController {

    @Autowired
    FeignService feignService;
    @Autowired
    FeignServiceLH feignServiceLH;

    @GetMapping(value = "/hi")
    public String sayHello(@RequestParam String name){
        return feignService.sayHello( name );
    }

    @GetMapping(value = "/allUser")
    public Object allUser(){
        return feignService.allUser();
    }

    @GetMapping("/testLH")
    public Object testLH(@RequestParam(value = "type",required = false,defaultValue = "0")int type,
                         @RequestParam(value = "name",required = false,defaultValue = "长庆油田")String name,
                         @RequestParam(value = "reserve",required = false,defaultValue = "0")int reserve){
        
        return feignServiceLH.testLH(type,name,reserve);
    }


}
