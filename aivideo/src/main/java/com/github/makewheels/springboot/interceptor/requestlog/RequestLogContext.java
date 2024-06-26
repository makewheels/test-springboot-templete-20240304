package com.github.makewheels.springboot.interceptor.requestlog;

public class RequestLogContext {
    private static final ThreadLocal<RequestLog> requestLogThreadLocal = new ThreadLocal<>();

    public static RequestLog getRequestLog() {
        return requestLogThreadLocal.get();
    }

    public static void setRequestLog(RequestLog requestLog) {
        requestLogThreadLocal.set(requestLog);
    }

    public static void removeRequestLog() {
        requestLogThreadLocal.remove();
    }
}
