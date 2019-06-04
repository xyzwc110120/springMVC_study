<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>文件下载</title>
</head>
<body>
    <a href="<c:url value="/download/downloadByServlet"/>">下载 1</a><br />
    <a href="<c:url value="/download/downloadByMVC"/>">下载 2</a>
</body>
</html>
