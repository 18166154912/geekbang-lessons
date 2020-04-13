package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 晴天
 * @date: 2020/2/12 20:44
 * @description: 1.0
 */
public class DependencyInjection {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INFO/dependency-injection-context.xml");
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(userRepository.toString());

        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());


    }


    private static void whoIsIocContainer(BeanFactory beanFactory, UserRepository userRepository) {

        System.out.println(userRepository.getObjectFactory() == beanFactory);


    }


}
