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
    
    <title>My JSP 'lost.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="html/css/style.css" rel="stylesheet" type="text/css">
	<script src="html/script/common.js"></script>
	<script type="text/javascript" src="html/script/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(function (){
			$("#shang").click(function (){
				var page=(parseInt($("#page").html())-1);
				$("#f").attr("action",$("#f").attr("action")+"?page="+page);
				$("#f").submit();
			});
			$("#xia").click(function (){
				var page=(parseInt($("#page").html())+1);
				$("#f").attr("action",$("#f").attr("action")+"?page="+page);
				$("#f").submit();
			});
			$("#first").click(function (){
				$("#f").attr("action",$("#f").attr("action")+"?page=1");
				$("#f").submit();
			});
			$("#last").click(function (){
				$("#f").attr("action",$("#f").attr("action")+"?page="+$("#maxpage").html());
				$("#f").submit();
			});
			$("#count").change(function (){
				$("#f").attr("action",$("#f").attr("action")+"?page="+$("#page").html()+"&count="+$(this).val());
				$("#f").submit();
			});
			$("#go").click(function (){
				$("#f").attr("action",$("#f").attr("action")+"?page="+$("#zpage").val()+"&count="+$("#count").val());
				$("#f").submit();
			});
		});
	</script>
</head>
<body>

<div class="page_title">客户流失分析</div>
<form action="TongJi!LiuShi" method="post" id="f">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button">查询</button> 
	</div>
	<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
					<th>客户名称</th>
	<td><input type="text" name="lname" value="${lname==null?'':lname}"></td>
					<th>客户经理</th>

	<td><input type="text" name="lname1" value="${lname1==null?'':lname1}"></td>
					
			</tr>
		</table><br />
		</form>
<table class="data_list_table">
	<tr>
		<th height="28">编号</th>
		<th height="28">年份</th>
		<th height="28">客户</th>
		<th height="28">客户经理</th>
		<th height="28">流失原因</th>
	</tr>
	<s:iterator value="#request.TongJiList" var="tj" status="a">
	<tr>
		<td class="list_data_number" height="27">${a.count}</td>
		<td class="list_data_text" height="27">${tj[0]}</td>
		<td class="list_data_text" height="27">${tj[1]}</td>
		<td class="list_data_text" height="27">${tj[2]}</td>
		<td class="list_data_ltext" height="27">${tj[3]}</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
	<div class="pager">
	共<s:property value="#request.maxcount"/>条记录 每页<input value="${count}" id="count" size="2" />条
	第<span id="page">${page}</span>页/共<span id="maxpage">${maxpage}</span>页
	<a href="javascript:;" id="first">第一页</a>
	<a href="javascript:;" id="shang">上一页</a>
	<a href="javascript:;" id="xia">下一页</a>
	<a href="javascript:;" id="last">最后一页</a>
	转到<input value="${page}" id="zpage" size="2" />页
	<button width="20" id="go">GO</button>
</div>
		</th>
	</tr>

	</table>
</body>
</html>