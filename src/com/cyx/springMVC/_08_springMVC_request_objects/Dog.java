package com.cyx.springMVC._08_springMVC_request_objects;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Dog {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
