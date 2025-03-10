package com.heriata.aop_demo.aspect;

import com.heriata.aop_demo.model.MainModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Aspect
@Component
public class MainAspect {

    @AfterReturning(value = "MainPointcuts.controllerPointcut()", returning = "result")
    public void afterReturningController(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        log.info("-------- Data AfterReturning Controller Aspect --------");
        log.info("method name: {}", name);
        log.info("result: {}", result);
    }

    @Around("MainPointcuts.controllerPointcut()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("-------- Time_Measuring Around Aspect --------");
        log.info("time: {}ms", end - start);
        return proceed;
    }

    @AfterReturning(value = "MainPointcuts.listPointcut()", returning = "result")
    public void afterReturningList(JoinPoint joinPoint, Object result) {
        List<MainModel> list = (List<MainModel>) result;
        log.info("-------- List_Size AfterReturning Aspect --------");
        log.info("size: {}", list.size());
    }
}
