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

<div class="page_title">客户信息管理 > 客户信息 > 历史订单 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td> <s:property value="#request.idd"/> </td>
		<th>客户名称</th>
		<td><s:property value="#request.namen"/></td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>订单编号</th>
		<th>日期</th>
		<th>送货地址</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.orderslist" var="orst">
	<tr>
		<td class="list_data_text">${orst.odrId}</td>
		<td class="list_data_text">${orst.odrDate}</td>
		<td class="list_data_text">${orst.odrAddr}</td>
		<td class="list_data_text"> <s:if test="#request.orst.odrStatus == 5">已发货</s:if> <s:else>已回款</s:else> </td>
		<td class="list_data_op">
			<img onclick="to('orde!findOrdersLine?ords.odrId=${orst.odrId}');" title="查看明细" src="${pageContext.request.contextPath}/html/images/bt_detail.gif" class="op_button" /></td>
	</tr>
	</s:iterator>
	<!--
	
	
	<tr>
		<td class="list_data_text">1343444</td>
		<td class="list_data_text">2007年10月29日</td>
		<td class="list_data_text">北京海淀区劳动路205号</td>
		<td class="list_data_text">已回款</td>
		<td class="list_data_op">
			<img onclick="to('orders_detail.html');" title="查看明细" src="../../images/bt_detail.gif" class="op_button" />
		</td>
	</tr>
	<tr>
		<td class="list_data_text">1343443</td>
		<td class="list_data_text">2007年10月29日</td>
		<td class="list_data_text">北京海淀区劳动路205号</td>
		<td class="list_data_text">已回款</td>
		<td class="list_data_op">
			<img onclick="to('orders_detail.html');" title="查看明细" src="../../images/bt_detail.gif" class="op_button" />
			&nbsp;
		</td>
	</tr>
		-->
		<tr>
		<th colspan="100" class="pager">
<div class="pager">
	共59条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a href="#">第一页</a>
	<a href="#">上一页</a>
	<a href="#">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
	</table>
</body>
</html>