package org.geekbang.thinking.in.spring.definition;

import org.geekbang.thinking.in.spring.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 垃圾回收 （GC） 实例
 *
 * @author: 晴天
 * @date: 2020/3/31 21:43
 * @description: 1.0
 */
public class BeanGarbageControllerDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();




        applicationContext.close();
        System.gc();
    }


}
