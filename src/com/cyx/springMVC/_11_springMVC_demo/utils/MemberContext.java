package com.cyx.springMVC._11_springMVC_demo.utils;

import com.cyx.springMVC._11_springMVC_demo.domain.Member;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

// 封装当前登录用户的上下文信息
public class MemberContext {

    private static final String MEMBER_IN_SESSION = "member_in_session";

    /**
     * 获取 Session 对象
     *
     * @return Session 对象
     */
    public static HttpSession getSession() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    /**
     * 设置当前的用户信息至 session 中
     *
     * @param member 用户对象
     */
    public static void setCurrentMember(Member member) {
        if (member == null) {
            // 若用户为空，则注销 session
            getSession().invalidate();
        } else {
            // 若不为空，则存入 session
            getSession().setAttribute(MEMBER_IN_SESSION, member);
        }
    }

    /**
     * 获取当前 session 对象中的用户信息
     *
     * @return Member 对象
     */
    public static Member getCurrentMember() {
        return (Member) getSession().getAttribute(MEMBER_IN_SESSION);
    }
}
