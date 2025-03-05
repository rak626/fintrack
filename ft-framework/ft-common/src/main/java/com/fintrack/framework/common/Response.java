package com.fintrack.framework.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private Status status;
    private String error;
    private T result;

    public enum Status {
        SUCCESS, FAILURE
    }
}
