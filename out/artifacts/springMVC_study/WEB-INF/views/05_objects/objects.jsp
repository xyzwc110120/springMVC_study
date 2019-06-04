<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>多对象传参</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/request/objects/objects" method="post">
        <label>狗狗姓名：<input type="text" name="dog.name" /></label><br />
        <label>狗狗年龄：<input type="text" name="dog.age" /></label><br />
        <label>猫猫姓名：<input type="text" name="cat.name" /></label><br />
        <label>猫猫年龄：<input type="text" name="cat.age" /></label><br />
        <input type="submit" value="提交" />
    </form>
</body>
</html>
