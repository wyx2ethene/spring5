package com.wyx.service;

import com.wyx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional //事务添加到Service层，添加到类上，为类中所有方法添加事务，也可以添加到具体的方法上
public class UserService {
    @Autowired
    private UserDao userDao;

    //创建转账的方法
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transferMoney() {
        //少钱
        userDao.reduceMoney();
        //中途异常
//        int i = 1 / 0;
        //多钱
        userDao.addMoney();
        //异常
//        throw new RuntimeException("异常");

    }
}
