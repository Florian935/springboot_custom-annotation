package com.florian935.customannotation.annotation.logbefore;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogBeforeAspect {

    @Before(value = "@annotation(LogBefore) and args(name)")
    @SneakyThrows
    void logBefore(JoinPoint joinPoint, String name) {

        log.info("This message is printed before the message of the method. The name is: {}", name);
    }
}
