package com.zhang.springboot.model;

/**
 * @author Zhangkj
 * @date 2019-05-04-16:43
 */
public class User {

    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
