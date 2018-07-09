<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    width: 180px;
    border: 1px solid aquamarine;
}
form{
    text-align: center;
}

li{
	display: inline-block;
	list-style: none;
	margin: 0 auto;
	width: 50px;
}
th{
font-size: 22px;
}
	</style>
</head>
<body>
	<jsp:include page="index.jsp" flush="true"></jsp:include>
	<center><span style="font-size: 30px;">用户信息</span></center>
	<!-- 文件主体 -->
	<form id="" action="">
	    <table width="60%" border="0" align="center" cellspacing="1" cellpadding="3">
	        <tr>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>工号</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>用户名</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>密码</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width=""><font color="#ffffff"><b>用户类型</b></font></th>
	            <th valign=middle align=center height=25 background="images/bg2.gif"
				width="100px" colspan="2"><font color="#ffffff"><b>操作</b></font></th>
	            
	        </tr>
	        <c:forEach items="${pageu.userList}" var="userList">
	        <tr>
	            <td><input type="text" name="" value="${userList.snumber}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${userList.username}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${userList.password}" readonly="readonly"></td>
	            <td><input type="text" name="" value="${userList.userType}" readonly="readonly"></td>
	            <td><a
				href="deleteUser?snumber=${userList.snumber}"><center>删除</center></a></td>
	        </tr>
	        </c:forEach>
	    </table>
	    
	    <!--分页 -->
	<div style="width: 100%;  margin-top: 50px;" align="center">
		<ul style="text-align: center; margin-top: 10px; vertical-align: middle;">
			<!-- 上一页 -->
			<!-- 判断当前页是否是第一页 -->
			<c:if test="${pageu.currentPage==1}">
				<li>
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageu.currentPage!=1}">
				<li>
					<a href="${pageContext.request.contextPath}/userinfo?currentPage=${pageu.currentPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>	
			<c:forEach begin="1" end="${pageu.totalPage}" var="page1">
				<!-- 判断当前页 -->
				<c:if test="${pageu.currentPage==page1}">
					<li class="active"><a href="javascript:void(0);">${page1}</a></li>
				</c:if> 
				<c:if test="${pageu.currentPage!=page1}">
					<li><a href="${pageContext.request.contextPath}/userinfo?currentPage=${page1}">${page1}</a></li>
				</c:if>
			</li>
			</c:forEach>
			
			<!-- 判断当前页是否是最后一页 -->
			<c:if test="${pageu.currentPage==pageu.totalPage}">
				<li>
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageu.currentPage!=pageu.totalPage}">
				<li>
					<a href="${pageContext.request.contextPath}/userinfo?currentPage=${pageu.currentPage+1}" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
		
		</ul>
	</div>
	</form>
</body>
</html>