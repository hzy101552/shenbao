<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<title>项目申报管理系统</title>
<style type="text/css">
	table{
    margin: 0px auto;
}

td{
    text-align: left;
}
body{
	margin: 0;
	padding: 0;
	background-image: url("${pageContext.request.contextPath}/images/bg.png");
	background-repeat: no-repeat;
	background-color: rgba(93,213,200,0.6);
    background-image-size:100% 100%;
}
	</style>
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0" >
	<div class="header">
			<div style="float: left;"><h2>项目申报平台</h2></div>
			<div class="welcome">
				<span>欢迎 ${userName}</span> &nbsp;&nbsp;<span>工号：${snumber}</span> &nbsp;&nbsp;<a href="login.jsp">退出</a>
			</div>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td background="${pageContext.request.contextPath}/images/dh_bg.gif" align="left" height="10">
				<table align="center" width="10px" border="0" margin: 0px auto;>
					<tr>
						<td width="20%"></td>
						<td width="10%"><a href="student"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image1','','images/index_on.gif',1)">
								<img name="Image1" border="0" src="${pageContext.request.contextPath}/images/xsxx.gif" width="90"
								height="36">
						</a></td>
						<td width="10%"><a href="teacher"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image2','','images/reg_on.gif',1)">
								<img name="Image2" border="0" src="${pageContext.request.contextPath}/images/jsxx.gif" width="92"
								height="36">
						</a></td>
						<td width="10%"><a href="userinfo"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image4','','images/carts_on.gif',1)">
								<img name="Image4" border="0" src="${pageContext.request.contextPath}/images/yhxx.gif" width="92"
								height="36">
						</a></td>
						<td width="10%"><a href="adds"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image5','','images/order_on.gif',1)">
								<img name="Image5" border="0" src="${pageContext.request.contextPath}/images/tjxs.gif" width="92"
								height="36">
						</a></td>
						<td width="10%"><a href="addt"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image6','','images/exit_on.gif',1)">
								<img name="Image6" border="0" src="${pageContext.request.contextPath}/images/tjjs.gif" width="92"
								height="36">
						</a></td>
						<td width="10%"><a href="addu"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image6','','images/exit_on.gif',1)">
								<img name="Image6" border="0" src="${pageContext.request.contextPath}/images/tjyh.gif" width="92"
								height="36">
						</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>