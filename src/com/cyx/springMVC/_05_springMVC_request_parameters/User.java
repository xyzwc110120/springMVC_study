package com.cyx.springMVC._05_springMVC_request_parameters;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class User {

    private List<Long> ids;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "ids=" + ids +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
