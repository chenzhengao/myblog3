<%--
  Created by IntelliJ IDEA.
  User: 97948
  Date: 2019/4/4
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>单图片上传</title>
</head>
<body>
<fieldset>
    <legend>图片上传</legend>
    <h2>只能上传单张1M以下的 PNG、JPG、GIF 格式的图片</h2>
    <form action="../myblog/image/getThumbnial" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="imgFile">
        <input type="submit" value="上传">
    </form>
</fieldset>
</body>
</html>
