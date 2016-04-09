<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
<script type="text/JavaScript" src="jQuery/test.js" charset="GBK"></script>
	

  </head>
  
  <body>
	<form action="actionU_register.action" method="get">
		<table border="1px" cellspacing="0px" align="center">
			<tr>
				<th>用户注册</th>
			</tr>
			<tr>
				<th>ID：<input id="i" type="text" name="userid" />
				<p id="result">${msg}</p>
				</th>
			</tr>
			<tr>
				<th>账户：<input id="un" type="text" name="username" />
				
				</th>
				
			</tr>
			<tr>
				<th>密码：<input id="ps" type="password" name="password" />
				</th>
			</tr>
			<tr>
				<th>确认：<input id="rm" type="password" name="password1" />
				<p id="pass2">密码不一致！</p>
				</th>
			</tr>
			<tr>
				<th><input type="submit" value="注册" /> <a href="login.jsp">登录</a>
				</th>
			</tr>

		</table>

	</form>


</body>
</html>
