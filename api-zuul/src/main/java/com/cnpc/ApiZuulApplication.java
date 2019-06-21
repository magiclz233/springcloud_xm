package com.cnpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run( ApiZuulApplication.class, args );
    }

}
