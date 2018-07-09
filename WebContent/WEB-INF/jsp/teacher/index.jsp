<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/content.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<title>项目申报管理系统</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="welcome">
				<span>欢迎 ${userName}</span> &nbsp;&nbsp;<span>教师工号：${snumber}</span>
				&nbsp;&nbsp;<a href="login.jsp">退出</a>
			</div>
		</div>
		<div class="middle">
			<div class="nav">
				<ul class="ul">
					<li><a href="t_shouye">首页</a></li>
					<li><a href="teacherinfo">个人信息</a></li>
					<li><a href="user">修改密码</a></li>
					<li><a href="applyProjectT">项目列表</a></li>
					<li><a href="myProjectT">我的项目</a></li>
					<li><a href="tup">文件上传</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>