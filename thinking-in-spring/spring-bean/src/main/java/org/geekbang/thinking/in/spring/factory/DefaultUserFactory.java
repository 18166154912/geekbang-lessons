package org.geekbang.thinking.in.spring.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author: 晴天
 * @date: 2020/3/26 23:35
 * @description: 1.0
 */
public class DefaultUserFactory implements UserFactory , InitializingBean {

    // 1：基于PostConstruct 注解实现
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct：UserFactory 开始初始化");

    }


    public void initUserFactory(){
        System.out.println("自定义初始化方法 initUserFactory ：UserFactory 开始初始化");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet ：UserFactory 开始初始化");

    }
}
