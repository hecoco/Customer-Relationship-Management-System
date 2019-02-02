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
<script type="text/javascript">
	/* function ss(){
		
	} */
</script>
<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="fyjump(1)">查询</button>  
</div>

<form id="formfy" action="storage!findAll" method="post">
<table class="query_form_table">
	<tr>
		<th>产品</th>
		<td><input type="number" name="sto.stkProdId" value="${sto.stkProdId }" /></td>
		<th>仓库</th>
		<td><input name="sto.stkWarehouse" value="${sto.stkWarehouse }"/></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>产品</th>
		<th>仓库</th>
		<th>货位</th>
		<th>件数</th>
		<th>备注</th>
	</tr>
	
	<s:iterator value="#request.pu.list">
		<tr>
			<td class="list_data_number"><s:property value="stkId"/></td>
			<td class="list_data_ltext">
			<%-- <s:if test="stkProdId == #request.list.prodId">true</s:if> --%>
			<s:iterator value="#request.list" var="pd">
				<%-- <s:property value="#request.pd.prodId"/> --%>
				<s:if test="#request.pd.prodId == stkProdId"><s:property value="#request.pd.prodName"/></s:if>
			</s:iterator>
			<s:iterator value="#request.list" var="pa">
				<%-- <s:property value="#request.pa.prodId"/> --%>
				<s:if test="#request.pa.prodId == stkProdId"><s:property value="#request.pa.prodPrice"/></s:if>
			</s:iterator>
			<%-- <s:property value="#request.pd.prodId"/>
			<s:property value="stkProdId"/> --%>
			</td>
			<td class="list_data_ltext"><s:property value="stkWarehouse"/></td>
			<td class="list_data_text"><s:property value="stkWare"/></td>
			<td class="list_data_number"><s:property value="stkCount"/></td>
			<td class="list_data_ltext">&nbsp;<s:property value="stkMemo"/></td>		
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