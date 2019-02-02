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
  
  <body>
   		<div class="page_title">
			权限管理 > 用户管理 > 系统角色管理 > 编辑角色
		</div>
		<form action="role!updateedit" method="post">
			<hidden property="o" value="editRole"/>
			<div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="update();">保存</button>
	   	</div>
	   <%-- 	<script type="text/javascript">
  			function update(){
  				alert("是");
  			}
  		</script> --%>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td>
	   				<input name="role.roleId" readonly="true" size="20" value="<s:property value="#request.sys.roleId"/>">  				
	   			</td>
	   			<th>角色名</th>
	   			<td>
	   				<input name="role.roleName" size="20" value="<s:property value="#request.sys.roleName"/>">
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>角色描述</th>
	   			<td>
	   				<textarea name="role.roleDesc" cols="20" rows="3"><s:property value="#request.sys.roleDesc"/></textarea>
	   			</td>
	   			<th>状态</th>
	   			<td>
	   				<select name="role.roleFlag">
	   						<option <s:if test="#request.sys.roleFlag == 1">selected='selected'</s:if> value="1">正常</option>
	   						<option <s:if test="#request.sys.roleFlag == 2">selected='selected'</s:if> value="2">禁用</option>
	   				</select>
	   			</td>
	   		</tr>
	   	</table>
	</form>
  </body>
</html>
