package com.florian935.customannotation.annotation.logexecutiontime;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    @SneakyThrows
    Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) {

        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("{} executed in {} ms", proceedingJoinPoint.getSignature().getName(), executionTime);

        return proceed;
    }
}
