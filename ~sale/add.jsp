<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
</head>
<body>
<form method="post" action="../../chance!add">
<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" type="submit" >保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input type="hidden" name="sc.chcCreateId" value="${applicationScope.u.role.roleId}"/></td>
		<th>机会来源</th>
		<td>
			<input name="sc.chcSource" size="20" /></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><input name="sc.chcCustName"/><span class="red_star">*</span></td>
		<th>成功机率</th>
		<td><input name="sc.chcRate"/><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><input name="sc.chcTitle" size="52" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td><input name="sc.chcLinkman" size="20" /></td>
		<th>联系人电话</th>
		<td><input name="sc.chcTel" size="20" /></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><textarea rows="6" cols="50" name="sc.chcDesc"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><input name="sc.chcCreateBy" value="${u.usrName}" readonly size="20" /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input id="t1" name="sc.chcCreateDate"  size="20"/><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
		<!-- sc.su.usrId -->
	
			<select name="sc.su.usrId">
				
				<c:forEach items="${user}" var="p">
				<option value="${p.usrId}">${p.usrName}</option>
				</c:forEach>
				
			</select> <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="sc.chcDueDate"  size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</form>
</body>
</html>