package com.spring.springexample.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class NmRequestAspect {

    @Autowired
    NmBaseRequestModel requestModel;

    @Around(value = "@whithin(org.springframework.web..bind.annotation.RequestMapping)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        requestModel.setUserId(Long.valueOf( request.getHeader("userId")));
        requestModel.setDeviceName(request.getHeader("deviceName"));
        requestModel.setLanguage(request.getHeader("language"));
        requestModel.setPlatform(request.getHeader("platform"));

        return pjp.proceed();
    }
}
