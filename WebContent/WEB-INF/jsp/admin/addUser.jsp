<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/addU.js"></script>
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
    width: 200px;
    border: 1px solid aquamarine;
}
form{
    text-align: center;
}
.button{
    width: 100px;
    height: 40px;
    margin: 20px;
    background-color: chartreuse;
    text-align: center;
}
	</style>
</head>
<body bgcolor="#ccddee">
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<form id="addUser" action="addUser" onsubmit="return checkAddU(this)">
	    <table width="400px" border="0" cellspacing="0" cellpadding="0">
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">工号：</td>
	            <td><input type="text" name="snumber"></td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">用户名：</td>
	            <td><input type="text" name="username"></td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">密码：</td>
	            <td><input type="text" name="password"></td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">用户类型：</td>
	            <td>
	            	<select name="user_type" 
					style="font-size: 16px; line-height: 15px; color: #000000" >
						<option value="学生">学生</option>
						<option value="教师">教师</option>
						<option value="管理员">管理员</option>
					</select>
	            </td>
	        </tr>
	    </table>
	    <input class="button" type="submit" value="确定">
	</form>
	
	<form id="upadd" action="upadd" method="post" enctype="multipart/form-data">
		<input type="file"  name="mFile"/> 
		<input type="submit" value="提交"/>
	</form>
</body>
</html>