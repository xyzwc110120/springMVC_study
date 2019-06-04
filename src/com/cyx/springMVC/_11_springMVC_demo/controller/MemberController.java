package com.cyx.springMVC._11_springMVC_demo.controller;

import com.cyx.springMVC._11_springMVC_demo.domain.Member;
import com.cyx.springMVC._11_springMVC_demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @RequestMapping("/toMemberList")
    public String getMemberList(Model model) {
        model.addAttribute("memberList", memberService.getMemberList());
        return "/06_demo/memberList";
    }

    @RequestMapping("/toMemberDetail")
    public String getMemberById(Model model, Long id) {
        if (id != null) {
            model.addAttribute(memberService.getMemberById(id));
        }
        return "/06_demo/memberDetail";
    }

    @RequestMapping("/addOrUpdateMember")
    public String addOrUpdateMember(Member member) {
        memberService.addOrUpdateMember(member);
        return "redirect:/demo/member/toMemberList";
    }

    @RequestMapping("/deleteMemberById")
    public String deleteMemberById(Long id) {
        memberService.deleteMember(id);
        return "redirect:/demo/member/toMemberList";
    }

}
