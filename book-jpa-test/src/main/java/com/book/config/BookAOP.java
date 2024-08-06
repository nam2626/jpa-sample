package com.book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class BookAOP {
    @Around("execution(* com.book.repository.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log: " + joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        System.out.println("Result: " + result);
        return result;
    }
}
