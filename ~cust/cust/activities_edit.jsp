<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="document.getElementById('form1').submit()">保存</button>  
</div>
<form action="csta!updateActivity" method="post" id="form1">
<table class="query_form_table" id="table1">
	<tr>
		<th>时间</th>
		<td><input name="tivi.atvDate" value="${cstylist.atvDate}" size="20" /><span class="red_star">*</span></td>
		<th>地点</th>
		<td>
			<input name="tivi.atvPlace" value="${cstylist.atvPlace}" size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>概要</th>
		<td><input name="tivi.atvTitle" value="${cstylist.atvTitle}" size="20" /><span class="red_star">*</span></td>
		<th>备注</th>
		<td><input name="tivi.atvBz" value="${cstylist.atvBz}" size="20" /></td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<textarea cols="50" rows="6" name="tivi.atvDesc">${cstylist.atvDesc}</textarea>
		</td>
	</tr>
</table>
</form>
</body>
</html>