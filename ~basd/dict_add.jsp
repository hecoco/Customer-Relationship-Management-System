<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>

<div class="page_title">数据字典管理 > 新建数据字典条目</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
    <button class="common_button" onclick="add();">保存</button>   -->
</div>
<script type="text/javascript">
	function add(){
		document.getElementById("fromadd").submit();
	}
</script>
<form id="fromadd" action="../../basd!add" method="post">
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td><input readonly="readonly" /></td>
			<th>类别</th>
			<td><input name="dict.dictType"/><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
		</tr>
		<tr>
			<th>条目</th>
			<td><input  name="dict.dictItem"/><span class="red_star">*</span></td>
			<th>值</th>
			<td><input  name="dict.dictValue"/><span class="red_star">*</span></td>
		</tr>	
		<tr>
		
			<th>是否可编辑</th>
			<td>
			<input type="checkbox" 
			checked='checked'
			value="1"
			 name="dict.dictIsEditable" />
			</td>
			<th>&nbsp;</th>
			<td>&nbsp;</td>
		</tr>
	</table>
</form>
</body>
</html>