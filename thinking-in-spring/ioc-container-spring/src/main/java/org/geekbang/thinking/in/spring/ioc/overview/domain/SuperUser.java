package org.geekbang.thinking.in.spring.ioc.overview.domain;

/**
 * @author: 晴天
 * @date: 2020/2/12 22:41
 * @description: 1.0
 */
@Super
public class SuperUser extends User {

    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
