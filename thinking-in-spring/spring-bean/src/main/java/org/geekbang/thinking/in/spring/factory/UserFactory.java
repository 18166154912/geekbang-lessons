package org.geekbang.thinking.in.spring.factory;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link org.geekbang.thinking.in.spring.ioc.overview.domain.User} user 工厂类
 *
 * @author: 晴天
 * @date: 2020/3/26 23:12
 * @description: 1.0
 */
public interface UserFactory {


    default User createUser(){
        return User.createUser();
    }


}
