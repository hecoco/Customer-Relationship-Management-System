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

<form id="form1" action="plan!querygj" method="post">
<div class="page_title">客户开发计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" type="submit">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input name="sc.chcCustName" value="${ sc.chcCustName}" /></td>
		<th>概要</th>
		<td><input name="sc.chcTitle" value="${ sc.chcTitle}"  /></td>
		<th>联系人</th>
		<td>
			<input name="sc.chcLinkman" value="${sc.chcLinkman}"  size="20" />
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${list1}" var="p11">
	<tr>
		<td class="list_data_number">${p11.plaId}</td>
		<td class="list_data_text">${p11.slch.chcCustName}</td>
		<td class="list_data_ltext">${p11.slch.chcTitle}</td>
		<td class="list_data_text">${p11.slch.chcLinkman}</td>
		<td class="list_data_text">${p11.slch.chcTel}</td>
		<td class="list_data_text">${p11.slch.chcCreateDate}</td>
		<td class="list_data_text">
		   <c:if test="${p11.slch.chcStatus==1}">未指派</c:if>
		    <c:if test="${p11.slch.chcStatus==2}">已指派</c:if>
		     <c:if test="${p11.slch.chcStatus==3}">开发成功</c:if>
		      <c:if test="${p11.slch.chcStatus==4}">终止开发</c:if>
		
		</td>
		<td class="list_data_op">
			<img onclick="to('plan!idquerylist?sp.plaId=${p11.plaId}&tz=1');" title="制定计划" src="${pageContext.request.contextPath}/html/images/bt_plan.gif" class="op_button" />
			<img onclick="to('plan!idquerylist?sp.plaId=${p11.plaId}&tz=2');" title="执行计划" src="${pageContext.request.contextPath}/html/images/bt_feedback.gif" class="op_button" />
			<img onclick="alert('用户开发成功，已添加新客户记录。');window.location.href='plan!update?sp.plaId=${p11.plaId}&tz=3'" title="开发成功" src="${pageContext.request.contextPath}/html/images/bt_yes.gif" class="op_button" />
		</td>
	</tr>
	</c:forEach>
	<!--<tr>
		<td class="list_data_number">2</td>
		<td class="list_data_text">泰宝实业</td>
		<td class="list_data_ltext">采购笔记本电脑意向</td>
		<td class="list_data_text">马先生</td>
		<td class="list_data_text">13333239239</td>
		<td class="list_data_text">2007年11月16日</td>
		<td class="list_data_text">已归档</td>
		<td class="list_data_op">
			<img onclick="to('dev_detail.html');" title="查看" src="../images/bt_detail.gif" class="op_button" />
		</td>
	</tr>
	-->
	<tr>
		<th colspan="10" class="pager">
<div class="pager">
	共${maxCount }条记录 每页<input value="${count}" size="2" name="count"/>条
	第<input value="${page}" name="page" id="page" size="2"/>页/共${maxPage }页
	<a href="javascript:fy(${page-1 })">上一页</a>
	<a href="javascript:fy(${page+1 })">下一页</a>
	<a href="javascript:fy(${maxPage })">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
	</from>
</table>
</body>
</html>