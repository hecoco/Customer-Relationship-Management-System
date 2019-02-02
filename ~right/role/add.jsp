<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="${pageContext.request.contextPath }/html/css/style.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath }/html/html/script/common.js"></script>
		<script src="${pageContext.request.contextPath }/html/script/validate.js"></script>
	</head>
	<body>
		<div class="page_title">
			权限管理 > 用户管理 > 系统角色管理 > 添加角色
		</div>
		<form action="role!add" method="post">
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<!-- <button class="common_button" onclick="back();">
					返回
				</button> -->
				<button class="common_button" onclick="add();">
					保存
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					 <th>
						编号
					</th>
					<td>
						<input type="text" disabled="true" size="20">
					</td> 
					<th>
						角色名
					</th>
					<td>
						<input  name="role.roleName" size="20" />
					</td>
				</tr>
				<tr>
					<th>
						角色描述
					</th>
					<td>
						<textarea name="role.roleDesc" size="20"></textarea>
					</td>
					<th>
						状态
					</th>
					<td>
						<select name="role.roleFlag">
	   						<option value="1">正常</option>
	   						<!-- <option <s:if test="#request.sys.roleFlag == 2">selected='selected'</s:if> value="2">禁用</option> -->
	   					</select>
					</td>
				</tr>
			</table>
			<script>
				build_validate("sysRole.roleName","角色名不能为空","Limit","1","50");
				build_validate("sysRole.roleDesc","角色描述不能为空","Limit","1","50");
			</script>
		</form>
	</body>
</html>
