package com.yys.pojo;

import java.util.Objects;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/20/14:22
 */
public class User {
    private  String name;
    private  String address;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress());
    }
}
