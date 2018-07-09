<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<title>登录</title>
<script type="text/javascript">
	function change(img) {
		img.src = "/shenbao/servlet/authImg?id=" + Math.random();
	}

	
</script>
</head>
<body>
	<div class="header"></div>
	<br>
	<br>
	<div class="login_student">
		<div class="login_title">
			<h2 align="center">登录申报系统</h2>
		</div>
		<!-- <div class="login_tab">
			<span class="span_student cur">学生登录</span> <span class="span_teacher">教师登录</span>
		</div> -->

		<div>
			<center>
				<span style="color: red; font-size: 15px;">${error}</span>
			</center>
		</div>

		<div >
		<center>
			<form action="login" method="post" onsubmit="return checkLogin(this)">

				<table>
					<tr>
						<td>账号：</td>
						<td><input type="text" name="snumber"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>验证码:</td>
						<td><input type="text" name="authCode" style="width: 100px"
							onblur="checkAuthCode(this)"> <img
							src="/shenbao/servlet/authImg" onclick="change(this)"> </td>
					</tr>
					<div>
						<center>
							<span id="span" style="color: red;"></span>
						</center>
					</div>
					<!-- <tr><td colspan="2" align="center"><span id="span" style="color: red;"></span></td>
					</tr> -->
					<script type="text/javascript">
					function checkAuthCode(input) {
						if (input.value == "" || input.value == null) {
							$("#span").text("验证码不能为空");
						} else {
							$.ajax({
								type : "post",
								url : "checkAuthCode",
								data : {
									"authCode" : input.value
								},
								dataType : "text",
								success : function(data) {
									$("#span").text(data);
								}
							});
						}
					}
					</script>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="登录"></td>
					</tr>
			</form>
			</center>
		</div>
	</div>
</body>
</html>