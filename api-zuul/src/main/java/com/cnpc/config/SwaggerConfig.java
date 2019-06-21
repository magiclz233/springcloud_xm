package com.cnpc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/19 16:50
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket( DocumentationType.SWAGGER_2 ).apiInfo( apiInfo() );

    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("A6矿权储量说明文档")
                .description("A6矿权储量说明文档")
                .termsOfServiceUrl("http://www.ityouknow.com/")
                .contact(new Contact("magic", "", "123@163.com"))
                .version("1.0")
                .build();
    }

}
