package com.wyx.proxy;

import com.wyx.dao.UserDao;
import com.wyx.dao.UserDaoImpl;

import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        //参数1. 类加载器
        //参数2. 增强方法所在的类所实现的接口
        //参数3. 实现这个接口InvocationHandler，创建代理对象，并在其中加入增强部分
        //下面的写法相当于 接口=接口实现类的代理对象
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces,
                new UserDaoProxy(userDao));
        // 以下一行代码会报错java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to com.wyx.dao.UserDaoImpl
//        UserDao dao = (UserDaoImpl) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        String result = dao.update("001");
        System.out.println(result);
    }
}
