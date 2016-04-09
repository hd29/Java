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
<div class="addSurvey" style="height: 600px;">

<div style="background: blue;width:1040px;height: 20px;">
 <span style="position: absolute;left: 20px;"># ${requestScope.title }   </span>   
 <span style="position: absolute;right: 190px;">修改标题   </span>   
 <span style="position: absolute;right: 60px;">

<a href="addQuestion.jsp?surveyId=<s:property value="#request.surveyId" /> " > 添加问题</a> 

</span>
<%   
String a = request.getParameter("surveyId");%> 

</div><br>
		<div class="Question">
<form action="saveOptin.action" method="get">
           <input type="hidden" name="surveyId" value=<%=a%>>
			<s:iterator value="questionsList" var="q">
				<div style="background: blue; width: 1000px; height: 20px;">
					<span style="position: absolute; left: 20px;"> <s:property
							value="#q.title" /></span> <span
						style="position: absolute; right: 190px;">修改问题 </span> <span
						style="position: absolute; right: 60px;"> 删除问题 </span>
				</div>
				<s:if test="#q.type== 1">

					<input type="radio" name='<s:property value="#q.id" />'
						value="1" />
					<s:property value="#q.option1" />
					<br>
					<input type="radio" name='<s:property value="#q.id" />'
						value="2" />
					<s:property value="#q.option2" />
					<br>
					<input type="radio" name='<s:property value="#q.id" />'
						value="3" />
					<s:property value="#q.option3" />
					<br>
					<input type="radio" name='<s:property value="#q.id" />'
						value="4" />
					<s:property value="#q.option4" />
				</s:if>

				<s:if test="#q.type== 2">
					
						<input type="checkbox" name='<s:property value="#q.id" />' value="1" >
						<s:property value="#q.option1" /><br>
						<input type="checkbox" name='<s:property value="#q.id" />' value="2">
						<s:property value="#q.option2" /><br>
						<input type="checkbox" name='<s:property value="#q.id" />' value="3">
						<s:property value="#q.option3" /><br>
						<input type="checkbox" name='<s:property value="#q.id" />' value="4">
						<s:property value="#q.option4" /><br>
					
				</s:if>
			</s:iterator>
			<br>
			<br>
			<div style="background: blue; width: 1000px; height: 20px;">
				</div>
			<table align="center" width="500px">
			<tr>
			<th ><input type="submit" value="提交调查"></th>
			<th ><input type="button" value="取消调查"></th>
			</tr>
            </table>
            <br>
          
</form>
		</div>

	</div>
</body>
</html>