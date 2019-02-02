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
		function fh(){
			location.href='${pageContext.request.contextPath }/sysright!findAll';
		}
	</script>
	<body>
		<div class="page_title">
			权限管理 > 权限管理 > 添加权限
		</div>
		<div class="button_bar">
				<button class="common_button" onclick="help('');">
					帮助
				</button>
				<button class="common_button" onclick="fh()">
					返回
				</button>
		</div>
		<form action="/sysRight" method="post">
			<table class="query_form_table">
				<tr>
					<th>
						编号
					</th>
					<td>
						${sysRight.rightCode }
						<s:property value="#request.r.rightCode"/>
					</td>
					<th>
						权限类型
					</th>
					<td>
						${sysRight.rightType }
						<s:property value="#request.r.rightType"/>
					</td>
					<th>
						父节点
					</th>
					<td>
						${sysRight.rightParent }
						<s:property value="#request.r.rightParent"/>
					</td>
				</tr>
				<tr>
					<th>
						权限文本
					</th>
					<td>
						${sysRight.rightText }
						<s:property value="#request.r.rightText"/>
					</td>
					<th>
						权限URL
					</th>
					<td>
						${sysRight.rightUrl }
						<s:property value="#request.r.rightUrl"/>
					</td>
					<th>权限描述</th>
					<td>
						${sysRight.rightTip }
						<s:property value="#request.r.rightTip"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
