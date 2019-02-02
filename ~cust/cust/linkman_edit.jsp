<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 编辑联系人</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="document.getElementById('form1').submit()">保存</button>  
</div>
<form action="link!updatelinkman" method="post" id="form1">
<table class="query_form_table" id="table1">
	<tr>
		<th>姓名</th>
		<td><input readonly name="clk.lkmName" value="${cl.lkmName}" size="20" /><span class="red_star">*</span></td>
		<th>性别</th>
		<td>
			<input type="radio" name="clk.lkmSex" value="${cl.lkmSex}" checked />男
			<input type="radio" name="clk.lkmSex" value="${cl.lkmSex}" />女
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><input name="clk.lkmPostion" value="${cl.lkmPostion}" size="20" /><span class="red_star">*</span></td>
		<th>办公电话</th>
		<td><input name="clk.lkmTel" value="${cl.lkmTel}" size="20" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>手机</th>
		<td><input name="clk.lkmMobile" value="${cl.lkmMobile}" size="20" /></td>
		<th>备注</th>
		<td><input name="clk.lkmMemo" value="${cl.lkmMemo}" size="20" /></td>
	</tr>
</table>
</form>
</body>
</html>