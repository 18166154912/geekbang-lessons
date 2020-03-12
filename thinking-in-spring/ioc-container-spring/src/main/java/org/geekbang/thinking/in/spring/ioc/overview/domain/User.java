package org.geekbang.thinking.in.spring.ioc.overview.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户类
 *
 * @author: 晴天
 * @date: 2020/2/12 22:01
 * @description: 1.0
 */
@Getter
@Setter
public class User {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
