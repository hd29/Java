<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的调查</title>
<link rel="stylesheet" type="text/css" href="ccs/styles.css">
</head>

<body>
	<div class="mySurvey">
		<div style="background: blue; width: 1040px; height: 20px;">
			<span style="position: absolute; left: 20px;">标题</span> 
			<span style="position: absolute; right: 190px;">状态</span> 
			<span style="position: absolute; right: 60px;"> 创建时间</span>
			<span style="position: absolute; right: 320px;"> 参与人数</span>
			<span style="position: absolute; left: 400px;"> 发布者</span>
		</div>
		<br>
		<s:iterator value="surveysList" var="c">
              
			<div style="background: blue; width: 1040px; height: 22px;">
				<span style="position: absolute; left: 20px;">
				<s:property
						value="#c.title" />
				</span>
				<span
					style="position: absolute; right: 190px;"><s:property
						value="#c.state" /></span> 
				<span style="position: absolute; right: 60px;"><s:property
						value="#c.Id" /> </span>
				<span style="position: absolute; right: 320px;">
				
                                            参与人数
                
                </span>

				<span style="position: absolute; right: 450px;">
				 <a href="<s:url action="queryAnswerQuestions.action">
                <s:param name="surveyId" value="#c.Id">
                </s:param>
                 <s:param name="title" value="#c.title" />
                 </s:url>" > 参与调查 </a> 
				 
				 </span>
				<span style="position: absolute; left: 400px;">
				发布者
				 </span>
			</div>
			<br>
		
		</s:iterator>
		
	</div>

</body>
</html>