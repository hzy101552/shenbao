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
<link href="${pageContext.request.contextPath}/css/shouye.css"
	rel="stylesheet" type="text/css" />
<title>项目申报管理系统</title>
<STYLE type=text/css>
.leftnav {
	background-color: #BFE1FD;
	background-repeat: no-repeat;
	background-position: 10px;
	padding-left: 28px;
	height: 80px;
	line-height: 25px;
	border: solid 1px #FFFFFF;
	cursor: pointer;
}
</style>
</head>
<body bgcolor="#ccddee">

	<div class="container">
		<div class="header">
			<div style="float: left;"><h2>项目申报平台</h2></div>
			<div style="float: left;width: 300px;height: 40px;"></div>
			<div class="welcome">
				<span>欢迎 ${userName}</span> &nbsp;&nbsp;<span>教师工号：${snumber}</span>
				&nbsp;&nbsp;<a href="login.jsp">退出</a>
			</div>
		</div>
	</div>
	<div>
		<div style="float: left; height: 100px;">
			<table cellspacing=0 cellpadding=0 border=0 height="100%" width="142"
				align="center">
				<tr>
					<td valign="top">
						<table width="100%" border=0 align=center cellpadding=0
							cellspacing=0 id="mnuList" style="height: 100%">
							<tr>
								<td bgcolor=#F7f7f7 id=outLookBarShow style="HEIGHT: 100%"
									valign=top align=middle name="outLookBarShow">


									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="138" height="28" align="center" bgcolor="#5293D3"
												style="color: #FFFFFF; font-size: 20px; font-weight: bold;">功能菜单</td>
										</tr>
									</table>
									<table width="138" cellpadding="3" cellspacing="1"
										bgcolor="#87B4E0">

										<tr>
											<td height="30" bgcolor="#5293D3"><strong
												style="color: #FFFFFF">&nbsp;&nbsp;教师页面</strong></td>
										</tr>
										<tr>
											<td class="leftnav" height="20%"><a href="t_shouye">首页</a></td>
										</tr>

										<tr>
											<td height="32" class="leftnav"><a href="teacherinfo">个人信息</a></td>
										</tr>
										<tr>
											<td height="28" class="leftnav"><a href="user">修改密码</a></td>
										</tr>
										<tr>
											<td height="28" class="leftnav"><a href="applyProjectT">项目列表</a></td>
										</tr>
										<tr>
											<td height="28" class="leftnav"><a href="myProjectT">我的项目</a></td>
										</tr>
										<tr height="20%">
											<td height="28" class="leftnav"><a href="tup">文件上传</a></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td width="3px" bgcolor="#5293D3" height="100%">
						<table border=0 align="center" cellpadding=0 cellspacing=0>
							<tr>
								<td width="100%" align=middle valign="center" height="100%"><span
									class='np' id='switchPoint' title="打开/关闭导航"
									style="font-family: Webdings;">3</span></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>

		<div style="float: left; width: 80%; height: 100%;">
			<!-- 文件主体 -->
			<form id="updatePassword" action="updatePw">
				<table width="400px" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="160px">教师工号：</td>
						<td><input type="text" name="snumber"
							value="${user.snumber }" disabled="disabled"></td>
					</tr>
					<tr>
						<td width="160px">姓名：</td>
						<td><input type="text" name="username"
							value="${user.username }" disabled="disabled"></td>
					</tr>
					<tr>
						<td width="160px">密码：</td>
						<td><input type="text" name="password"
							value="" size="22"></td>
					</tr>
					<tr>
						<td width="160px">确认密码：</td>
						<td><input type="password" name="password2" value=""
							size="22"></td>
					</tr>
				</table>
				<input class="button" type="submit" value="修改">
			</form>
		</div>
	</div>
</body>
</html>