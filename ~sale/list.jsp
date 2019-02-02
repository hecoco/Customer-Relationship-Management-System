<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
<script type="text/javascript">
    function fy(page){
    	
    	 document.getElementById("page").value=page;
    	 document.getElementById("form1").submit();
    	
    }
</script>

</head>
<body>
<form id="form1" action="chance!querygj" method="post">
<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<input type="button" class="common_button" onclick="to('html/~sale/add.jsp');" value="新建" />
	<button class="common_button" type="submit">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input name="name" value="${name}"/></td>
		<th>概要</th>
		<td><input  name="title" value="${title}"/></td>
		<th>联系人</th>
		<td>
			<input name="Linkman" size="20" value="${Linkman}" />
		</td>
	</tr>
	</table>
	
	
<br />
<table class="data_list_table" border="1">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${list}" var="p">
	   <tr>
	      <td class="list_data_number">${p.chcId}</td>
	      <td class="list_data_text">${p.chcCustName}</td>
	      <td class="list_data_ltext">${p.chcTitle}</td>
	      <td class="list_data_text">${p.chcLinkman}</td>
	      <td class="list_data_text">${p.chcTel}</td>
	      <td class="list_data_text">${p.chcCreateDate}</td>
	      <td class="list_data_op">
			<img onclick="to('chance!idquerylist?sc.chcId=${p.chcId}&tz=2');" title="指派" src="${pageContext.request.contextPath}/html/images/bt_linkman.gif" class="op_button" />
			<img onclick="to('chance!idquerylist?sc.chcId=${p.chcId}&tz=1');" title="编辑" src="${pageContext.request.contextPath}/html/images/bt_edit.gif" class="op_button" />
			<img onclick="del('${p.chcCustName}','chance!delete?sc.chcId=${p.chcId}');" title="删除" src="${pageContext.request.contextPath}/html/images/bt_del.gif" class="op_button" />
		</td>
	   </tr>
	
	</c:forEach>
	
	<!--
	<tr>
		<td class="list_data_number">1</td>
		<td class="list_data_text">睿智数码</td>
		<td class="list_data_ltext">采购笔记本电脑意向</td>
		<td class="list_data_text">刘先生</td>
		<td class="list_data_text">13729239239</td>
		<td class="list_data_text">2007年12月06日</td>
		<td class="list_data_op">
			<img onclick="to('dispatch.html');" title="指派" src="../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('edit.html');" title="编辑" src="../images/bt_edit.gif" class="op_button" />
			<img onclick="del('“销售机会：采购笔记本电脑意向”');" title="删除" src="../images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	-->
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共${maxCount }条记录 每页<input value="${count}" size="2" name="count"/>条
	第<input value="${page}" name="page" id="page" size="2"/>页/共${maxPage }页
	
	<a href="javascript:fy(${page-1 })">上一页</a>
	<a href="javascript:fy(${page+1 })">下一页</a>
	<a href="javascript:fy(${maxPage })">最后一页</a>
	
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
</table>
</form>
</body>
</html>