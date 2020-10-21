package com.binblink.javase.io.File;

import java.io.Serializable;


public class Person implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;//显式的给定类的serialVersionUID，保证不会因为各种版本问题出错

    private String name;

    private transient String address;

    private String sex;

    private int age;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", sex=" + sex
                + ", age=" + age + "]";
    }


}
