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
    <div class="page_title">权限管理 > 用户管理 > 系统用户管理</div>
    <div class="button_bar">
	   		<button class="common_button" onclick="help('');">帮助</button>
	   		<button class="common_button" onclick="to('html/~right/user/add.jsp');">新建</button>
			<button class="common_button" onclick="fyjump(1)">查询</button>
	</div>
    <form id="formfy" action="user!findAll" method="post">
    	
	   	<table class="query_form_table">
	   		<tr>
	   			<th>
	   				用户名
	   			</th>
	   			<td>
	   				<input name="user.usrName" size="20" value="${user.usrName }">
	   			</td>
	   			<th>
	   				是否禁用
	   			</th>
	   			<td>
	   				<select name="user.usrFlag">
	   					<option value="0" <s:if test="user.usrFlag == 0">selected='selected'</s:if>>全部</option>
	   					<option value="1" <s:if test="user.usrFlag == 1">selected='selected'</s:if>>正常</option>
	   					<option value="2" <s:if test="user.usrFlag == 2">selected='selected'</s:if>>禁用</option>
	   				</select>
	   			</td>
	   		</tr>
	   	</table>
	   	<br/>
	   	<table class="data_list_table">
	   		<tr>
	   			<th>编号</th>
	   			<th>用户名</th>
	   			<th>角色</th>
	   			<th>状态</th>
	   			<th>操作</th>
	   		</tr>
	   		<s:iterator value="#request.pu.list" var="li">
	   			<tr>
		   			<td class="list_data_text"><s:property value="#request.li.usrId"/></td>
		   			<td class="list_data_text"><s:property value="#request.li.usrName"/></td>
		   			<td class="list_data_text">
		   			<s:property value="#request.li.role.roleName"/>
		   			</td>
		   			<td class="list_data_text">
		   				<!-- <c:if test="usrFlag eq 1">
		   					正常
		   				</c:if>
		   				<c:if test="usrFlag eq 2">
		   					禁用
		   				</c:if> -->
		   				<s:property value="#request.li.usrFlag == 1?'正常':'禁用'"/>
		   			</td>
		   			
		   			<td class="list_data_op">
		   			<s:if test="#request.li.usrFlag == 1">
		   					<img onclick="to('user!findid?user.usrId=<s:property value="#request.li.usrId"/>');" title="编辑" src="html/images/bt_edit.gif" class="op_button" />
		   					<img onclick="to('user!findzp?user.usrId=<s:property value="#request.li.usrId"/>');" title="指派" src="html/images/bt_linkman.gif" class="op_button" />
		   			</s:if>
		   				<img onclick="to('user!findck?user.usrId=<s:property value="#request.li.usrId"/>');" title="查看" src="html/images/bt_deal.gif" class="op_button" />
		   			<s:elseif test="#request.li.usrFlag == 0">
		   				<img onclick="de(<s:property value="#request.li.usrId"/>);" title="删除" src="html/images/bt_del.gif" class="op_button" />
		   			</s:elseif>
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
    	function de(id){
    		if(confirm("确定删除"+id+"吗？")){
    			location.href='${pageContext.request.contextPath }/user!delete?user.usrId='+id;
    		}
    	}
    	function fyjump(page){
    		document.getElementById("page").value=page;
    		document.getElementById("formfy").submit();
    	}
    </script>
  </body>
</html>