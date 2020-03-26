package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 注解的bean definition的demo
 *
 * @author: 晴天
 * @date: 2020/3/26 22:20
 * @description: 1.0
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {


    public static void main(String[] args) {
        // 创建beanFactory实例
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(Config.class);
        // 1: 通过@Bean的方式 定义
        // 2: 通过@Component的方式定义
        // 3: 通过@Import导入

        applicationContext.refresh();

        Map<String, Config> beansOfType = applicationContext.getBeansOfType(Config.class);
        System.out.println("User 类型的所有Bean"+ applicationContext.getBeansOfType(User.class));
        System.out.println("Config 类型的所有Bean"+ applicationContext.getBeansOfType(Config.class));
        Config config = beansOfType.get("annotationBeanDefinitionDemo.Config");
        System.out.println(config.user());

        // 显示的 关闭上下文
        applicationContext.close();

    }

    @Component
    public static class Config {

        @Bean(name = {"user","clear-user"})
        public User user() {
            User user = new User();
            user.setId(1);
            user.setName("clearDay");
            return user;
        }

    }

}
