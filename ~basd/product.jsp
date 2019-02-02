<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/html/script/common.js"></script>
</head>
<body>

<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="fyjump(1)">查询</button>  
</div>
<form id="formfy" action="product!findAll" method="post">
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td><input name="prod.prodName" value="${prod.prodName }"/></td>
		<th>型号</th>
		<td><input name="prod.prodType" value="${prod.prodType }"/></td>
		<th>批次</th>
		<td><input name="prod.prodBatch" value="${prod.prodBatch }"/></td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>名称</th>
		<th>型号</th>
		<th>等级/批次</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>备注</th>
	</tr>
	<s:iterator value="#request.pu.list">
		<tr>
			<td class="list_data_number"><s:property value="prodId"/></td>
			<td class="list_data_ltext"><s:property value="prodName"/></td>
			<td class="list_data_text"><s:property value="prodType"/></td>
			<td class="list_data_text"><s:property value="prodBatch"/></td>
			<td class="list_data_text"><s:property value="prodUnit"/></td>
			<td class="list_data_number"><s:property value="prodPrice"/></td>
			<td class="list_data_ltext"><s:property value="prodMemo"/></td>		
		</tr>
	</s:iterator>
	<tr>
							<th colspan="7" class="pager">
								<div class="pager">
									<input id="page" type="hidden" name="page" value="${pu.page }">
									共${pu.maxCount }条记录 
									每页${pu.count } 条
									第${pu.page }页/共${pu.maxPage }页
									<a href="javascript:fyjump(1)">第一页</a>
									<a href="javascript:fyjump(${pu.page-1})">上一页</a>
									<a href="javascript:fyjump(${pu.page+1})">下一页</a>
									<a href="javascript:fyjump(${pu.maxPage })">最后一页</a>
									 转到 页
									<button width="20" onclick="add();">
										GO
									</button>
								</div>
							</th>
	</tr>
</table>
</form>
<script type="text/javascript">
			
			function fyjump(page){
    		document.getElementById("page").value=page;
    		document.getElementById("formfy").submit();
    	}
   	</script>
</body>
</html>