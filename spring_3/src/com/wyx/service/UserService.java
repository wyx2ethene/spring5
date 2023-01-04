package com.wyx.service;

import com.wyx.dao.UserDao;
import com.wyx.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//基于注解方式注入属性
//@Autowired: 根据属性类型自动装配
//第一步添加注解，给service和dao创建对象
//第二步在service中添加注解，注入dao属性
//@Component(value = "userService")
@Service(value = "userService")
public class UserService {
    //首先声明dao属性
    //添加注解实现属性注入
    //不需要set方法
//    @Autowired
//    @Qualifier(value = "userDaoImpl1") //该注解和Autowired一起使用，value值与UserDaoImpl类上的注解中的value值相同
//    @Resource //可根据类型或者名称注入
    @Resource(name = "userDaoImpl1")
    //同时写Autowired,Qualifier和Resource，可以
    //同时写Qualifier和Resource，可以
    //同时写Autowired和Resource，可以
    private UserDao userDao;

    @Value(value = "abc") //注入普通类型属性
    private String name;
    public void add() {
        System.out.println("service add...");
        userDao.add();
        System.out.println(name);
    }
}
