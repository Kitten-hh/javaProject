package com.jq.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class BillLogAop {

    @Pointcut("execution (public * com.jq.controller..*(..))")
    public void controllerPointCut(){

    }

    @AfterReturning(value = "controllerPointCut()",returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint,Object returnValue){
        // Object[] args = joinPoint.getArgs();
        // for(Object arg:args){
        //     // log.info(arg);
        // }
    }

}
