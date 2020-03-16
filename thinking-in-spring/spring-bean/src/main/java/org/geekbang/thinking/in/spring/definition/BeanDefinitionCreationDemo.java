package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition 构建示例 }
 *
 * @author: 晴天
 * @date: 2020/3/16 22:02
 * @description: 1.0
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        // 1:beanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("age", "18");
        beanDefinitionBuilder.addPropertyValue("name", "晴天");
        // 获取实例 beanDefinition
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // beanDefinition并非Bean的终态 可以自定义修改


        // 2: 通过AbstractBeanDefinition派生
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValues批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("age", "18");
//        propertyValues.addPropertyValue("name", "晴天");
        propertyValues.add("age", "18")
                .add("name", "晴天");
        genericBeanDefinition.setPropertyValues(propertyValues);


    }


}
