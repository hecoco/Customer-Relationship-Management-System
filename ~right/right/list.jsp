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
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link href="html/css/style.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath }/html/script/common.js"></script>
		<script src="${pageContext.request.contextPath }/html/script/validate.js"></script>
	</head>
	<script type="text/javascript">
		function add(){
			location.href='${pageContext.request.contextPath }/sysright!findAlladd';
		}
		
	</script>
	<body>
		<div class="page_title">
			权限管理 > 权限管理 > 权限查询
		</div>
			<div class="button_bar">
				<button class="common_button" onclick="add()">
					新建
				</button>  
				<button class="common_button" onclick="help('');">
					帮助
				</button>  
				<button class="common_button" onclick="fyjump(1);">
					查询
				</button>
			</div>
		<form id="formfy" action="sysright!findAll" method="post">
			<table class="query_form_table">
				<tr>
					<th>
						权限文本
					</th>
					<td>
						<input name="right.rightText" value="${right.rightText }" />
					</td>
					<th>
						权限描述
					</th>
					<td>
						<input name="right.rightTip" value="${right.rightTip }" />
					</td>
					<th>
						权限类型
					</th>
					<td>
						<select name="right.rightParent">
							<option value="">--请选择父节点--</option>
							<s:iterator value="#request.list">
								<s:if test="rightParent == null || rightParent == ''">
									<option value="<s:property value="rightCode"/>" <s:if test="right.rightParent == rightCode">selected='selected'</s:if>><s:property value="rightCode"/></option>
								</s:if>
								<s:else>
									
								</s:else>
							</s:iterator>
						</select>
					</td>
				</tr>
			</table>
			<br />
			<table class="query_form_table">
				<tr>
					<th>
						权限编号
					</th>
					<th>
						权限文本
					</th>
					<th>
						权限父节点
					</th>
					<th>
						权限类型
					</th>
					<th>
						权限描述
					</th>
					<th>
						权限操作
					</th>
				</tr>
					<s:iterator value="#request.pu.list">
						<tr>
							<td>
								<s:property value="rightCode"/>
							</td>
							<td>
								<s:property value="rightText"/>
							</td>
							<td>
								<s:property value="rightParent"/>
							</td>
							<td>
								<s:property value="rightType"/>
							</td>
							<td>
								<s:property value="rightTip"/>
							</td>
							<td>
								<img
									onclick="sid('<s:property value="rightCode"/>')"
									title="编辑" src="html/images/bt_edit.gif" class="op_button" />
								<img
									onclick="ck('<s:property value="rightCode"/>');"
									title="查看" src="html/images/bt_deal.gif" class="op_button" />
								<img
									onclick="javascript:delet('<s:property value="rightCode"/>')"
									title="删除" src="html/images/bt_del.gif" class="op_button" /> 
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
			function delet(idd){
				if(confirm("确定要删除"+idd+"吗?")){
					location.href='${pageContext.request.contextPath }/sysright!delete?right.rightCode='+idd;
				}
			};
			function ck(id){
				location.href='${pageContext.request.contextPath }/sysright!findcK?right.rightCode='+id;
			};
			function sid(id){
				location.href='${pageContext.request.contextPath }/sysright!findbyid?right.rightCode='+id;
			}
			function fyjump(page){
    		document.getElementById("page").value=page;
    		document.getElementById("formfy").submit();
    	}
		</script>
	</body>
</html>
