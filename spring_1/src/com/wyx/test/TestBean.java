package com.wyx.test;

import com.wyx.bean.*;
import com.wyx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    @Test
    public void testAdd() {
        //BeanFactory是Spring的内部使用接口
        //加载配置文件的时候不会创建对象，在获取对象(getBean)时才去创建对象
//        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");

        //ApplicationContext是BeanFactory的子接口，
        //加载配置文件时就会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //获取创建的对象，对于BeanFactory来说是在这一步创建对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testBook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book.getBauthor());
        System.out.println(book.getBname());
    }

    @Test
    public void testOrder() {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
            Order order = context.getBean("order", Order.class);
            System.out.println(order.getAddress());
            System.out.println(order.getOname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBook_p() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Book book = context.getBean("book_p", Book.class);
        System.out.println(book.getBauthor());
        System.out.println(book.getBname());
    }

    @Test
    public void testService() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testEmp() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean7.xml");
        Emp emp = applicationContext.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void testCollection() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean10.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }

    @Test
    public void testUDFCollection() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean9.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
}
