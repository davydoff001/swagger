/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.swagger.config;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 *
 * @author a.davydov
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.swagger"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Example API",
                "",
                "1.0",
                "Terms of Service",
                new Contact("Alex", "https://github.com/davydoff001/swagger.git", "mrdavudoff@ukr.net"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );
        
        return apiInfo;
    }
    
    
}
