package org.geekbang.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基于 XML 资源的依赖 Setter 方法注入示例
 *
 * @author: cLearDay
 * @date: 2020/4/22
 * @version: 1.0
 */
public class XmlDependencySetterInjectionDemo {


    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);


        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-setter-injection.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        UserHolder bean = beanFactory.getBean(UserHolder.class);
        System.out.println(bean);
    }

}
