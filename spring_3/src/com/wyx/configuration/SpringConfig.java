package com.wyx.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//完全注解开发
@Configuration //该注解用于替代xml文件
@ComponentScan(basePackages = {"com.wyx"}) //开启组件扫描
public class SpringConfig {
}
