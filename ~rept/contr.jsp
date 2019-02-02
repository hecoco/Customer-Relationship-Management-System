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
    
    <title>My JSP 'contr.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="html/css/style.css" rel="stylesheet" type="text/css">
	<script src="html/script/common.js"></script>
	<script type="text/javascript" src="html/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function (){
		});
	</script>
</head>
<body>

<div class="page_title">客户贡献分析</div>
<form action="TongJi!GongXian" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input name="name" value="${name==null?'':name}"/></td>
		<th>年份</th>
		<td>
			<select name="gyear">
				<option value="全部" ${gyear==null?'selected':''}>全部</option>
				<option value="2010" <s:property value="#request.gyear=='2010'?'selected':''"/>>2010</option>
				<option value="2011" ${gyear eq '2011'?'selected':''}>2011</option>
				<option value="2012" ${gyear eq '2012'?'selected':''}>2012</option>
				<option value="2013" ${gyear eq '2013'?'selected':''}>2013</option>
				<option value="2014" ${gyear eq '2014'?'selected':''}>2014</option>
				<option value="2015" ${gyear eq '2015'?'selected':''}>2015</option>
				<option value="2016" ${gyear eq '2016'?'selected':''}>2016</option>
				<option value="2017" ${gyear eq '2017'?'selected':''}>2017</option>
				<option value="2018" ${gyear eq '2018'?'selected':''}>2018</option>
			</select>
		</td>
	</tr>
	</table>
	</form>
<br />
<table class="data_list_table" id="tab">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>订单金额（元）</th>
	</tr>
	<s:iterator value="#request.TongJiList" var="tj" status="a">
	<tr>
		<td class="list_data_number" align="center">${a.count}</td>
		<td class="list_data_ltext" >${tj[1]}</td>
		<td class="list_data_number">${tj[3]==null?'0':tj[3]}</td>
	</tr>
	</s:iterator>
</table>
</body>
</html>