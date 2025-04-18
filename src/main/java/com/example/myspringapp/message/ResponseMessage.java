package com.example.myspringapp.message;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseMessage(){}

    public ResponseMessage(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseMessage: " +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> ResponseMessage<T> success(T data){
        return new ResponseMessage<>(HttpStatus.OK.value(), "success!", data);
    }

    public static <T> ResponseMessage<T> success(){
        return new ResponseMessage<>(HttpStatus.OK.value(), "success!",null);
    }
}
