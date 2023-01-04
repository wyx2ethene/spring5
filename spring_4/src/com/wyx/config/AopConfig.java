package com.wyx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.wyx")
@EnableAspectJAutoProxy(proxyTargetClass = true)
//完全注解开发
public class AopConfig {

}
