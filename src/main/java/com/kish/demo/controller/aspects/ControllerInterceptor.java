package com.kish.demo.controller.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInterceptor {


    private static final Logger LOG = LoggerFactory.getLogger(ControllerInterceptor.class);

    @Before("execution(public * com.kish.demo.controller.*Controller.*(..))")
    public void logbeforeCall(JoinPoint jp){
        LOG.info("before calling the function {}",jp.getSignature());
        LOG.info("Args ");
        Object[] asd = jp.getArgs();
        for (Object obj:asd) {
            LOG.info("{}",obj);
        }
    }

    @AfterReturning(value = "execution(public * com.kish.demo.controller.*Controller.*(..))",returning = "value")
    public void logAfterCall(JoinPoint jp,Object value){
        LOG.info("after calling the function {}",jp.getSignature());
        LOG.info("response returned {}",value);
    }

    @AfterThrowing(value = "execution(public * com.kish.demo.controller.*Controller.*(..))",throwing = "e")
    public void logAfterException(JoinPoint jp,Exception e){
        LOG.info("after calling the function {}",jp.getSignature());
        LOG.info("Exception returned {}",e.getLocalizedMessage());
    }
}
