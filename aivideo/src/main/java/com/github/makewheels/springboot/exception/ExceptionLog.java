package com.github.makewheels.springboot.exception;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("exception_log")
public class ExceptionLog {
    @Id
    private String id;

    private Integer systemErrorCode;
    private String systemErrorMessage;

    private String exceptionMessage;
    private String exceptionStackTrace;
    private Date createTime;

    public ExceptionLog() {
        this.createTime = new Date();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
