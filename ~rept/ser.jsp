<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="html/css/style.css" rel="stylesheet" type="text/css">
	<script src="html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户服务分析</div>
<form action="TongJi!FenWu" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button">查询</button> 
	</div>
	
<table class="query_form_table">
	<tr>
		<th>年份</th>
		<td>
			<select name="year">
				<option value="全部" ${year==null?'selected':''}>全部</option>
				<option value="2010" <s:property value="#request.year=='2010'?'selected':''"/>>2010</option>
				<option value="2011" ${year eq '2011'?'selected':''}>2011</option>
				<option value="2012" ${year eq '2012'?'selected':''}>2012</option>
				<option value="2013" ${year eq '2013'?'selected':''}>2013</option>
				<option value="2014" ${year eq '2014'?'selected':''}>2014</option>
				<option value="2015" ${year eq '2015'?'selected':''}>2015</option>
				<option value="2016" ${year eq '2016'?'selected':''}>2016</option>
				<option value="2017" ${year eq '2017'?'selected':''}>2017</option>
				<option value="2018" ${year eq '2018'?'selected':''}>2018</option>
			</select>
		</td>
		<th>&nbsp;</th>
		<td>
			&nbsp;
		</td>
	</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>条目</th>
		<th>服务数量</th>
	</tr>
	<s:iterator value="#request.TongJiList" var="tj" status="a">
	<tr>
		<td class="list_data_number">${a.count}</td>
		<td class="list_data_text">${tj[0]}</td>
		<td class="list_data_number">${tj[1]}</td>
	</tr>
	</s:iterator>
	</table>
</body>
</html>
