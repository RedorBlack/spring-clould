package com.ribbon.rest.service;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


/**
 * @author Red
 * @date 2018/10/16  10:33.
 * @title
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(String name) {
        return restTemplate.getForObject("http://server-hello//hello/" + name, String.class);

    }


    public String hiError(String name) {
        Msg msg = new Msg();
        msg.setCode("-100000");
        msg.setMsg("服务不可用,请稍后重试" + name);
        msg.setTimeStamp(new Date().getTime());
        return JSON.toJSONString(msg);
    }

    class Msg {

        String code;
        String msg;
        long timeStamp;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }
    }


}
