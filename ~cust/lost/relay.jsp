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

<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="to('confirm.html');">确认流失</button>
	<button class="common_button" onclick="document.getElementById('form1').submit()">保存</button>
</div>
<form action="lost!updatee" method="post" id="form1">
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<input type="hidden" id="lstId" name="losts.lstId" value="${listbidd.lstId}"/>
		<td>${listbidd.lstId}</td>
		<th>客户</th>
		<td>${listbidd.lstCustName}</td>
	</tr>
	<tr>
        <th>客户经理</th>
		<td>${listbidd.lstCustManagerName}</td>
		<th>上次下单时间</th>
		<td>${listbidd.lstLastOrderDate}</td>
	</tr>	
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">${listbidd.lstDelay}</td>
	</tr>
	<tr>
		<th>追加暂缓措施</th>
		<td colspan="3">
			<textarea rows="6" cols="50" name="lost.lstDelay"></textarea><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<br />
</body>
</html>