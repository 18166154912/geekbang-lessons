package org.geekbang.thinking.in.spring.factory;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link User}Bean 的{@link org.springframework.beans.factory.FactoryBean}的实现
 *
 * @author: 晴天
 * @date: 2020/3/26 23:42
 * @description: 1.0
 */
public class UserFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
