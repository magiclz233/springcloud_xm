package com.cnpc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName FeignService
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/18 16:05
 * @Version 1.0
 **/

@FeignClient(value = "rest-client",fallback = FeignHystric.class)
public interface FeignService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello(@RequestParam (value = "name")String name);

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    Object allUser();

}
