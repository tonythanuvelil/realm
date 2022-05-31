package com.seven.realm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Slf4j
@Configuration
public class TimedAspect {

    @Around(value = "@annotation(com.seven.realm.annotations.Timed)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Starting {}", joinPoint);
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long elapsed = (System.currentTimeMillis() - startTime);
        log.info("Completed {} in {}ms", joinPoint, elapsed);
        return object;
    }
}
