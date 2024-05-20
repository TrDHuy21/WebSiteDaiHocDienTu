package com.WebsiteDaiHocDienTu.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class RepositoryLoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.WebsiteDaiHocDienTu.respository.*.*(..))")
    public void pointCutRepository(){}

    @Before("pointCutRepository()")
    public void showMethodName(JoinPoint joinPoint){
        String interfaceName = joinPoint.getTarget().getClass().getInterfaces()[0].getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("SQL FROM "+ interfaceName + " method name "+ methodName);
    }
}
