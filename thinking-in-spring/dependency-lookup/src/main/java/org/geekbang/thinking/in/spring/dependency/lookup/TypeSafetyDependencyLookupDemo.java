package org.geekbang.thinking.in.spring.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全 依赖查找示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @author: 晴天
 * @date: 2020/4/15 22:49
 * @description: 1.0
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);

        applicationContext.refresh();

        // 演示 BeanFactory 的 getBean的安全性 报错
        displayBeanFactoryGetBean(applicationContext);
        // 演示ObjectFactory 的 getObject方法的安全性 报错
        displayObjectFactoryGetObject(applicationContext);
        // 演示ObjectProviderIfAvailable 的 getObject方法的安全性
        displayObjectProviderIfAvailable(applicationContext);
        // 演示listableBeanFactory 的 getBeanOfType 的 getObject方法的安全性
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        // 演示ObjectProvider Stream 操作的安全性
        displayObjectProviderStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps", () -> userObjectProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactoryGetBeansOfType", () ->
                beanFactory.getBeansOfType(User.class)
        );
    }


    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        // objectProvider
        ObjectProvider<User> getIfAvailable = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderIfAvailable", () ->
                getIfAvailable.getIfAvailable()
        );
    }


    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> userObjectProvider  = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", () ->
                userObjectProvider.getObject()
        );

    }


    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean", () ->
                beanFactory.getBean(User.class)
        );
    }

    public static void printBeansException(String source, Runnable runnable) {
        System.err.println("===================");
        System.err.println("source from" + source);
        try {
            runnable.run();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }


}
