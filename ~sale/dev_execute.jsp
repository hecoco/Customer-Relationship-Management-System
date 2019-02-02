<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTf-8">
<link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 执行计划 ${sp.plaId}</div>
<div class="button_bar">

	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="alert('开发失败，已归档。');window.location.href='plan!update?sp.plaId=${sp.plaId}&tz=4'">终止开发</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="to('plan!idquerylist?sp.plaId=${sp.plaId}&tz=1');">制定计划</button>
	<button class="common_button" onclick="alert('用户开发成功，已添加新客户记录。');window.location.href='plan!update?sp.plaId=${sp.plaId}&tz=3'">开发成功</button>

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
		<td>
			${sp.slch.chcDueTo}</td>
		<th>指派时间</th>
		<td>
			${sp.slch.chcDueDate}</td>
	</tr>
</table>
<br />
<table class="data_list_table" id="table1">
	<tr>
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
		
	</tr>
	
	<c:forEach items="${list}" var="p">
	<c:if test="${p.slch.chcId==sp.slch.chcId}">
	<form method="post" action="plan!update?tz=2">
	<tr>
	<input type="hidden" name="sp.plaId" value="${p.plaId}"/>
	<td class="list_data_text" height="24">${p.plaDate}</td>
	<td class="list_data_ltext" height="24">${p.plaTodo}
	 <td class="list_data_ltext"><input  name="updatetores" value="${p.plaResult}"/>
	  <button class="common_button" type="submit" >修改</button>

		</td>
	</tr>
	</form>
	</c:if>
	</c:forEach>
	<!--<tr>
		<td class="list_data_text">2008年01月18日</td>
		<td class="list_data_ltext">初步接触，了解客户意向。</td>
		<td class="list_data_ltext"><input />　
	<button class="common_button" onclick="save('dev_execute.html');">保存</button>
		</td>
	</tr>
	<tr>
		<td class="list_data_text">2008年02月22日</td>
		<td class="list_data_ltext">推介产品。</td>
		<td class="list_data_ltext"><input name="T1" size="20" />　
	<button class="common_button" onclick="save('dev_execute.html');">保存</button>
		</td>
	</tr>
	--></table>
</body>
</html>