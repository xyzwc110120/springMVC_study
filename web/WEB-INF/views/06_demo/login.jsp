<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<html>
<head>
    <link href="<c:url value="/framework/layui/css/layui.css"/>" rel="stylesheet" />
    <title>登陆</title>
</head>
<body>
<%-- 进入登陆页面时注销 session --%>
<% session.invalidate(); %>

<div class="layui-card">
    <div class="layui-card-header">
        <span style="font-size: larger">用户登陆</span>&nbsp;&nbsp;&nbsp;
        <span style="color: red">${errorMsg}</span>
    </div>
    <div class="layui-card-body">
        <form action="<c:url value="/demo/login/login"/>" method="post" class="layui-form">
            <input name="id" value="${member.id}" hidden />
            <div class="layui-form-item">
                <label class="layui-form-label">账号</label>
                <div class="layui-input-block">
                    <input name="account" value="${member.account}" type="text" placeholder="请输入账号" required
                           lay-verify="required" class="layui-input" />
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input name="password" value="${member.password}" type="text" placeholder="请输入密码" required
                           lay-verify="required" class="layui-input" />
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
