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

<div class="page_title">客户流失管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户</th>
		<td><input /></td>
		<th>客户经理</th>
		<td><input /></td>
		<th>状态</th>
		<td>
			<select>
				<option>全部</option>
				<option>预警</option>
				<option>暂缓流失</option>
				<option>确认流失</option>
			</select>
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>客户经理</th>
		<th>上次下单时间</th>
		<th>确认流失时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.listcstlost" var="li">
	<tr>
		<td class="list_data_number">${li.lstId}</td>
		<td class="list_data_text">${li.lstCustName}</td>
		<td class="list_data_ltext">${li.lstCustManagerName}</td>
		<td class="list_data_text">${li.lstLastOrderDate}</td>
		<td class="list_data_text">　</td>
		<td class="list_data_text">
		<s:if test="#request.li.lstStatus==1">警告</s:if>
		<s:if test="#request.li.lstStatus==2">暂缓流失</s:if>
		<s:if test="#request.li.lstStatus==3">已经流失</s:if>
	    </td>
		<td class="list_data_op">
			<img onclick="to('lost!findByid?losts.lstId=${li.lstId}');" title="确认流失" src="${pageContext.request.contextPath}/html/images/bt_confirm.gif" class="op_button" />
			<img onclick="to('lost!findByidd?losts.lstId=${li.lstId}');" title="暂缓流失" src="${pageContext.request.contextPath}/html/images/bt_relay.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>
	
	<tr>
		<th colspan="7" class="pager">
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