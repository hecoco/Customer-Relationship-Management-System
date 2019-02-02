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
		function ad(){
			document.getElementById("formad").submit();
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
				<button class="common_button" onclick="back();">
					返回
				</button>
				<button class="common_button" onclick="ad();">
					保存
				</button>
			</div>
		<form id="formad" action="sysright!add" method="post">
			<hidden property="o" value="addSysRight" />
			
			<table class="query_form_table">
				<tr>
					<th>
						编号
					</th>
					<td>
						<input name="right.rightCode"/>
					</td>
					<th>
						权限类型
					</th>
					<td>
						<select name="right.rightType">
							<option value="Folder">根结点</option>
							<option value="Folder">父节点</option>
							<option value="Document">子节点</option>
						</select>
					</td>
					<th>
						父节点
					</th>
					<td>
						<select name="right.rightParent">
							<option value="0">--请选择父节点--</option>
							<s:iterator value="#request.list">
								<s:if test="rightParent == null || rightParent == ''">
									<option value="<s:property value="rightCode"/>"><s:property value="rightCode"/></option>
								</s:if>
								<s:else>
									
								</s:else>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						权限文本
					</th>
					<td>
						<input name="right.rightText"/>
					</td>
					<th>
						权限URL
					</th>
					<td>
						<input name="right.rightUrl"/>
					</td>
					<th>权限描述</th>
					<td>
						<textarea name="right.rightTip"></textarea>
					</td>
				</tr>
			</table>
			<script>
				build_validate("sysRight.rightCode","编号不能为空","Limit","1","50");
				build_validate("sysRight.rightParentCode","父节点不能为空","Limit","1","50");
				build_validate("sysRight.rightText","权限文本不能为空","Limit","1","50");
			</script>
		</form>
	</body>
</html>
