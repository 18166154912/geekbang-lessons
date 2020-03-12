package org.geekbang.thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 *  IOC 容器事例
 *
 * @author: 晴天
 * @date: 2020/3/2 22:36
 * @description: 1.0
 */
public class IocContainerDemo {


    public static void main(String[] args) {
        // 创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:META-INFO/dependency-lookUp-context.xml";

        int i = reader.loadBeanDefinitions(location);

        System.out.println(i);

//        -----------

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(IocContainerDemo.class);
        // 启动
        applicationContext.refresh();

    }



}
