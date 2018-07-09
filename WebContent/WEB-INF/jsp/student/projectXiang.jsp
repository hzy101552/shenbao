<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/content.css" >
<title>项目申报管理系统</title>
</head>
<body bgcolor="#ccddee">
	<jsp:include page="index.jsp" flush="true"></jsp:include>

	<!-- 文件主体 -->
	<form id="" action="">
	    <table width="400px" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	            <td width="160px">项目名称：</td>
	            <td><input type="text" name="project_name" value="${projectXiang.project_name}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">项目类别：</td>
	            <td><input type="text" name="project_category" value="${projectXiang.project_category}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">申请人：</td>
	            <td><input type="text" name="student_name" value="${projectXiang.student_name}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">指导教师：</td>
	            <td><input type="text" name="t_Name" value="${projectXiang.t_Name}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">填报时间：</td>
	            <td><input type="text" name="createtime" value="${projectXiang.createtime}" size="22" readonly="readonly"></td>
	        </tr> 
	        <tr>
	            <td width="160px">预期成果形式：</td>
	            <td><input type="text" name="result" value="${projectXiang.result}" size="22" readonly="readonly"></td>
	        </tr> 
	        <tr>
	            <td width="160px">申请经费：</td>
	            <td><input type="text" name="funds" value="${projectXiang.funds}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">项目组成员：</td>
	            <td><input type="text" name="team" value="${projectXiang.team}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">审核状态：</td>
	            <td><input type="text" name="status" value="${projectXiang.status}" size="22" readonly="readonly"></td>
	        </tr>
	        <tr>
	            <td width="160px">项目简介：</td>
	            <td><textarea name="introduction" rows="8" cols="30">${projectXiang.introduction}</textarea></td>
	        </tr>
	        <tr>
	            <td width="160px">研究内容：</td>
	            <td><textarea name="research_contents" rows="8" cols="30">${projectXiang.research_contents}</textarea></td>
	        </tr>
	        <tr>
	            <td width="160px">实施方案：</td>
	            <td><textarea name="plan" rows="8" cols="30">${projectXiang.plan}</textarea></td>
	        </tr>
	        <tr>
	            <td width="160px">教师评价：</td>
	            <td><textarea name="evaluat" rows="8" cols="30" readonly="readonly">${projectXiang.evaluat}</textarea></td>
	        </tr>
	    </table>
	</form>
</body>
</html>