package com.wyx.dao;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("执行add方法");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("执行update方法");
        return id;
    }
}
