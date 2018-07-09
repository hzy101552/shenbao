<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/content.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
<title>项目申报管理系统</title>
</head>
<body>
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<form id="addProject" action="addProject" onsubmit="return checkRegister(this)">
	    <table width="400px" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	            <td width="160px">项目名称：</td>
	            <td><input type="text" name="project_name" size="22"></td>
	        </tr>
	        <tr>
	            <td width="160px">项目类别：</td>
	            <td>
	            <select name="project_category" 
					style="font-size: 16px; line-height: 15px; color: #000000" >
						<option value="创新项目">创新项目</option>
						<option value="科技项目">科技项目</option>
				</select>
	            </td>
	        </tr>
	        <tr>
	            <td width="160px">学生学号：</td>
	            <td><input type="text" name="snumber" value="${student.snumber }" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">学生姓名：</td>
	            <td><input type="text" name="student_name" value="${student.name }" size="22"  readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">所在院系：</td>
	            <td><select name="college" 
					style="font-size: 16px; line-height: 15px; color: #000000" >
						<option value="软件学院">软件学院</option>
						<option value="计算机通信与工程学院">计算机通信与工程学院</option>
						<option value="政法学院">政法学院</option>
						<option value="物理学院">物理学院</option>
				</select>
				</td>
	        </tr>
	        <tr>
	            <td width="160px">指导教师：</td>
	            <td><input type="text" name="t_Name" size="22"></td>
	        </tr>
	        <tr>
	            <td width="160px">填报时间：</td>
	            <td><input type="text" name="createtime" size="22"><span style="color: red; font-size: 15px;">例如：2018-04-12</span></td>
	        </tr> 
	        <tr>
	            <td width="160px">预期成果：</td>
	            <td><input type="text" name="result" size="22"></td>
	        </tr> 
	        <tr>
	            <td width="160px">申请经费：</td>
	            <td><input type="text" name="funds"" size="22"></td>
	        </tr>
	        <tr>
	            <td width="160px">项目成员：</td>
	            <td><input type="text" name="team" size="22"></td>
	        </tr>
	        <tr>
	            <td width="160px">审核状态：</td>
	            <td><select name="status" 
					style="font-size: 16px; line-height: 15px; color: #000000">
						<option value="未审核">未审核</option>
				</select>
				</td>
	        </tr>
	        <tr>
	            <td width="160px">项目简介：</td>
	            <td><textarea name="introduction" rows="8" cols="30"></textarea></td>
	        </tr>
	        <tr>
	            <td width="160px">研究内容：</td>
	            <td><textarea name="research_contents" rows="8" cols="30"></textarea></td>
	        </tr>
	        <tr>
	            <td width="160px">实施方案：</td>
	            <td><textarea name="plan" rows="8" cols="30"></textarea></td>
	        </tr>
	    </table>
	    <input class="button" type="submit" value="提交">
	</form>
</body>
</html>