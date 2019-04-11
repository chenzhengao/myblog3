<%--
  Created by IntelliJ IDEA.
  User: 97948
  Date: 2019/4/10
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h1>登录页面</h1>
<form action="../myblog/login" method="post">
 用户名：<input type="text" name="name">
    密码：<input type="password" name="psw">
    <input type="submit" value="登录">
</form>
</body>
</html>
