<%--
  Created by IntelliJ IDEA.
  User: 王杰
  Date: 2019/3/15
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/addUser.do" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="pwd"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
