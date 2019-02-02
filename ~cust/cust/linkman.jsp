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

<div class="page_title">客户信息管理 > 客户信息 > 联系人 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('html/~cust/cust/linkman_add.jsp');">新建</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td> <s:property value="#request.idd"/> </td>
		<th>客户名称</th>
		<td> <s:property value="#request.namen"/> </td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>职位</th>
		<th>办公电话</th>
		<th>手机</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.linklist" var="llk">
	<tr>
		<td class="list_data_text">${llk.lkmName}</td>
		<td class="list_data_ltext">${llk.lkmSex}</td>
		<td class="list_data_text">${llk.lkmPostion}</td>
		<td class="list_data_text">${llk.lkmTel}</td>
		<td class="list_data_text">${llk.lkmMobile}</td>
		<td class="list_data_op">${llk.lkmMemo}</td>
		<td class="list_data_op">
			<img onclick="to('link!findByIdlinkman?clk.lkmId=${llk.lkmId}');" title="编辑" src="${pageContext.request.contextPath}/html/images/bt_edit.gif" class="op_button" />
			<img onclick="del(${llk.lkmId},'link!dellinkman?clk.lkmId=${llk.lkmId}')" title="删除" src="${pageContext.request.contextPath}/html/images/bt_del.gif" class="op_button" />
		</td>
	</tr>
	</s:iterator>
	</table>
</body>
</html>