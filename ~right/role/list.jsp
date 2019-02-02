<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<body>
		<div class="page_title">
			权限管理 > 用户管理 > 系统角色管理
		</div>
		<script type="text/javascript">
			 function t(){
				location.href='html/~right/role/add.jsp';
			} 
			function delet(id){
				if(confirm("确定要删除"+id+"吗?")){
					location.href='${pageContext.request.contextPath }/role!delete?role.roleId='+id;
				}
			}
		</script>
		<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button"
					onclick="t();">
					新建
				</button>
				<button class="common_button" onclick="javascript:fyjump(1);">
					查询
				</button>
			</div>
		<form id="form1" action="role!findAll" method="post">
			<%--
			<script type="text/javascript">
				function too(){
					alert('添加');
				}
			</script> --%>
				
			<table class="query_form_table">
				<tr>
					<th>
						角色名
					</th>
					<td>
						<input type="text" name="role.roleName" value="${role.roleName }" size="20">
					</td>
					<th>角色描述</th>
					<td>
						<input type="text" name="role.roleDesc" value="${role.roleDesc }" size="20">
					</td>
					<th>
						是否禁用
					</th>
					<td>
						<select name="role.roleFlag" >
						
							<option value="0" <s:if test="role.roleFlag == 0">selected='selected'</s:if>>全部</option>
							<option value="1" <s:if test="role.roleFlag == 1">selected='selected'</s:if>>正常</option>
							<option value="2" <s:if test="role.roleFlag == 2">selected='selected'</s:if>>禁用</option>
						</select>
					</td>
				</tr>
			</table>
			<br />
			<table class="data_list_table">
				<tr>
					<th>
						编号
					</th>
					<th>
						角色名
					</th>
					<th>
						角色描述
					</th>
					<th>
						状态
					</th>
					<th>
						操作
					</th>
				</tr>
				<s:iterator value="#request.pu.list">
					<tr>
						<td class="list_data_text">
							<s:property value="roleId"/>
						</td>
						<td class="list_data_text">
						<s:property value="roleName"/>
						</td>
						<td>
						<s:property value="roleDesc"/>
							
						</td>
						<td class="list_data_text">
							<s:if test="roleFlag == 1">
								正常
							</s:if>
							<s:else>
								禁用
							</s:else>
						</td>
						<td class="list_data_op">
						<s:if test="roleFlag == 1">
								<img onclick="to('${pageContext.request.contextPath }/role!findidedit?role.roleId=<s:property value="roleId"/>');"
								title="编辑" src="html/images/bt_edit.gif" class="op_button" />
							<img onclick="to('${pageContext.request.contextPath }/role!findid?role.roleId=<s:property value="roleId"/>')" 
							    title="分配权限" src="html/images/bt_linkman.gif" class="op_button" />
						</s:if>
							<img onclick="to('${pageContext.request.contextPath }/role!findiddetail?role.roleId=<s:property value="roleId"/>');"
							title="查看" src="html/images/bt_deal.gif" class="op_button" />
						<s:if test="roleFlag == 1">
								<img
								onclick="javascript:delet(<s:property value="roleId"/>)"
								title="删除" src="html/images/bt_del.gif" class="op_button" />
						</s:if>
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
				document.getElementById("form1").submit();
			}
			function fy(){
			
				document.getElementById("form1").submit();
			}
		</script>
	</body>
</html>
<%-- ${msg} --%>

