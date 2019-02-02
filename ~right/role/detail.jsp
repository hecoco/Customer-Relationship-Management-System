<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <div class="page_title">权限管理 > 角色管理 > 角色管理 > 查看角色</div>
    <form action="/role" method="post">
    	<hidden property="o" value="toLookSysRole"/>
    	<!-- <div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
	   	</div> -->
	   	<br/>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>
	   				编号
	   			</th>
	   			<td>
	   				<s:property value="#request.r.roleId"/>
	   			</td>
	   			<th>
	   				角色名
	   			</th>
	   			<td><s:property value="#request.r.roleName"/></td>
	   		</tr>
	   		<tr>
	   			<th>
	   				角色描述
	   			</th>
	   			<td>
	   				<s:property value="#request.r.roleDesc"/>
	   			</td>
	   			<th>状态</th>
	   			<td>
	   				<s:property value="#request.r.roleFlag"/>
	   			</td>
	   		</tr>
	   	</table>
    </form>
  </body>
</html>
