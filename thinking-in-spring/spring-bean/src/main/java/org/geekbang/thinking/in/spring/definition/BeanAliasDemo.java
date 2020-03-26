package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 *
 * @author: 晴天
 * @date: 2020/3/25 23:05
 * @description: 1.0
 */
public class BeanAliasDemo {


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:MATE-INFO/bean-definitions-context.xml");
        User user = beanFactory.getBean("clearday-user", User.class);

        System.out.println(user.toString());

    }
}
