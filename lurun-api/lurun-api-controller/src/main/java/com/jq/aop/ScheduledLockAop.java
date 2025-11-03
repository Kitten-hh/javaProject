package com.jq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by zhaojiaqi on 2021/6/24 9:31
 */
@Aspect
@Configuration
public class ScheduledLockAop {

    private static final Logger log = LoggerFactory.getLogger(ScheduledLockAop.class);

    @Pointcut(" @annotation(org.springframework.scheduling.annotation.Scheduled)")
    public void scheduledAspect() {
    }

    @Around("scheduledAspect()")
    public Object doInvoke(ProceedingJoinPoint joinPoint) {

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni =  networkInterfaces.nextElement();
                Enumeration<InetAddress> nias = ni.getInetAddresses();
                while (nias.hasMoreElements()) {
                    InetAddress ia = nias.nextElement();
                    if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
                        if(ia.getHostAddress().equals("192.168.2.48")){
                            return joinPoint.proceed();
                        }else{
                            log.info("定时任务已被拦截！！！");
                        }
                    }
                }
            }
        } catch (SocketException e) {
            log.error("Socket通信异常",e);
        } catch (Throwable e) {
            log.error("定时拦截器异常", e);
        }
        return null;
    }
}
