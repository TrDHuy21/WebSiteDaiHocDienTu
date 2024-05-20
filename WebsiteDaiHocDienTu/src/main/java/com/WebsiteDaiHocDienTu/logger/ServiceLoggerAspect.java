package com.WebsiteDaiHocDienTu.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class ServiceLoggerAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(public * com.WebsiteDaiHocDienTu.service.impl.*.*(..))")
    public void cutAround(){}

    @Around("cutAround()")
    public Object logMethodService(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        logger.info("BEGIN method "+ methodName +" FROM "+ className);

        Object result = joinPoint.proceed();

        logger.info("END method "+ methodName+" FROM "+ className);
        return result;
    }



}
