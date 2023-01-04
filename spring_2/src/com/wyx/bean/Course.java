package com.wyx.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Course {

    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
        System.out.println("第二步调用set方法");
    }

    public Course() {
        System.out.println("第一步执行无参构造创建bean对象");
    }

    public void initMethod() {
        System.out.println("第三步执行初始化方法");
    }

    public void destroyMethod() {
        System.out.println("第五步执行销毁方法");
    }
}
