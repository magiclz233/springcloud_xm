package com.cnpc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/14 15:51
 * @Version 1.0
 **/

@RestController
public class HelloController {

    @Value( "${server.port}" )
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name",defaultValue = "Magic") String name){
        return "你好,我是"+name+",我来自port："+port;
    }
}
