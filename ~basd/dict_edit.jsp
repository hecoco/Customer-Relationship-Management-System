<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/html/css/style.css" rel="stylesheet" type="text/css">
 <script src="${pageContext.request.contextPath }/html/script/common.js"></script>
</head>
<body>

<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="save();">保存</button>  
</div>
<script type="text/javascript">
	function save(){
		document.getElementById("formup").submit();
	}
	
</script>

<form id="formup" action="basd!update" method="post">
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			
			<td><input type="text" readonly="readonly" value="<s:property value="#request.b.dictId"/>" name="dict.dictId" /></td>
			<th>类别</th>
			<td><input value="<s:property value="#request.b.dictType"/>" name="dict.dictType" /><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
		</tr>
		<tr>
			<th>条目</th>
			<td><input value="<s:property value="#request.b.dictItem"/>" name="dict.dictItem" /><span class="red_star">*</span></td>
			<th>值</th>
			<td><input value="<s:property value="#request.b.dictValue"/>" name="dict.dictValue" /><span class="red_star">*</span></td>
		</tr>	
		<tr>
			<th>是否可编辑</th>
			<td>
			<input type="checkbox" name="dict.dictIsEditable"
			<s:if test="#request.b.dictIsEditable == 1">checked='checked'</s:if>
			<s:else></s:else>
			value="1"
			/>
			</td>
			
			<th>&nbsp;</th>
			<td>&nbsp;</td>
		</tr>
	</table>
</form>
</body>
</html>