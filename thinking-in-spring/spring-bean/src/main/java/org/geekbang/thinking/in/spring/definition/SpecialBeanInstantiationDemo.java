package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.factory.UserFactory;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊的Bean实例
 *
 * @author: 晴天
 * @date: 2020/3/26 23:06
 * @description: 1.0
 */
public class SpecialBeanInstantiationDemo {


    public static void main(String[] args) {
        // 通过AutowireCapableBeanFactory 来实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("classpath:/MATE-INFO/bean-special-context.xml");
        AutowireCapableBeanFactory capableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        DefaultUserFactory bean = capableBeanFactory.createBean(DefaultUserFactory.class);
        bean.createUser();

        // 通过ServicesLoader来实例化
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext
//                ("classpath:/MATE-INFO/bean-special-context.xml");
//        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServicesLoader", ServiceLoader.class);
//        displayServicesLoader(serviceLoader);
//        demoServicesLoader();
    }

    public static void demoServicesLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServicesLoader(serviceLoader);
    }


    public static void displayServicesLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }


}
