package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 晴天
 * @date: 2020/3/26 23:06
 * @description: 1.0
 */
public class BeanInstantiationDemo {


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext
                ("classpath:/MATE-INFO/bean-instantiation-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);


        System.out.println(user);


    }


}
