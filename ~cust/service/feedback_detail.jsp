<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>
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
    
    <title>My JSP 'feedback_detail.jsp' starting page</title>
    
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
 
 <script type="text/javascript">
	function save(){
		document.getElementById("form1").submit();
	}
</script>

 

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">

	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
     <button class="common_button" onclick="save();">保存</button> 
	
</div>
 <form id="form1" action="service!update3" method="post">
<table class="query_form_table">  

	<tr>
		<th>编号</th>
		<td>
		<input type="hidden" name="cs.svrId" value="<s:property value="#request.service.svrId"/>"/>
		<s:property value="#request.service.svrId"/>
		</td>
		<th>服务类型</th>
		<td><s:property  value="#request.service.svrType"/></td>
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
		<td colspan="3"><s:property value="#request.service.svrRequest"/><br></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><s:property value="#request.service.svrCreateBy"/></td>
		<th>创建时间</th>
		<td><s:date name="#request.service.svrCreateDate" format="yyyy-MM-dd"/></td>
	</tr>

	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td><s:property value="#request.service.svrDueTo"/></td>
		<th>分配时间</th>
		<td><s:date name="#request.service.svrDueDate" format="yyyy-MM-dd"/></td>
	</tr>
</table>

<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><s:property value="#request.service.svrDeal"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><input name="cs.svrDealBy" value="<s:property value="#request.service.svrDealBy"/>" readonly size="20" /><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td>
		<s:date name="#request.service.svrDealDate" format="yyyy-MM-dd"/>
		<span class="red_star">*</span></td>
	</tr>
</table>

<br />
 <table  class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="cs.svrResult" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="cs.svrSatisfy">
				<option >请选择...</option>
				<option value="5">☆☆☆☆☆</option>
				<option value="4">☆☆☆☆</option>
				<option value="3">☆☆☆</option>
				<option value="2">☆☆</option>
				<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</form>

	


</body>
</html>
