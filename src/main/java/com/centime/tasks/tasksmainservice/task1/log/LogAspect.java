package com.centime.tasks.tasksmainservice.task1.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogMethodParam)")
    public Object logMethodParam(ProceedingJoinPoint joinPoint) throws Throwable {
        String traceId = joinPoint.getArgs().length > 0 ? (String) joinPoint.getArgs()[0] : null;
        log.info("[traceId: {}] Method {} called with params {}", traceId,
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
