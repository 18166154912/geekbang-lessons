package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 的初始化 Demo
 *
 * @author: 晴天
 * @date: 2020/3/27 15:56
 * @description: 1.0
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();


        // 依赖查找
        applicationContext.getBean(UserFactory.class);
        applicationContext.close();
    }


    @Bean(initMethod = "initUserFactory")
    public UserFactory userFactory() {
        return new DefaultUserFactory();

    }


}
