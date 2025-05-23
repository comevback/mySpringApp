package com.example.myspringapp.exception;

import com.example.myspringapp.message.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler({Exception.class})
    public ResponseMessage HandlerException(Exception e, HttpServletRequest request, HttpServletResponse response){
        // new ResponseMessage(code:500, message:)
        log.error("Exception info: ",e);
        return new ResponseMessage(500,"error",null);
    }
}
