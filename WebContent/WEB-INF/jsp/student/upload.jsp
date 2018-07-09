<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/content.css">
<title>项目申报管理系统</title>
<style type="text/css">
li {
	display: inline-block;
	list-style: none;
	margin: 0 auto;
	width: 50px;
}
</style>
</head>
<body>
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<center>
		<span style="color: red; font-size: 30px;">文件的命名方式应与自己的项目名一致</span>
	</center>
	<form id="" action="">
		<table width="70%" border="0" align="center" cellspacing="1"
			cellpadding="3">
			<tr>
				<th valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>文件名称</b></font></th>
				<th valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>上传者</b></font></th>
				<th valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>上传者学号</b></font></th>
				<th valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>操作</b></font></th>
			</tr>
			<c:forEach items="${FileList}" var="FileList">
				<tr>
					<td><input type="text" value="${FileList.fileName}"
						readonly="readonly"></td>
					<td><input type="text" value="${FileList.sName}"
						readonly="readonly"></td>
					<td><input type="text" value="${FileList.snumber}"
						readonly="readonly"></td>
					<td><a href="download?fileName=${FileList.fileName}"> <img
							border="0" src="images/xiang.png" width="100px" height="40px"></a></td>
				</tr>
				<!-- <script>
				function down() {
				window.location.href = "download?fileName=${FileList.fileName}";
				} -->
	</script>
			</c:forEach>
		</table>s
	</form>


	

	<form id="upload" action="upload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="mFile" /> <input type="submit" value="提交" />
	</form>
</body>
</html>