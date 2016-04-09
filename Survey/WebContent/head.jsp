<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="ccs/styles.css">
</head>
<body bgcolor="silver">

	<div class="head0">
		<h1 style="position: absolute;top: 50px;left: 400px" >survey系统</h1>
		
		<s:if test="#session.userId!=null">
		<h4 style="position: absolute;bottom: 0px">用户名:${sessionScope.username}</h4>
		<h4 style="position: absolute;bottom: 0px;left:160px">用户编号:${sessionScope.userId}</h4>
	    <h4 onclick="" style="position: absolute;bottom: 0px;right:50px"><s:a href="exit.action">退出登录</s:a></h4>
	    </s:if>
	    <s:else>
	    <h4 style="position: absolute;bottom: 0px"><s:a href="index.jsp">您还未登录，请登录</s:a></h4>
	    </s:else>
	    
	    
	</div>

	<div class="head1">
		&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="index1.jsp"><font>[首页]</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="querySurvey.action">[我的调查]</a>&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="addSurvey.jsp">[发布调查]</a>&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="queryAllSurvey.action">[参与调查]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="adminLogin.jsp">[后台登陆]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
</body>
</html>