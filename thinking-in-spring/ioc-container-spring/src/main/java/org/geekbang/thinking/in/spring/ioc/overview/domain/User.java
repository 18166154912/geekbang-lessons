package org.geekbang.thinking.in.spring.ioc.overview.domain;

/**
 * 用户类
 *
 * @author: 晴天
 * @date: 2020/2/12 22:01
 * @description: 1.0
 */
public class User {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
