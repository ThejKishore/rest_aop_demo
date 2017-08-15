package com.kish.demo.controller;

import com.kish.demo.jpa.model.Person.RestErrInfo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

public class AbstractRestHandler implements ApplicationEventPublisherAware{

    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody RestErrInfo handleException(RuntimeException re, WebRequest webRequest, HttpServletResponse response){
        return new RestErrInfo(HttpStatus.INTERNAL_SERVER_ERROR+"",re.getMessage());
    }


}
