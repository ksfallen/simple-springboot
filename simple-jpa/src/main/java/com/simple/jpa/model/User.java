package com.simple.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User: Jfeng
 * Date: 2017/6/1
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String address2;
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
}
