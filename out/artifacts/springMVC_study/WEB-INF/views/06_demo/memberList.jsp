<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<html>
<head>
    <link href="<c:url value="/framework/layui/css/layui.css"/>" rel="stylesheet" />
    <title>用户列表</title>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">
        <span style="font-size: larger">用户列表</span>&nbsp;&nbsp;&nbsp;
        <span>登录用户：${member_in_session.account}</span>
        <a type="submit" href="<c:url value="/demo/login/toLogin"/>" class="layui-btn layui-btn-radius layui-btn-warm">注销</a>
    </div>
    <div class="layui-card-body">
        <a type="submit" href="<c:url value="/demo/member/toMemberDetail"/>" class="layui-btn layui-btn-radius">新增</a><br />
        <table class="layui-table">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>账号</td>
                    <td>余额</td>
                    <td>创建时间</td>
                    <td>操作</td>
                </tr>
            </thead>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.account}</td>
                    <td>${member.balance}</td>
                    <td>${member.createTime}</td>
                    <td>
                        <a href="<c:url value="/demo/member/toMemberDetail?id=${member.id}"/>" class="layui-btn layui-btn-radius layui-btn-normal">修改</a>
                        <a href="<c:url value="/demo/member/deleteMemberById?id=${member.id}"/>" class="layui-btn layui-btn-radius layui-btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
