<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="<c:url value="/upload/file"/>" method="post" enctype="multipart/form-data">
        <label>姓名：<input name="name" type="text" /></label><br />
        <label>年龄：<input name="age" type="number" /></label><br />
        <label>头像：<input name="file" type="file"></label><br />

        <input type="submit" value="提交" />
    </form>
</body>
</html>
