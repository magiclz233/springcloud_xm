package com.cnpc.feign;

import org.springframework.stereotype.Component;

/**
 * @ClassName FeignHystric
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/19 9:19
 * @Version 1.0
 **/
@Component
public class FeignHystric implements FeignService {
    @Override
    public String sayHello(String name) {
        return "你好"+name+",hello接口调用失败！";
    }

    @Override
    public Object allUser() {
        return "findAllUser接口调用失败！";
    }
}
