package com.cnpc.feign;

import org.springframework.stereotype.Component;

/**
 * @ClassName FeignHystricLH
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/19 9:29
 * @Version 1.0
 **/
@Component
public class FeignHystricLH implements FeignServiceLH {


    @Override
    public Object testLH(int type, String name, int reserve) {
        return "服务异常！--lh";
    }

}
