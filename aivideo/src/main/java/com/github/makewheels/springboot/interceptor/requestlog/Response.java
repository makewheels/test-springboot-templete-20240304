package com.github.makewheels.springboot.interceptor.requestlog;

import lombok.Data;

import java.util.Map;

@Data
public class Response {
    private Integer httpStatus;
    private Map<String, Object> headerMap;
    private String body;
}
