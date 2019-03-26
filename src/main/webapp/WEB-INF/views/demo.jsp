<%--
  Created by IntelliJ IDEA.
  User: chenzhengao
  Date: 2019/3/15
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%--isELIgnored 为true时，会忽略EL表达式--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
 ${requestScope.test1}
</body>
</html>
