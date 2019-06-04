package com.cyx.springMVC._11_springMVC_demo.service;

import com.cyx.springMVC._11_springMVC_demo.domain.Member;

import java.util.List;

public interface MemberService {

    void login(String account, String password);

    List<Member> getMemberList();

    Member getMemberById(Long id);

    void addOrUpdateMember(Member member);

    void deleteMember(Long id);

}
