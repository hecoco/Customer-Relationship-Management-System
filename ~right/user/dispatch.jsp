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
  <script type="text/javascript">
  	function zp(){
  		document.getElementById("zp").submit();
  	}
  </script>
  <body>
    <div class="page_title">权限管理 > 用户管理 > 指派用户角色</div>
   	    <div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="zp();">保存</button>
	   	</div>
    <form id="zp" action="user!updatezp" method="post">
    	
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td>
					<input name="user.usrId" readonly="true" size="20" value="<s:property value="#request.yu.usrId"/>">	   			
	   			</td>
	   			<th>用户名</th>
	   			<td>
	   				<input  readonly="true" size="20" value="<s:property value="#request.yu.usrName"/>">
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>
	   				角色
	   			</th>
	   			<td>
	   				
	   				<select name="roleId">
	   					<option value="0" <s:property value="#request.yu.role == null?'select':''"/> >未指派</option>
	   					<s:iterator value="#request.role">
	   						<option value="<s:property value="roleId"/>" <s:property value="roleId == #request.yu.role.roleId?'selected':''"/> ><s:property value="roleId"/><s:property value="roleName"/></option>
	   					</s:iterator>
	   				</select>
	   			</td>
	   			<th>
	   				状态
	   			</th>
	   			<td>
	   				<s:property value="#request.yu.usrFlag == 1?'正常':'禁用'"/>
	   			</td>
	   		</tr>
	   	</table>
    </form>
  </body>
</html>
