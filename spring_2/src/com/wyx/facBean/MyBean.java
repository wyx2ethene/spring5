package com.wyx.facBean;

import com.wyx.bean.Course;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course> {
    //定义返回的bean的类型
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    //控制返回的对象是否为单例对象
    public boolean isSingleton() {
        return false;
    }
}
