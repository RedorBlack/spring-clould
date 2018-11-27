package com.feign.feign.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author Red
 * @date 2018/10/17  17:00.
 * @title
 */
@Component
public class SchedualServiceHiImpl implements SchedualServiceHi {


    @Override
    public String sayHiFromClientOne(String name) {
        JSONObject object = new JSONObject();
        object.put("code", "-999900");
        object.put("msg", "feign调用cloud服务失败  callback返回失败");
        object.put("port", "8085");
        object.put("timestamp", new Date().getTime());
        return JSONObject.toJSONString(object);
    }
}
