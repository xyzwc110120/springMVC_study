package com.cyx.springMVC._11_springMVC_demo.dao;

import com.cyx.springMVC._11_springMVC_demo.domain.Member;

import java.util.List;

public interface MemberDAO {

    Member getMemberByAccountAndPassword(String account, String password);

    List<Member> getMemberList();

    Member getMemberById(Long id);

    void insertMember(Member member);

    void updateMember(Member member);

    void deleteMemberById(Long Id);

}
