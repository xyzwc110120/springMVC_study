<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="<c:url value="/framework/layui/css/layui.css"/>" rel="stylesheet" />
    <title>用户表单</title>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">
        <h3>用户表单</h3>
    </div>
    <div class="layui-card-body">
        <form action="<c:url value="/demo/member/addOrUpdateMember"/>" method="post" class="layui-form">
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
                <label class="layui-form-label">余额</label>
                <div class="layui-input-block">
                    <input name="balance" value="${member.balance}" type="number" placeholder="请输入余额" required
                           lay-verify="required" class="layui-input" />
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <a href="<c:url value="/demo/member/toMemberList"/>" class="layui-btn layui-btn-warm">返回</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
