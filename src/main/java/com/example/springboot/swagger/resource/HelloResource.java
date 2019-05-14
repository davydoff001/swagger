/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.swagger.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a.davydov
 */
@RestController
@RequestMapping("/rest/hello")
@Api(value = "HelloWorld Resource", description = "Shows hello world")
public class HelloResource {
    
    @ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value={
                @ApiResponse(code = 100, message = "100 is the message"),
                @ApiResponse(code = 200, message = "Successfull Hello World")
            }
    )
    @GetMapping
    public String hello(){
        return "Hello World";
    }
    
    @ApiOperation(value = "Returns Hello World")
    @PostMapping("/post")
    public String helloPost(@RequestBody final String hello){
        return hello;
    }
    
    @ApiOperation(value = "Returns Hello World")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello){
        return hello;
    }
}
