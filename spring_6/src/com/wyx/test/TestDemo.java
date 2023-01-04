package com.wyx.test;

import com.wyx.config.TxConfig;
import com.wyx.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {
    @Test
    public void testTransactionConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferMoney();
    }
}
