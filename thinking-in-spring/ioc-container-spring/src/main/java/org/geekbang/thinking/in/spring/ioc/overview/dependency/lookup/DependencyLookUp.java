package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.domain.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author: 晴天
 * @date: 2020/2/12 20:44
 * @description: 1.0
 */
public class DependencyLookUp {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INFO/dependency-lookUp-context.xml");
        // 实时
        lookupToRealTime(beanFactory);
        // 延迟
        lookupInLazy(beanFactory);
        // 按照类型
        lookupByType(beanFactory);
        // 复杂类型
        lookCollectionUpType(beanFactory);
        // 通过注解查找
        lookupAnnotationType(beanFactory);
    }

    private static void lookupAnnotationType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(users);
        }
    }

    /**
     * 复杂类型
     * @param beanFactory
     */
    private static void lookCollectionUpType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(userMap.get("user"));
        }
    }

    /**
     * 类型查找
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    /**
     * 延时查找
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }


    /**
     * 实时查找
     * @param beanFactory
     */
    private static void lookupToRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user.toString());
    }


}
