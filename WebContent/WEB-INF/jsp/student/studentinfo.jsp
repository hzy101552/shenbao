<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/content.css" >
<title>项目申报管理系统</title>
</head>
<body bgcolor="#ccddee">
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<form id="updateInfoForm" action="update">
	    <table width="400px" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	            <td width="160px">学号：</td>
	            <td><input type="text" name="snumber" value="${student.snumber }" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">姓名：</td>
	            <td><input type="text" name="name" value="${student.name }" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">性别：</td>
	            <td><input type="text" name="sex" value="${student.sex }" size="22" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">院系班级：</td>
	            <td><input type="text" name="college" value="${student.college }" size="22" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">辅导员：</td>
	            <td><input type="text" name="tutor" value="${student.tutor }" size="22" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">联系电话：</td>
	            <td><input type="text" name="phone" value="${student.phone }" size="22" ></td>
	        </tr>
	
	        <tr>
	            <td width="160px">邮箱：</td>
	            <td><input type="email" name="email" value="${student.email }" size="22"></td>
	        </tr>
	    </table>
	    <input class="button" type="submit" value="修改">
	</form>
</body>
</html>