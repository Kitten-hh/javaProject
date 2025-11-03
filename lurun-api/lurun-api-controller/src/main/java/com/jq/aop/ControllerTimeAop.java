package com.jq.aop;


import com.jq.dto.ResponseDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaojiaqi on 2021/4/28 11:38
 */

@Aspect
@Component
public class ControllerTimeAop {

    // service层的统计日志/耗时(方法所在的包)
    public static final String POINT = "execution (* com.jq.controller.*.*(..))";

    private static final Logger log = LoggerFactory.getLogger(ControllerTimeAop.class);

    @Pointcut("execution (public * com.jq.controller..*(..))")
    public void controllerPointCut() {
    }


    @Around("controllerPointCut()")
    public Object before(ProceedingJoinPoint joinPoint) {
        Object resultData = null;
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        try {
            resultData = joinPoint.proceed(args);
        } catch (Throwable e) {
            log.error("(execution)获取{}接口返回结果信息出错 exception {}",joinPoint.getSignature().getName(), e.toString(),e);
            return new ResponseDTO(103,"程序运行异常，请联系我们！",null,null);
        }
        long endTime = System.currentTimeMillis();
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            long runTime = endTime - startTime;
            if(runTime>=60000L){
                if(sra!=null){
                    HttpServletRequest request = sra.getRequest();
                    log.info("接口名称 {} 接口调用耗时 {} min", request.getRequestURI(), runTime/60000L);
                }else{
                    log.info("{} 类中定时任务名称 {} 调用耗时 {} min", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), runTime/60000L);
                }
            }else{
                if(sra!=null){
                    HttpServletRequest request = sra.getRequest();
                    log.info("接口名称 {} 接口调用耗时 {} ms", request.getRequestURI(), runTime);
                }else{
                    log.info("{} 类中定时任务名称 {} 调用耗时 {} ms", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), runTime);
                }
            }
            //String url = request.getRequestURL().toString();
            //HttpServletRequest httpServletRequest = ((HttpServletRequest) args[0]);

        } catch (Exception e) {
            log.error("(after)保存{}接口耗时信息出错 exception {}",joinPoint.getSignature().getName(), e.toString(),e);
            return new ResponseDTO(103,"程序运行异常，请联系我们！",null,null);
        }

        return resultData;
    }
}

