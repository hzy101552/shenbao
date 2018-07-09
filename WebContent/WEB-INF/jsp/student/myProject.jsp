<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/content.css" >
<title>项目申报管理系统</title>
</head>
<body>
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<form id="myProject" action="">
	    <table width="70%" border="0" align="center" cellspacing="1" cellpadding="3">
	        <tr>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>项目名称</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>项目类别</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>申请人</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>所在院系</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>指导教师</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>操作</b></font></th>
	        </tr>
	        <c:forEach items="${myProjects}" var="project">
	        <tr>
	            <td><input type="text" name="" value="${project.project_name}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${project.project_category}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${project.student_name}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${project.college}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${project.t_Name}" readonly="readonly"></td>
	            <td>
	            	<a href="projectXiang?project_name=${project.project_name}"> <img border="0" src="images/xiang.png"
					width="100px" height="40px"></a>
				</td>
	        </tr>
	        </c:forEach>
	    </table>
	    <div class="text-tip"><a href="register">申请新的项目</a></div>
	</form>
</body>
</html>