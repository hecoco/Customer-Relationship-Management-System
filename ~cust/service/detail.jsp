<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="html/script/common.js"></script>
</head>
<body>

<div class="page_title">t客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><s:property value="#request.service.svrId"/></td>
		<th>服务类型</th>
		<td>
			<s:property  value="#request.service.svrType"/></td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3"><s:property value="#request.service.svrTitle"/></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td><s:property value="#request.service.svrCustName"/></td>
		<th>状态</th>
		<td><s:property value="#request.service.svrStatus"/></td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3"><s:property value="#request.service.svrRequest"/><br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><s:property value="#request.service.svrCreateBy"/></td>
		<th>创建时间</th>
		<td><s:date name="#request.service.svrCreateDate" format="yyyy年MM月dd日hh时mm分ss秒"/></td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			<s:property value="#request.service.svrDueTo"/></td>
		<th>分配时间</th>
		<td><s:date name="#request.service.svrDueDate" format="yyyy年MM月dd日hh时mm分ss秒"/></td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">回电话给<s:property value="#request.service.svrDealBy"/>经理：<br>
		<s:property value="#request.service.svrDeal"/></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><s:property value="#request.service.svrDealBy"/></td>
		<th>处理时间</th>
		<td><s:date name="#request.service.svrDealDate" format="yyyy年MM月dd日hh时mm分ss秒"/></td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><s:property value="#request.service.svrResult"/></td>
		<th>满意度</th>
		<td>
		<s:iterator begin="1" end="#request.service.svrSatisfy" var="ascd">
			<img src="html/images/star.jpg" class="star_pic" />
		</s:iterator>
			</td>
	</tr>
</table>
</body>
</html>
