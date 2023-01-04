package com.wyx.junit;


import com.wyx.config.TxConfig;
import com.wyx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TxConfig.class)
public class TestJUnit5 {
    @Autowired
    private UserService userService;
    @Test
    public void test() {
        userService.transferMoney();
    }
}
