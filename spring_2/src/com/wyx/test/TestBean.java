package com.wyx.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.wyx.bean.Course;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    @Test
    public void testFactoryBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //用factoryBean的方式，在配置文件中定义的bean类型(MyBean)可以和返回的bean类型(Course)不一样
        Course course1 = context.getBean("myBean", Course.class);
        Course course2 = context.getBean("myBean", Course.class);
        System.out.println(course1);
        System.out.println(course2);
    }

    @Test
    public void testLifecycle() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Course course = context.getBean("course", Course.class);
        System.out.println("第四步获取创建的bean对象");
        System.out.println(course);
        //手动让bean对象销毁，不写的话不会执行销毁
        context.close();
    }

    @Test
    public void testDruid() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getVersion());
    }
}
