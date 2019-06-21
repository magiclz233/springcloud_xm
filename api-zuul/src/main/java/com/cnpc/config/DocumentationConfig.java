package com.cnpc.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/19 15:50
 * @Version 1.0
 **/

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources  = new ArrayList<>(  );

        resources.add( swaggerResource( "菜单和通过key返回页面","/menu/v2/api-docs","1.0" ) );
        return resources;
    }

    private SwaggerResource swaggerResource(String name,String location,String version){
        SwaggerResource swaggerResource = new SwaggerResource();
                 swaggerResource.setName(name);
                   swaggerResource.setLocation(location);
                   swaggerResource.setSwaggerVersion(version);
                   return swaggerResource;
    }
}
