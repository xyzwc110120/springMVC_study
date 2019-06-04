package com.cyx.springMVC._10_springMVC_date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/date")
public class HandleDateController {

    // 从前端往后台传递参数，String 类型转换成 java.util.Date 类型
    @RequestMapping("/now")
    public void now(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, Member member) {
        System.out.println(date);
        System.out.println(member);
    }

    // 返回 JSON 格式的 Date 类型数据
    @RequestMapping("/returnDateOfJson")
    @ResponseBody
    public Member returnDateOfJson(Member member) {
        return member;
    }

}
