package com.github.makewheels.springboot.exception;

import com.github.makewheels.system.environment.EnvironmentService;
import com.github.makewheels.system.response.ErrorCode;
import com.github.makewheels.system.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private EnvironmentService environmentService;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Object> exceptionHandler(Exception exception) {
        log.error("发生异常exceptionHandler", exception);
        handleException(exception);
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        return new Result<>(ErrorCode.FAIL.getCode(), exception.getMessage(), stackTrace);
    }

    @ResponseBody
    @ExceptionHandler(AiVideoException.class)
    public Result<Object> exceptionHandler(AiVideoException aiVideoException) {
        //打印自定义错误码
        ErrorCode errorCode = aiVideoException.getErrorCode();
        int code = errorCode.getCode();
        String value = errorCode.getMessage();
        String message = errorCode.getMessage();
        log.error("code = " + code + ", value = " + value + ", message = " + message);

        //打印错误堆栈
        log.error(ExceptionUtils.getStackTrace(aiVideoException));

        //把异常保存到数据库
        handleException(aiVideoException);
        String stackTrace = ExceptionUtils.getStackTrace(aiVideoException);
        return new Result<>(code, message, stackTrace);
    }

    /**
     * 最终处理异常
     */
    private void handleException(Exception exception) {
        ExceptionLog exceptionLog = new ExceptionLog();
        if (exception instanceof AiVideoException) {
            AiVideoException aiVideoException = (AiVideoException) exception;
            exceptionLog.setSystemErrorCode(aiVideoException.getErrorCode().getCode());
            exceptionLog.setSystemErrorMessage(aiVideoException.getErrorCode().getMessage());
        }
        exceptionLog.setExceptionMessage(exception.getMessage());
        exceptionLog.setExceptionStackTrace(ExceptionUtils.getStackTrace(exception));

        //保存到数据库
        mongoTemplate.save(exceptionLog);
    }


}
