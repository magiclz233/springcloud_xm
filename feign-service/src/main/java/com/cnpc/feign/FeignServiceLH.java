package com.cnpc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName FeignServiceLH
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/19 9:28
 * @Version 1.0
 **/

@FeignClient(value = "server-data-8003",fallback = FeignHystricLH.class)
public interface FeignServiceLH {

    @RequestMapping(value = "/container/year/all",method = RequestMethod.GET)
    public Object testLH(@RequestParam(value = "type",required = false,defaultValue = "0")int type,
                         @RequestParam(value = "name",required = false,defaultValue = "长庆油田")String name,
                         @RequestParam(value = "reserve",required = false,defaultValue = "0")int reserve);

    
}
