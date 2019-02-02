<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/html/css/style.css" rel="stylesheet" type="text/css">
 <script src="${pageContext.request.contextPath }/html/script/common.js"></script>
</head>
<body>

<div class="page_title">数据字典管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="too()">新建</button>
	<button class="common_button" onclick="fyjump(1)">查询</button>  
</div>
<script type="text/javascript">
	function dell(id){
		if(confirm("确定要删除"+id+"?")){
			location.href="basd!delete?dict.dictId="+id;
		}
	}
	function too(){
		location.href='${pageContext.request.contextPath }/html/~basd/dict_add.jsp';
	}
</script>

<br />
<form id="formfy" action="basd!select" method="post">
<table class="query_form_table">
	<tr>
		<th>类别</th>
		<td><input name="dict.dictType" value="${dict.dictType}"/></td>
		<th>条目</th>
		<td><input name="dict.dictItem"  value="${dict.dictItem}"/></td>
		<th>值</th>
		<td><input name="dict.dictValue"  value="${dict.dictValue}"/></td>
	</tr>
</table><br/>
<table class="data_list_table">
	<tr  align="center">
		<th>编号</th>
		<th>类别</th>
		<th>条目</th>
		<th>值</th>
		<th>是否可编辑</th>
		<th>操作</th>
	</tr>
	
	<s:iterator value="#request.pu.list" var="li">
		<tr >
			<td class="list_data_number"><s:property value="#request.li.dictId"/></td>
			<td class="list_data_ltext"><s:property value="#request.li.dictType"/></td>
			<td class="list_data_text"><s:property value="#request.li.dictItem"/></td>
			<td class="list_data_text"><s:property value="#request.li.dictValue"/></td>
			<td class="list_data_text">
			<s:if test="#request.li.dictIsEditable == 0">否</s:if>
			<s:else>是</s:else>
			</td>
			<td class="list_data_op">
				<s:if test="#request.li.dictIsEditable eq 1">
						<img onclick="to('basd!selectid?dict.dictId=<s:property value="#request.li.dictId"/>');" title="编辑" src="${pageContext.request.contextPath }/html/images/bt_edit.gif" class="op_button" />
				</s:if>
				<s:else>
					<img onclick="javascript:dell(<s:property value="#request.li.dictId"/>);" title="删除" src="${pageContext.request.contextPath }/html/images/bt_del.gif" class="op_button" />
				</s:else>
			</td>
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