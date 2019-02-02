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

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('html/~cust/cust/activities_add.jsp');">新建</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td> <s:property value="#request.idd"/> </td>
		<th>客户名称</th>
		<td> <s:property value="#request.namen"/></td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th width="232">时间</th>
		<th>地点</th>
		<th>概要</th>
		<th>详细信息</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.activitylist" var="acti">
	<tr>
		<td class="list_data_text" width="230">${acti.atvDate}</td>
		<td class="list_data_text">${acti.atvPlace}</td>
		<td class="list_data_ltext">${acti.atvTitle}</td>
		<td class="list_data_ltext">${acti.atvDesc}</td>
		<td class="list_data_op">${acti.atvBz}</td>
		<td class="list_data_op">
			<img onclick="to('csta!findById?tivi.atvId=${acti.atvId}');" title="编辑" src="${pageContext.request.contextPath}/html/images/bt_edit.gif" class="op_button" />
			<img onclick="del(${acti.atvId},'csta!delActivity?tivi.atvId=${acti.atvId}');" title="删除" src="${pageContext.request.contextPath}/html/images/bt_del.gif" class="op_button" />
		</td>
	</tr>
	</s:iterator>
	
	
	<!--<tr>
		<td class="list_data_text" width="230">2007年08月01日</td>
		<td class="list_data_text">公司</td>
		<td class="list_data_ltext">2008年行业展望座谈会</td>
		<td class="list_data_ltext">...</td>
		<td class="list_data_op">
			主办单位:计算机报社</td>
		<td class="list_data_op">
			<img onclick="to('activities_edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />
			<img onclick="del('“交往记录：签订意向协议”');" title="删除" src="../../images/bt_del.gif" class="op_button" />
		</td>
	</tr>
	<tr>
		<td class="list_data_text" width="230">2007年07月25日</td>
		<td class="list_data_text">公司</td>
		<td class="list_data_ltext">邀请到公司参观</td>
		<td class="list_data_ltext">...</td>
		<td class="list_data_op">
			　</td>
		<td class="list_data_op">
			<img onclick="to('activities_edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />
			<img onclick="del('“交往记录：签订意向协议”');" title="删除" src="../../images/bt_del.gif" class="op_button" />&nbsp;
		</td>
	</tr>-->
	</table>
</body>
</html>