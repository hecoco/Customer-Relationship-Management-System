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
    <div class="page_title">权限管理 > 用户管理 > 查看用户</div>
    <form action="/right" method="post">
    	<hidden property="o" value="toDetail"/>
    	<div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
	   	</div>
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td><s:property value="#request.sus.usrId"/></td>
	   			<th>用户名</th>
	   			<td><s:property value="#request.sus.usrName"/></td>
	   		</tr>
	   		<tr>
	   			<th>角色</th>
	   			<td>
	   				<%-- <c:if test="${sysUser.sysRole==null}">
	   					未指派
	   				</c:if>
	   				<c:if test="${sysUser.sysRole!=null}">
	   					${sysUser.sysRole.roleName}
	   				</c:if> --%>
	   				<s:property value="#request.sus.role == null?'未指派':'已指派'"/>
	   			</td>
	   			<th>
	   				状态
	   			</th>
	   			<td>
	   				<s:property value="#request.sus.usrFlag == 1?'正常':'已删除' "/>
	   			</td>
	   		</tr>
	   	</table>
    </form>
  </body>
</html>
