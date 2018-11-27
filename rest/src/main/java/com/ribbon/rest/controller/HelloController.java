package com.ribbon.rest.controller;

import com.ribbon.rest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Red
 * @date 2018/10/16  10:34.
 * @title
 */
@RestController
public class HelloController {


    @Autowired
    HelloService service;


    @RequestMapping(value = "/hello/{name}")
    String hi(String name) {
        return service.hello(name);
    }


}
