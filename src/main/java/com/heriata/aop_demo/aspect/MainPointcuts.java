package com.heriata.aop_demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MainPointcuts {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerPointcut() {}

    @Pointcut("@annotation(com.heriata.aop_demo.annotations.ListAnno)")
    public void listPointcut() {}
}
