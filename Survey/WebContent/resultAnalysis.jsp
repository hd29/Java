<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <jsp:include page="head.jsp"></jsp:include>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示我的调查</title>
</head>
<body>
<div class="addSurvey" >

<div align="center" style="background: blue;width:1040px;">
<font size="5"># ${requestScope.title }</font>
 
</div><br>
		<!-- <div class="Question"> -->

			<s:iterator value="questionsList" var="q">
				
				<table align="center" border="1px" cellspacing="0px" width="1000px" bgcolor="blue" >
				<tr><th width="1000px"><s:property value="#q.title" /></th></tr>
				</table>
				<table align="center" border="1px" cellspacing="0px" width="1000px">
				
				<tr>
				<th width="250px"><s:property value="#q.option1" /></th>
				<th width="250px"><s:property value="#q.option2" /></th>
				<th width="250px"><s:property value="#q.option3" /></th>
				<th width="250px"><s:property value="#q.option4" /></th>
                </tr>
				<tr>
				<th width="250px"><s:property value="#q.answer1" /></th>
				<th width="250px"><s:property value="#q.answer2" /></th>
				<th width="250px"><s:property value="#q.answer3" /></th>
				<th width="250px"><s:property value="#q.answer4" /></th>
                </tr>
				</table><br>
			</s:iterator>
		</div>
<!-- 	</div> -->
</body>
</html>