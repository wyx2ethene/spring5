package com.wyx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TotalService {
    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String userId, String userStatus) {
        logService.addLog(userId, userStatus);
        userService.transferMoney();
//        int i = 1 / 0;
    }
}
