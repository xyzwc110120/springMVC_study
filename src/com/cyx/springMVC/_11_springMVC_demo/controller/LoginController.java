package com.cyx.springMVC._11_springMVC_demo.controller;

import com.cyx.springMVC._11_springMVC_demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo/login")
public class LoginController {

    private MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/06_demo/login";
    }

    @RequestMapping("/login")
    public String login(Model model, String account, String password) {
        try {
            memberService.login(account, password);
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "/06_demo/login";
        }
        return "redirect:/demo/member/toMemberList";
    }

}