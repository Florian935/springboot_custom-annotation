package com.florian935.customannotation.annotation.logafter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAfterAspect {

    @After("@annotation(LogAfter) and args(name)")
    void logAfter(JoinPoint joinPoint, String name) {

        log.info("This message is printed after the message of the method. The name is: {}", name);
    }
}
