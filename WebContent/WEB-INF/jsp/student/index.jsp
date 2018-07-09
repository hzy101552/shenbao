<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script> 
<title>项目申报管理系统</title>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	background-image: url("${pageContext.request.contextPath}/images/tbg.png");
	background-repeat: inherit;
	/* background-color: rgba(93,213,200,0.6); */
    background-image-size:100% 100%;
}
</style>

</head>
<body>
	<div class="container">
		<div class="header" >
			<div style="float: left;"><h2>项目申报平台</h2></div>
			<!-- <div style="float: left;width: 300px;height: 40px;"></div> -->
			<div class="welcome">
				<span>欢迎 ${userName}</span> &nbsp;&nbsp;<span>学号：${snumber}</span> &nbsp;&nbsp;<a href="login.jsp">退出</a>
			</div>
		</div>
		<div class="middle">
			<div class="nav">
		    <ul class="ul">
		        <li><a href="shouye">首页</a></li>
		        <li><a href="studentinfo?id=${id}">个人信息</a></li>
		        <li><a href="user">修改密码</a></li>
		        <li><a href="applyproject">项目列表</a></li>
		        <li><a href="myProject">申报项目</a></li>
		        <li><a href="up">文件上传</a></li>
		    </ul>
			</div>
		</div>
	</div>
</body>
</html>