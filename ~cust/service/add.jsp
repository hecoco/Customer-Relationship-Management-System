<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.util.*"  %>
<%@ page import="java.text.*"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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

<% Date d=new Date();
   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
   String da=df.format(d);
 %>


<div class="page_title">客户服务管理 > 服务创建</div>
<form action="service!add"  method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	 <input type="submit" value="保存">
</div>


<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input disabled /></td>
		<th>服务类型</th>
		<td>
			<select name="cs.svrType">
				<option>请选择...</option>
				<option>咨询</option>
				<option>投诉</option>
				<option>建议</option>
			</select>
			<span class="red_star" >*</span>
		</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3"><input size="53"  name="cs.svrTitle"/>
		<span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td><input name="cs.svrCustName" size="20"  />
		<span class="red_star">*</span></td>
		<th>状态</th>
		<td><input name="cs.svrStatus"  value="新创建"  readonly /></td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">
		<textarea rows="6" cols="50" name="cs.svrRequest"></textarea>
		<span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>
		<input type="hidden" name="cs.svrCreateId" value="<s:property value="#application.u.usrId"/>"/>
		<input name="cs.svrCreateBy"  readonly size="20"  value="<s:property value="#application.u.usrName"/>" /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input  name="cs.svrCreateDate" value="<%=da%>" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
	</table>
<br />
</form>
<!--<table disabled class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			<select>
				<option>请选择...</option>
				<option>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>周洁轮</option>
			</select> <span class="red_star">*</span></td>
		<th>分配时间</th>
		<td><input id="t2" name="T18" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />	
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><textarea rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><input name="T17" value="刘颖" readonly size="20" /><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td><input id="t3" name="T16" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
--><!--<table disabled class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="T10" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="D1">
				<option>请选择...</option>
				<option>☆☆☆☆☆</option>
				<option>☆☆☆☆</option>
				<option>☆☆☆</option>
				<option>☆☆</option>
				<option>☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
-->
<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</body>
</html>
