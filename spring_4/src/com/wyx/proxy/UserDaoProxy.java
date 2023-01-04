package com.wyx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDaoProxy implements InvocationHandler {
    //创建的是谁(i.e. 接口实现类UserDaoImpl)的代理类对象，就把谁传进来
    //有参构造传递
    //参数类型为UserDaoImpl也可以，只不过现在这样写更通用
    private Object object;

    public UserDaoProxy(Object obj) {
        this.object = obj;
    }

    //加入增强逻辑
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        //方法之前
//        System.out.println(o); //会报错
        System.out.println("方法之前执行: " + method.getName() + " :传递的参数..." + Arrays.toString(args));
        //被增强的方法执行
//        Object res = method.invoke(object, objects);
        Object res = null;
        if ("add".equals(method.getName())) {
            res = 2 * (int) args[0] + (int) args[1];
        } else {
            //名为update
            res = args[0] + "***";
        }
        //方法之后
        System.out.println("方法之后执行..." + object);
        return res;
    }
}
