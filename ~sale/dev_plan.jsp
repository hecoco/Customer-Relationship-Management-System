<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('plan!idquerylist?sp.plaId=${sp.plaId}&tz=2');">执行计划</button>
	<button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${sp.slch.chcId}</td>
		<th>机会来源</th>
		<td>${sp.slch.chcSource}
			　</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${sp.slch.chcCustName}</td>
		<th>成功机率（%）</th>
		<td>&nbsp;${sp.slch.chcRate}</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">${sp.slch.chcTitle}</td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>${sp.slch.chcLinkman}</td>
		<th>联系人电话</th>
		<td>${sp.slch.chcTel}</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${sp.slch.chcDesc}</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${sp.slch.chcCreateBy}</td>
		<th>创建时间</th>
		<td>${sp.slch.chcCreateDate}</td>
	</tr>
	<tr>
		<th>指派给</th>
		<td>${sp.slch.chcDueTo}</td>
		<th>指派时间</th>
		<td>${sp.slch.chcDueDate}</td>
	</tr>
</table>
<br />
<table class="data_list_table" id="table1">
	<tr>
		<th width="150px">日期</th>
		<th height="31">计划项</th>
	</tr>
	
	<c:forEach items="${list}" var="p">
	<c:if test="${p.slch.chcId==sp.slch.chcId}">
	<form method="post" action="plan!update?tz=1">
	<tr>
	<input type="hidden" name="sp.plaId" value="${p.plaId}"/>
		<td class="list_data_text" height="24">${p.plaDate}</td>
		<td class="list_data_ltext" height="24"><input size="50" value="${p.plaTodo}" name="updatetores" />
	  <button class="common_button" type="submit" >修改</button>
	  <button class="common_button" onclick="del('');">删除</button>
		</td>
	</tr>
	</form>
	</c:if>
	</c:forEach>
	<!--
	<tr>
		<td class="list_data_text">2008年02月22日</td>
		<td class="list_data_ltext"><input size="50" value="推介产品。" name="T1" />
	<button class="common_button" onclick="save('dev_plan.jsp');">保存</button>
	<button class="common_button" onclick="del('');">删除</button>
		</td>
	</tr>
-->
</table>
<form method="post" action="plan!add">
<div class="button_bar">
	<button class="common_button" type="submit">添加</button>
	</div>
<table class="query_form_table" id="table2">
	<tr>
	<input type="hidden" name="sp.slch.chcId" value="${sp.slch.chcId}"/>
		<th>日期</th>
		<td><input name="sp.plaDate"/><span class="red_star">*</span></td>
		<th>计划项</th>
		<td>
			<input size="50" name="sp.plaTodo" /><span class="red_star">*</span>
		</td>
	</tr>
	</form>
</table>
</body>
</html>