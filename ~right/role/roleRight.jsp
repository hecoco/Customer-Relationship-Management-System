<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<script type="text/javascript">
	function allch(code){
		var temp = document.getElementById(code);
		var rs = document.getElementsByName("sysRight");
		if(temp.checked){
			for(var i=0;i<rs.length;i++){
				if(rs[i].id.substring(0,3)==code){	
					rs[i].checked=true;
				}
			}			
		}else{
			for(var i=0;i<rs.length;i++){
				if(rs[i].id.substring(0,3)==code){
					rs[i].checked=false;
				}
			}
		}		
	}
	function selSup(code){
		var temps = document.getElementById(code);
		if(temps.checked){
			var sup = document.getElementById(code.substring(0,3));
			sup.checked=true;
		}else{
			var rs = roleForm["sysRight"];
			var currRightId =code.substring(0,3);
			var flag = true;
			for(var i=0;i<rs.length;i++){
				if(rs[i].id!=currRightId &&rs[i].id.substring(0,3)==currRightId){
					if(rs[i].checked==true){
						flag=false;//其中有子节点被选中
					}
				}
			} 
			if(flag){
				document.getElementById(currRightId).checked=false;
			}
		}
	}
</script>
	</head>
  
  <body>
    <div class="page_title">
			权限管理 > 用户管理 > 系统角色管理 > 权限分配
	</div>
	<form action="role!update" method="post">
			<table class="query_form_table">
				<tr>
					<th>角色名</th>
					<td>
					<input type="hidden" value="<s:property value="#request.sr.roleId"/>" name="role.roleId" >
					<s:property value="#request.sr.roleName"/>
					</td>
					<th>角色描述</th>
					<td><s:property value="#request.sr.roleDesc"/></td>
					<th>状态</th>
					<td><s:property value="#request.sr.roleFlag"/></td>
				</tr>
				<tr>
					<th>权限</th>
					<td colspan="5" align="center">
						<input type="reset" styleClass="common_button" value="取消" />
						<input type="submit" styleClass="common_button" value="保存" />
					</td>
				</tr>
			</table>
			<br/>
			<table class="query_form_table">
				
					<tr>
						<td>
						<s:iterator value="#request.rights" var="dr">
							<s:if test="#request.dr.rightParent == null || #request.dr.rightParent.equals('')">
								<hr>
								 <div style="background-color:#CCCCCC;">
									  &nbsp;&nbsp;&nbsp;<s:property value="#request.dr.rightText"/>
									 <input type="checkbox" name=sysRight  <s:if test="#request.sr.rights.{?rightCode  eq #request.dr.rightCode}.size>0">checked='checked'</s:if> value="<s:property value="#request.dr.rightCode"/>" onclick="allch('<s:property value="#request.dr.rightCode"/>')" id="<s:property value="#request.dr.rightCode"/>">
								 </div>
								<br>
								<s:iterator value="#request.rights" var="xr">
									 <s:if test="#request.dr.rightCode.equals(#request.xr.rightParent)">
										  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.xr.rightText"/>
									  	  <input type="checkbox" name="sysRight" <s:if test="#request.sr.rights.{?rightCode  eq #request.xr.rightCode}.size>0">checked='checked'</s:if> value="<s:property value="#request.xr.rightCode"/>" onclick="selSup('<s:property value="#request.xr.rightCode"/>')" id="<s:property value="#request.xr.rightCode"/>">
									 </s:if> 
								</s:iterator>
							</s:if>
						</s:iterator>
					 	</td>	
					 </tr>			
			</table>
	</form>
  </body>
</html>
