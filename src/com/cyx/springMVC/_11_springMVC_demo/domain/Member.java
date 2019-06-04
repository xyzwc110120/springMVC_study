package com.cyx.springMVC._11_springMVC_demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class Member {

    private Long id;
    private String account;
    private String password;
    private Integer balance;
    private Date createTime;

}
