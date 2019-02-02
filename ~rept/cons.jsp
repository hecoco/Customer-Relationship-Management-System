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
    
    <title>My JSP 'cons.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户构成分析</div>
<form action="TongJi!FenXi" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>报表方式</th>
		<td>
			<select name="fen">
				<option value="1" ${fen==1?'selected':''}>按等级</option>
				<option value="2" ${fen==2?'selected':''}>按信用度</option>
				<option value="3" ${fen==3?'selected':''}>按满意度</option>
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
		<th>等级</th>
		<th>客户数量</th>
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