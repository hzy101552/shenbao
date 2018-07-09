<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/content.css" >
<title>项目申报管理系统</title>

</head>

<body bgcolor="#ccddee">
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<form id="updatePassword" action="updatePw">
	    <table width="400px" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	            <td width="160px">学号：</td>
	            <td><input type="text" name="snumber" value="${user.snumber }" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">姓名：</td>
	            <td><input type="text" name="username" value="${user.username }" disabled="disabled"></td>
	        </tr>
	        <tr>
	            <td width="160px">手机号：</td>
	            <td><input type="text" name="phone" id="phone" onblur="button1()">
	            <!-- <input type="button" name="button" onclick="button1()" value="注册码"/> --></td>
	        </tr>
	        <script type="text/javascript">
	        function button1(){
	        	debugger;
	        		var phone1=document.getElementById("phone").value;
	        		//alert(phone+"11");
	        		$.post("code", { phone: phone1});
	        	}
			</script>
	        <tr>
	            <td width="160px">密码：</td>
	            <td><input type="text" name="password" value="" size="22"></td>
	        </tr>
	        <tr>
	            <td width="160px">确认密码：</td>
	            <td><input type="password" name="password2" value="" size="22"></td>
	        </tr>
	        <tr>
	            <td width="160px">验证码：</td>
	            <td><input type="text" name="code" value="" ></td>
	        </tr>
	    </table>
	    <input class="button" type="submit" value="修改">
	</form>
</body>
</html>