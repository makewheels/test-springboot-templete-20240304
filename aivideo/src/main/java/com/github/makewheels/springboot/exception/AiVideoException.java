package com.github.makewheels.springboot.exception;

import com.github.makewheels.system.response.ErrorCode;

public class AiVideoException extends RuntimeException {
    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public AiVideoException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public AiVideoException(String message) {
        super(message);
        this.errorCode = ErrorCode.FAIL;
    }

    public AiVideoException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
