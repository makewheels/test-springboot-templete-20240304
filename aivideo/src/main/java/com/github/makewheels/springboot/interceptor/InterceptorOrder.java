package com.github.makewheels.springboot.interceptor;

/**
 * 拦截器顺序
 */
public interface InterceptorOrder {
    int PUT_TOKEN = 1001;
    int CHECK_TOKEN = 1002;
    int REQUEST_LOG = 1003;
}
