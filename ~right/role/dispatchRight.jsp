<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script src="<%=path%>/html/script/common.js"></script>
		<script src="<%=path %>/html/script/validate.js"></script>
	</head>
  
  <body>
    <div class="page_title">
		权限管理 > 角色管理 > 分配权限 
	</div>
	<html:form action="role.do" method="post">
		<html:hidden property="o" value="toDispatchRightList"/>
			<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="back();">
					返回
				</button>
				<button class="common_button" onclick="add();">
					查询
				</button>
			</div>
			<table class="query_form_table">
				<tr>
					<th>
						角色名
					</th>
					<td>
						<html:text property="sysRole.roleName" size="20"></html:text>
					</td>
					<th>角色描述</th>
					<td>
						<html:text property="sysRole.roleDesc" size="20"></html:text>
					</td>
					<th>
						是否禁用
					</th>
					<td>
						<html:select property="sysRole.roleFlag">
							<html:option value="0">全部</html:option>
							<html:option value="1">正常</html:option>
							<html:option value="2">禁用</html:option>
						</html:select>
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
				<logic:iterate id="role" name="roles">
					<tr>
						<td class="list_data_text">
							${role.roleId}
						</td>
						<td class="list_data_text">
							${role.roleName}
						</td>
						<td>
							${role.roleDesc }
						</td>
						<td class="list_data_text">
							<c:if test="${role.roleFlag==1}">
	   					正常
	   				</c:if>
							<c:if test="${role.roleFlag==2}">
	   					禁用
	   				</c:if>
						</td>
						<td class="list_data_op">
							<button onclick="to('role.do?o=toDispatchRight&roleId=${role.roleId }')">分配权限</button>
						</td>
					</tr>
				</logic:iterate>
				<tr>
					<th colspan="7" class="pager">
						<div class="pager">
							共${sessionScope.roleForm.page.allRecord}条记录 每页
							<html:text property="page.maxRecord" size="2"></html:text>
							条
							第${sessionScope.roleForm.page.currPage}页/共${sessionScope.roleForm.page.allPage}页
							<a href="role.do?o=toDispatchRightList&param=firstPage">第一页</a>
							<a href="role.do?o=toDispatchRightList&param=prePage">上一页</a>
							<a href="role.do?o=toDispatchRightList&param=nextPage">下一页</a>
							<a href="role.do?o=toDispatchRightList&param=lastPage">最后一页</a> 转到
							<html:text property="page.currPage" size="2"></html:text>
							页
							<button width="20" onclick="add();">
								GO
							</button>
						</div>
					</th>
				</tr>
			</table>
	</html:form>
  </body>
</html>
