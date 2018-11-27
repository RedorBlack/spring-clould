package com.eureka.client.controller;

import com.eureka.client.dto.ResultDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Red
 * @date 2018/10/16  9:49.
 * @title
 */
@RestController
public class Hello {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello/{name}")
    ResultDto hello(@PathVariable String name, HttpServletRequest request) throws Exception {
        ResultDto resultDto = new ResultDto();
        resultDto.setMsg("欢迎+" + name + "使用cloud服务");
        resultDto.setPort(port);
        resultDto.setTimeDate(String.valueOf(new Date().getTime()));
        resultDto.setUrl(request.getRemoteAddr());
        return resultDto;
    }
}
