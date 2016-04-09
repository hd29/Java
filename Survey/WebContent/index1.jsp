<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>问卷调查系统</title>
</head>


 
<div class="login">
<div class="login_inter">
<form action="login" method="GEt">
<br>
<p align="center">用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" name="username"></p>
<p align="center">登陆密码：<input type="password" name="password"></p>
<p align="center">
&nbsp;
<input type="submit" value="登陆">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置">
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register.jsp">新用户注册</a>
</p>
</form>
</div>
</div>
</body>
</html>