package com.wyx.test;


import com.wyx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    @Test
    public void testTransferMoney() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //repeat: 一定要和UserService类创建的对象名称一致
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferMoney();
    }

    @Test
    public void testTransactionTransferMoney() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
//        userService.transferMoney();
        userService.insertUser();
    }
}
