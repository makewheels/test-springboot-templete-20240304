package com.github.makewheels.system.response;

public enum ErrorCode {
    SUCCESS(0, "成功"),
    FAIL(1, "未知错误"),

    ;

    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
