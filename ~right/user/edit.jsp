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
  	function up(){
  		document.getElementById("upd").submit();
  	}
  </script>
  <body>
    <div class="page_title">权限管理 > 用户管理 > 系统用户</div>
    <div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="back();">返回</button>
			<button class="common_button" onclick="up();">保存</button>
	   	</div>
    <form id="upd"  action="user!update" method="post">
    	
	   	<table class="query_form_table">
	   		<tr>
	   			<th>编号</th>
	   			<td>
	   				<input name="user.usrId" readonly="true" size="20" value="<s:property value="#request.uss.usrId"/>">
					<!--<hidden property="userId" value="${sysUser.usrId}"/>-->	   				
	   			</td>
	   			<th>用户名</th>
	   			<td>
	   				<input name="user.usrName" size="20" value="<s:property value="#request.uss.usrName"/>">
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>密码</th>
	   			<td>
	   				<input type="password" name="user.usrPassword" value="<s:property value="#request.uss.usrPassword"/>">
	   			</td>
	   			<th>角色</th>
	   			<td>
	   				<s:if test="#request.uss.role == '' || #request.uss.role == null ">未指派</s:if>
	   				<s:else>
	   					<s:property value="#request.uss.role.roleName"/>
	   				</s:else>
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>状态</th>
	   			<td>
	   			<select name="user.usrFlag">
	   				<option <s:property value="#request.uss.usrFlag == 1?'select':''"/> value="1">正常</option>
	   				<option <s:property value="#request.uss.usrFlag == 0?'select':''"/> value="0">删除</option>
	   			</select>
	   				<%-- <s:property value="#request.uss.usrFlag == 1?'正常':'禁用'"/>
	   				<c:if test="${sysUser.usrFlag==1}">
	   					正常
	   				</c:if>
	   				<c:if test="${sysUser.usrFlag==2}">
	   					禁用
	   				</c:if>
	   				<hidden property="flag" value="${sysUser.usrFlag}"/> --%>
	   			</td>
	   		</tr>
	   	</table>
	   	<script>
				build_validate("sysUser.usrName","用户名不能为空","Limit","1","50");
				build_validate("sysUser.usrPassword","密码不能为空","Limit","1","50");
		</script>
    </form>
  </body>
</html>
