package com.wyx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component //创建增强类对象
@Aspect //开启代理，此时是无接口形式，相当于创建了被增强类（User）子类的代理对象，此时UserProxy相当于User的一个子类，类中可以写增强逻辑
@Order(2) //多个增强类增强相同的方法，设置优先级，即执行的顺序
public class UserProxy {
    //在该增强类中创建不同方法以代表不同通知类型
    //前置通知
//    @Before(value = "execution(* com.wyx.aop.User.add(..))")
//    public void before() {
//        System.out.println("before");
//    }

    //后置通知，有异常就不执行
//    @AfterReturning(value = "execution(* com.wyx.aop.User.add(..))")
//    public void afterReturning() {
//        System.out.println("afterReturning");
//    }

    //最终通知，不管有无异常均执行
//    @After(value = "execution(* com.wyx.aop.User.add(..))")
//    public void after() {
//        System.out.println("after");
//    }

    //异常通知，有异常才会执行
//    @AfterThrowing(value = "execution(* com.wyx.aop.User.add(..))")
//    public void afterThrowing() {
//        System.out.println("afterThrowing");
//    }

    //环绕通知
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        //执行被增强的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }

    //抽取相同的切入点
    @Pointcut(value = "execution(* com.wyx.aop.User.add(..))")
    public void pointDemo() {}
}
