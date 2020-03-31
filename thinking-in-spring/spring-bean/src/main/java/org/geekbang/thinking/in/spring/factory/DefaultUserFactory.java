package org.geekbang.thinking.in.spring.factory;

import org.springframework.beans.factory.InitializingBean;
import reactor.core.Disposable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: 晴天
 * @date: 2020/3/26 23:35
 * @description: 1.0
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, Disposable {

    // 1：基于PostConstruct 注解实现
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct：UserFactory 开始初始化");

    }


    public void initUserFactory() {
        System.out.println("自定义初始化方法 initUserFactory ：UserFactory 开始初始化");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet ：UserFactory 开始初始化");

    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy：UserFactory 销毁中");
    }

    @Override
    public void dispose() {
        System.out.println("@DisposableBean#destroy()：UserFactory 销毁中");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前对象DefaultUserFactory 正在回收");


    }

}
