<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/addT.js"></script>
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
	<form id="addTeacher" action="addTeacher" onsubmit="return checkAddT(this)">
	    <table width="400px" border="0" cellspacing="0" cellpadding="0">
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">教师工号：</td>
	            <td><input type="text" name="tnumber"></td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">姓名：</td>
	            <td><input type="text" name="name"</td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">性别：</td>
	            <td>
	            	<select name="sex" 
					style="font-size: 16px; line-height: 15px; color: #000000" >
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
	            </td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">院系：</td>
	            <td>
	            	<select name="college" 
					style="font-size: 16px; line-height: 15px; color: #000000" >
						<option value="软件学院">软件学院</option>
						<option value="计算机通信与工程学院">计算机通信与工程学院</option>
						<option value="政法学院">政法学院</option>
						<option value="物理学院">物理学院</option>
					</select>
	            </td>
	        </tr>
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">联系电话：</td>
	            <td><input type="text" name="phone"></td>
	        </tr>
	
	        <tr style="height: 50px;font-size: 15px;">
	            <td width="160px">邮箱：</td>
	            <td><input type="email" name="email"></td>
	        </tr>
	    </table>
	    <input class="button" type="submit" value="确定">
	</form>
	
	<form id="upaddT" action="upaddT" method="post" enctype="multipart/form-data">
		<input type="file"  name="mFile"/> 
		<input type="submit" value="提交"/>
	</form>
</body>
</html>