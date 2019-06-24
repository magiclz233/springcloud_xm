package com.cnpc.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/24 11:27
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restApi(){
        return new Docket( DocumentationType.SWAGGER_2  )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.cnpc.controller" ) )
                .paths( PathSelectors.any() )
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title( "User Test" )
                .description( "USER TEST" )
                .termsOfServiceUrl( "www.github.com" )
                .contact( new Contact( "magic","","" ) )
                .version( "1.0" )
                .build();
    }

}
