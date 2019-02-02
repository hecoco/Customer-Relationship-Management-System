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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table" height="59">
	<tr>
		<th>订单编号</th>
		<td>${dd.odrId}</td>
		<th>日期</th>
		<td>${dd.odrDate}</td>
	</tr>
	<tr>
		<th height="28">送货地址</th>
		<td>${dd.odrAddr}</td>
		<th height="28">总金额（元）</th>
		<td>${count}</td>
	</tr>
	<tr>
		<th height="28">状态</th>
		<td><s:if test="#request.dd.odrStatus == 5">已发货</s:if> <s:else>已回款</s:else></td>
		<th height="28">&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>商品</th>
		<th>数量</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>金额（元）</th>
	</tr>
	<s:iterator value="#request.ddxq" var="spp">
	<tr>
		<td class="list_data_text">${spp.products.prodName}</td>
		<td class="list_data_ltext">${spp.oddCount}</td>
		<td class="list_data_text">${spp.products.prodUnit}</td>
		<td class="list_data_text">${spp.products.prodPrice}</td>
		<td class="list_data_text">${spp.oddCount*spp.products.prodPrice}</td>
	</tr>
	</s:iterator>
	
	</table>
</body>
</html>