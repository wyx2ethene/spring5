package com.wyx.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
//也用于增强User类
public class PersonProxy {
    @Before(value = "execution(* com.wyx.aop.User.add(..))")
    public void before() {
        System.out.println("before...");
    }
}
