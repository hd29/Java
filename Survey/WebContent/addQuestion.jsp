<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ccs/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>发布调查</title>
</head>
<body bgcolor="teal">

<%   
String a = request.getParameter("surveyId");%>
<%-- cccccccc:<%=a%> --%>

<div class="addQuestion">
<form action="addQuestion" method="post" >
<br>
     <input type="hidden" name="surveyId" value=<%=a%> >
<table align="center" width="400px" height="100px" border="1px"
  cellspacing="0px">

<tr>
<th>#问题题干：<input type="text" name="qtitle"></th>
</tr>
<tr>
<th>#选项类型： <input type="text" name="optype"></th>
</tr>
<tr>
<th>问题选项1： <input type="text" name="option1"></th>
</tr>
<tr>
<tr>
<th>问题选项2： <input type="text" name="option2"></th>
</tr>
<tr>
<tr>
<th>问题选项3： <input type="text" name="option3"></th>
</tr>
<tr>
<tr>
<th>问题选项4： <input type="text" name="option4"></th>
</tr>
<tr>
<th> <input type="submit" value="添加">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置">
</th>
</tr>
</table>
</form>
</div>
</body>
</html>