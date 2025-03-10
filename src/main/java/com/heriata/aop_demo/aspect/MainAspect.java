package com.heriata.aop_demo.aspect;

import java.util.List;

import com.heriata.aop_demo.model.MainModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MainAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerPointcut() {}

    @Pointcut("@annotation(com.heriata.aop_demo.annotations.ListAnno)")
    public void listPointcut() {}

    @AfterReturning(value = "controllerPointcut()", returning = "result")
    public void afterReturningController(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        log.info("-------- Data AfterReturning Controller Aspect --------");
        log.info("method name: {}", name);
        log.info("result: {}", result);
    }

    @Around("controllerPointcut()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("-------- Time_Measuring Around Aspect --------");
        log.info("time: {}ms",end - start);
        return proceed;
    }

    @AfterReturning(value = "listPointcut()", returning = "result")
    public void afterReturningList(JoinPoint joinPoint, Object result) {
        List<MainModel> list = (List<MainModel>) result;
        log.info("-------- List_Size AfterReturning Aspect --------");
        log.info("size: {}", list.size());
    }
}
