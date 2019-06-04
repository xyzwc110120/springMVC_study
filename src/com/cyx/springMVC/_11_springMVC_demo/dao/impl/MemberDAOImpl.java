package com.cyx.springMVC._11_springMVC_demo.dao.impl;

import com.cyx.springMVC._11_springMVC_demo.dao.MemberDAO;
import com.cyx.springMVC._11_springMVC_demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    // jdbc 模板类
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    /*
        注意：
            public <T> List<T> queryForList(String sql, Class<T> elementType)
                和
            queryForObject(String sql, Object[] args, Class<T> requiredType) 方法：
                只能返回单列，不能返回多列，否则产生异常：
                    IncorrectResultSetColumnCountException: Incorrect column count: expected 1, actual 5
                    错误的结果集列数异常：错误的列数，预期列数为 1，实际列数为 5


                而参数 elementType 和 requiredType 则是返回的该列的类型（所以这两个参数只能是简单类型），
                如果我们如果查询的是多列，并且需要转化成指定复杂类型的对象，
                我们需要实现 RowMapper 接口或直接使用 RowMapper 的实现类来完成。
    */

    @Override
    public Member getMemberByAccountAndPassword(String account, String password) {
        return jdbcTemplate.queryForObject(
                "SELECT id, account, password, balance, create_time createTime FROM member WHERE account = ? AND password = ?",
                new String[] {account, password},
                new BeanPropertyRowMapper<>(Member.class));
    }

    @Override
    public List<Member> getMemberList() {

        return jdbcTemplate.query(
                "SELECT id, account, password, balance, create_time createTime FROM member ORDER BY createTime DESC",
                new BeanPropertyRowMapper<>(Member.class));
    }

    @Override
    public Member getMemberById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, account, password, balance, create_time createTime FROM member WHERE id = ?",
                new Long[]{id},
                new BeanPropertyRowMapper<>(Member.class));
    }

    @Override
    public void insertMember(Member member) {
        jdbcTemplate.update(
                "INSERT INTO member (account, password, balance, create_time) VALUES (?, ?, ?, NOW())",
                member.getAccount(), member.getPassword(), member.getBalance());
    }

    @Override
    public void updateMember(Member member) {
        jdbcTemplate.update(
                "UPDATE member SET account = ?, password = ?, balance = ?, create_time = NOW() WHERE id = ?",
                member.getAccount(), member.getPassword(), member.getBalance(), member.getId());
    }

    @Override
    public void deleteMemberById(Long id) {
        jdbcTemplate.update("DELETE FROM member WHERE id = ?", id);
    }
}