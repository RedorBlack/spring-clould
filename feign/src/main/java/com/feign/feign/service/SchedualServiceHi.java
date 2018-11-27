package com.feign.feign.service;

import com.eureka.client.dto.ResultDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Red
 * @date 2018/10/16  16:42.
 * @title
 */
@FeignClient(value = "server-hello", fallback = SchedualServiceHiImpl.class)
public interface SchedualServiceHi {


    @RequestMapping("/hello/{name}")
    String sayHiFromClientOne(@PathVariable(value = "name") String name);


}
