package com.wyx.service;

import com.wyx.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {
    @Autowired
    private LogDao logDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addLog(String id, String status) {
        logDao.addLog(id, status);
        throw new RuntimeException("异常");
    }
}
