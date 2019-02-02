<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'feedback.jsp' starting page</title>

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
	<script type="text/javascript">
		function fy(page) {
			document.getElementById("page").value = page;
			document.getElementById("count1").value = document
					.getElementById("count").value;
			document.getElementById("form1").submit();
		}
		function go() {
			document.getElementById("page").value = document
					.getElementById("page1").value;
			document.getElementById("count1").value = document
					.getElementById("count").value;
			document.getElementById("form1").submit();
		}
	</script>
	<div class="page_title">客户服务管理 &gt; 服务反馈</div>
	<form id="form1" action="service!findall" method="post">
		<div class="button_bar">
			<button class="common_button" onclick="help('');">帮助</button>
			<button class="common_button">查询</button>
		</div>
		<input type="hidden" name="count" id="count1" /> <input type="hidden"
			name="page" id="page" />
		<table class="query_form_table" height="53">
			<tr>
				<th height="28">客户</th>
				<td><input name="cs.svrCustName" value="${cs.svrCustName}" />
				</td>
				<th height="28">概要</th>
				<td><input name="cs.svrTitle" value="${cs.svrTitle}" /></td>
				<th height="28">服务类型</th>
				<td><select name="cs.svrType">
						<option>全部</option>
						<option value="咨询">咨询</option>
						<option value="建议">建议</option>
						<option value="投诉">投诉</option>
				</select>
				</td>
			</tr>
			<tr>
				<th height="22">创建日期</th>
				<td colspan="3"><input name="cs.svrCreateDate" size="10" /> -
					<input name="svrCreateDate1" size="10" /></td>
				<th height="22">状态</th>
				<td><select name="cs.svrStatus">
						<option value="已处理" selected>已处理</option>
				</select>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>客户</th>
			<th>概要</th>
			<th>服务类型</th>
			<th>创建人</th>
			<th>创建日期</th>
			<th>操作</th>
		</tr>
		<s:iterator value="#request.list1">

			<%-- <s:if test="svrStatus=='已处理'"> --%>
				<tr>
					<td class="list_data_number"><s:property value="svrId" />
					</td>
					<td class="list_data_text"><s:property value="svrCustName" />
					</td>
					<td class="list_data_ltext"><s:property value="svrTitle" />
					</td>
					<td class="list_data_text"><s:property value="svrType" />
					</td>
					<td class="list_data_text"><s:property value="svrCreateBy" />
					</td>
					<td class="list_data_text"><s:date name="svrCreateDate"
							format="yyyy年MM月dd日" />
					</td>
					<td class="list_data_op"><img
						onclick="to('service!findByidb?cs.svrId=<s:property value="svrId"/>');"
						title="处理" src="html/images/bt_feedback.gif" class="op_button" />

					</td>
				</tr>
			<%-- </s:if> --%>

		</s:iterator>
		<tr>
			<th colspan="7" class="pager">
				<div class="pager">
					共
					<s:property value="#request.sumcount" />
					条记录 每页<input id="count" value="${count}" size="2" />条 第<span>${page}</span>页/共${maxpage}页
					<a href="javascript:fy('1')">第一页</a> <a
						href="javascript:fy('${page-1}')">上一页</a> <a
						href="javascript:fy('${page+1}')">下一页</a> <a
						href="javascript:fy('${maxpage}')">最后一页</a> 转到<input
						value="${page}" id="page1" size="2" />页
					<button width="20" onclick="go()">GO</button>
				</div></th>
		</tr>
	</table>
</body>
</html>
