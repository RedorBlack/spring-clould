package com.feign.feign.controller;

import com.alibaba.fastjson.JSONObject;
import com.eureka.client.dto.ResultDto;
import com.feign.feign.service.SchedualServiceHi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Red
 * @date 2018/10/16  16:44.
 * @title
 */
@RestController
public class SchedualController {

    @Autowired
    SchedualServiceHi serviceHi;

    @Value("${server.port}")
    String port;

    @HystrixCommand(fallbackMethod = "hi")
    @RequestMapping(value = "/sayHello/{name}")
    String sayHello(@PathVariable String name) {
        return serviceHi.sayHiFromClientOne(name);
    }

    public String hi(String name) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "999");
        jsonObject.put("msg", "服务不可用,请稍后重试" + name);
        jsonObject.put("timestamp", new Date().getTime());
        jsonObject.put("port", "8084");
        return JSONObject.toJSONString(jsonObject);
    }

}
