package org.geekbang.thinking.in.spring.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.security.Provider;
import java.util.Map;

/**
 * 通过 {@link Provider} 进行依赖查找
 *
 * @author: 晴天
 * @date: 2020/4/8 22:31
 * @description: 1.0
 */
public class ObjectProviderDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();


        lookupByObjectProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookUpByStreamOps(applicationContext);
        applicationContext.close();

    }


    public static void lookUpByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        beanProvider.stream().forEach(System.out::println);
    }

    public static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {

        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        User user = beanProvider.getIfAvailable(() -> User.createUser());
        System.out.println("user 对象:" + user);

    }


    @Bean
    @Primary
    public String helloWorld() {
        return "hello world";
    }

    @Bean
    public String helloWorld2() {
        return "hello world2";
    }


    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
//        ListableBeanFactory listableBeanFactory = applicationContext.getBeanFactory();
//        Map<String, String> beansMap = listableBeanFactory.getBeansOfType(String.class);
//        beansMap.forEach((x, y) -> {
//            System.out.println("key：" + x + "value：" + y);
//        });

        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }


}
