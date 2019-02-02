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
    
    <title>My JSP 'deal_detail.jsp' starting page</title>
    
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
<script type="text/javascript">
	function save(){
		document.getElementById("form1").submit();
	}
</script>

  </head>
  
  
  
  <body>
<% Date d=new Date();
   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
   String da=df.format(d);
 %>
 
 

 

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">

	<button class="common_button" onclick="help();">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
    <button class="common_button" onclick="save();">保存</button> 
	
</div>

 <form id="form1" action="service!update" method="post">
<table class="query_form_table">  

	<tr>
		<th>编号</th>
		<td>
		<input type="hidden" name="cs.svrId" value="<s:property value="#request.list21.svrId"/>"/>
		<s:property value="#request.list21.svrId"/></td>
		<th>服务类型</th>
		<td><s:property  value="#request.list21.svrType"/></td>
	</tr>

	<tr>
		<th>概要</th>
		<td colspan="3"><s:property value="#request.list21.svrTitle"/></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td><s:property value="#request.list21.svrCustName"/></td>
		<th>状态</th>
		<td><s:property value="#request.list21.svrStatus"/></td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3"><s:property value="#request.list21.svrRequest"/><br></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><s:property value="#request.list21.svrCreateBy"/></td>
		<th>创建时间</th>
		<td>
		<s:date name="#request.list21.svrCreateDate" format="yyyy年MM月dd日hh时mm分ss秒"/>
		</td>
	</tr>

	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td><s:property value="#request.list21.svrDueTo"/></td>
		<th>分配时间</th>
		<td><s:date name="#request.list21.svrDueDate" format="yyyy年MM月dd日hh时mm分ss秒"/></td>
	</tr>
</table>

<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><input name="cs.svrDeal" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>
		<input type="hidden" name="cs.svrDealId" value="<s:property value="#application.u.usrId"/>" />
		<input name="cs.svrDealBy" value="<s:property value="#application.u.usrName"/>" readonly size="20" /><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td><input  name="cs.svrDealDate" value="<%=da%>"  readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
</form>


<br />
<%-- <table  class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="cs.svrResult" size="20" /><span class="red_star">*</span></td>
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

</table> --%>


</body>
</html>
