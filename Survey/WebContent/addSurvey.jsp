<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>发布调查</title>
</head>
 <body>
<div class="addSurvey" style="height: 600px;">

<div class="addQuestion" >

<form action="addSurvey.action" method="get">
<table align="center" height="20px" width="300px" border="1px" cellspacing="0px" style="position: absolute;top: 90px;left: 80px;">
<tr align="center">
<td><font size="5">发布调查</font></td>
</tr>
<tr align="center">
<td>标题：<input type="text" name="title"></td>
</tr>
<tr align="center">
<td>状态：<input type="text" name="state"></td>
</tr>
<tr align="center">
<td ><input type="button" value="取消">
&nbsp;&nbsp;
<input type="submit" value="发布">
</td>
</tr >
</table>
</form>
	</div>
</div>

</body>
</html>