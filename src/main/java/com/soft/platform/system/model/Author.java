/*
 * Copyright (c)
 */
package com.soft.platform.system.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 作者类
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-11-05 23:02
 */
public class Author  implements Serializable {
    /**
     * 作者名称
     */
    private String userName;
    /**
     * 年龄
     */
    private int age;
    /**
     * 头像
     */
    private MultipartFile image;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
