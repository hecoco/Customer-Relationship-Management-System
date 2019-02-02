<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>index</title>
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<link rel="stylesheet" href="css/bootstrap.css" >
	<link rel="stylesheet" href="css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
    <link rel="stylesheet" href="css/custom.css">
    
	<script src="script/jquery-3.2.1.js" type="text/javascript"></script>
	<script src="script/bootstrap.min.js" type="text/javascript"></script>
		
	<script src="script/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="script/custom.js"></script>
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
		
	</script>
</head>
<body>
		<!--导航条-->
		<div class="navbar navbar-default"style="background-color: ; margin-bottom: 0px;">
			<div class="container">
				<div class="navbar-header">
					<img  class="navbar-left"src="images/logo.png" style="margin-left: 30px;"/>
					
					<button class="navbar-toggle" data-toggle="collapse" data-target="#daohang">
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		            </button>
				</div>
				<div class="collapse navbar-collapse" id="daohang">
					 <ul class="nav navbar-nav navbar-right">
		                <li><a href=""><span class="glyphicon glyphicon-user"></span> 当前用户：<span id=""><s:if test="#application.u.usrName == null">请登录</s:if><s:else><s:property value="#application.u.usrName"/> </s:else> <%--  ${u.usrName!=null?u.usrName:"请登录"} --%></span></a></li>
		                <li><a href=""><span class="glyphicon glyphicon-question-sign"></span> 关于 </a></li>
		                <li><a href=""><span class="glyphicon glyphicon-off"></span> 退出系统</a></li>
		            </ul>
				</div>
            </div>
		</div>
		
	<div class="page-wrapper" style="background-color: white;color: black;">
            <nav id="sidebar" class="sidebar-wrapper">
              <div class="sidebar-content">
                <a href="#" id="toggle-sidebar"><i class="fa fa-bars"></i></a>
                <div class="sidebar-brand">
                    <a href="#">客户关系管理系统</a>
                </div>
            
              <!-- sidebar-search  -->
                <div class="sidebar-menu">
                    <ul>
                        <!-- 
                        	在此处获得并且循环遍历出当前用户对应的权限
                        	SysUser ==> role ==> rights
                         -->
                        <s:iterator value="#application.u.role.rights" var="bright">
                        	<s:if test="#request.bright.rightParent==null || #request.bright.rightParent==\"\"">
		                        <li class="sidebar-dropdown">
		                            <a  href="#" ><i class="fa fa-user"></i><span><s:property value="#request.bright.rightText" /></span></a>
		                            <div class="sidebar-submenu">
		                                <ul>
		                                	<s:iterator value="#application.u.role.rights" var="sright">
		                                		<s:if test="#request.bright.rightCode==#request.sright.rightParent">
		                                			<li>
		                                				<a href="javascript:changeContent('<s:property value="#request.sright.rightUrl"/>')">
		                                					<s:property value="#request.sright.rightText"/>
		                                				</a>
		                                			</li>
		                                		</s:if>
		                                	</s:iterator>
		                                </ul>
		                            </div>
		                        </li>     
	                        </s:if>
                        </s:iterator>             
                    </ul>
                   </div><!-- sidebar-menu  -->            
                </div><!-- sidebar-content  -->
        
            </nav><!-- sidebar-wrapper  -->
            <SCRIPT type="text/javascript">
            	function changeContent(url){
            		alert(url);
            		url="http://127.0.0.1:8080/java2_crm/"+url;
            		alert(url);
            		document.getElementById("content").src=url;
            	}
            </SCRIPT>
            <main class="page-content">
                <iframe id="content" src="mywork.htm" width="1024px" height="800px" ></iframe>
            </main><!-- page-content" -->
        </div><!-- page-wrapper -->
        <br/>
		<!--底部-->
		<footer class="text-muted">
			<div class="container text-center">
		        <p>企业培训 | 合作事宜 | 版权投诉  </p>
		        <p>版权所有：长沙华瑞IT教育学校 湘ICP备13002607号-4</p>
		    </div>
		</footer><br/>
</body>
</html>