<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body bgcolor="green">

<div style="position:absolute;top:122px;left:269px;">
<form action="/coursetest/Loginservlet" method="GEt">
<p>用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" name="username"></p>
<p>登陆密码：<input type="password" name="password"></p>
<p>
&nbsp;
<input type="submit" value="登陆">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置">
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register.jsp">新用户注册</a>
</p>
</form>
</div>
</body>
</html>