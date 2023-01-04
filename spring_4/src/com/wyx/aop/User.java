package com.wyx.aop;

import org.springframework.stereotype.Component;

//被增强类
@Component //先创建被增强类对象
public class User {
    //后续会对add方法进行逻辑增强
    public void add() {
//        System.out.println(1/0);
        System.out.println("add...");
    }
}
