package com.cyx.springMVC._11_springMVC_demo.service.impl;

import com.cyx.springMVC._11_springMVC_demo.dao.MemberDAO;
import com.cyx.springMVC._11_springMVC_demo.domain.Member;
import com.cyx.springMVC._11_springMVC_demo.service.MemberService;
import com.cyx.springMVC._11_springMVC_demo.utils.MemberContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }


    @Transactional(readOnly = true)
    @Override
    public void login(String account, String password) {
        try {
            // 将用户信息存入 session
            MemberContext.setCurrentMember(memberDAO.getMemberByAccountAndPassword(account, password));
        } catch (IncorrectResultSizeDataAccessException e) {
            // 若没有查找到对应用户信息，返回错误信息
            throw new RuntimeException("账号或密码错误");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> getMemberList() {
        return memberDAO.getMemberList();
    }

    @Transactional(readOnly = true)
    @Override
    public Member getMemberById(Long id) {
        return memberDAO.getMemberById(id);
    }

    @Override
    public void addOrUpdateMember(Member member) {
        if (member.getId() == null) {
            memberDAO.insertMember(member);
        } else {
            memberDAO.updateMember(member);
        }
    }

    @Override
    public void deleteMember(Long id) {
        memberDAO.deleteMemberById(id);
    }
}
