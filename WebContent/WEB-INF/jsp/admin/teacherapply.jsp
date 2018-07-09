<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目申报管理系统</title>
<style type="text/css">
	table{
    margin: 0px auto;
}

td{
    text-align: left;
}
input{
    height: 33px;
    width: 180px;
    border: 1px solid aquamarine;
}
form{
    text-align: center;
}

li{
	display: inline-block;
	list-style: none;
	margin: 0 auto;
	width: 50px;
}
th{
font-size: 22px;
}
	</style>
</head>
<body>
	<jsp:include page="index.jsp" flush="true"></jsp:include>
	<center><span style="font-size: 30px;">教师详情</span></center>
	<!-- 文件主体 -->
	<form id="updateInfoForm" action="updateTeacher">
				<table width="400px" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="160px">教师工号：</td>
						<td><input type="text" name="snumber"
							value="${teacher.tnumber }" ></td>
					</tr>
					<tr>
						<td width="160px">姓名：</td>
						<td><input type="text" name="name" value="${teacher.name }"
							></td>
					</tr>
					<tr>
						<td width="160px">性别：</td>
						<td><input type="text" name="sex" value="${teacher.sex }"
							size="22" ></td>
					</tr>
					<tr>
						<td width="160px">院系：</td>
						<td><input type="text" name="college"
							value="${teacher.college }" size="22" ></td>
					</tr>
					<tr>
						<td width="160px">联系电话：</td>
						<td><input type="text" name="phone" value="${teacher.phone }"
							size="22"></td>
					</tr>

					<tr>
						<td width="160px">邮箱：</td>
						<td><input type="email" name="email"
							value="${teacher.email }" size="22"></td>
					</tr>
				</table>
				<input class="button" type="submit" value="修改">
			</form>
</body>
</html>