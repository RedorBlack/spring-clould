package com.eureka.client.dto;

/**
 * @author Red
 * @date 2018/10/16  9:53.
 * @title
 */
public class ResultDto {

    private String port;
    private String msg;
    private String url;
    private String timeDate;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
