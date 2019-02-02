<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
</head>
<script type="text/javascript">
			function fyJump(page){
				document.getElementById("page").value=page;
				document.getElementById("form1").submit();
			}
</script>
<body>

<div class="page_title">客户信息管理</div>
<form id="form1" action="cstc!findAll" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="fyJump(1)">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><input name="cc.custNo" value="${cc.custNo}"/></td>
		<th>名称</th>
		<td><input name="cc.custName" value="${cc.custName}"/></td>
		<th>地区</th>
		<td>
		
		<select name="cc.custRegion" >
						<option value="0">
							请选择...
						</option>
						<!-- 所有地区 -->
						<s:iterator value="#request.list" var="bb">
							<s:if test="#request.bb.dictType == '地区'">
								<option value="${bb.dictValue}"
									<s:if test="#request.cc.custRegion == #request.bb.dictValue">selected="selected"</s:if>>
									${bb.dictItem}
								</option>
							</s:if>
						</s:iterator>
					</select>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
		<select name="cc.sysusers.usrId">
						<option value="0">
							请选择...
						</option>
						<!-- 所有用户 -->
						<s:iterator value="#request.list1" var="bb1">
							<option value="${bb1.usrId}"
								<s:if test="#request.cc.sysusers.usrId == #request.bb1.usrId">selected="selected"</s:if>>
								${bb1.usrId}
							</option>
						</s:iterator>

					</select>
		</td>
		<th>客户等级</th>
		<td>
<select name="cc.basd.dictId">
						<option value="0">
							请选择...
						</option>
						<!-- 所有客户等级 -->
						<s:iterator value="#request.list" var="bb">
							<s:if test="#request.bb.dictType == '企业客户等级'">
								<option value="${bb.dictId}"
									<s:if test="#request.cc.basd.dictId == #request.bb.dictId">selected="selected"</s:if>>
									${bb.dictItem}
								</option>
							</s:if>
						</s:iterator>

					</select>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>客户编号</th>
		<th>名称</th>
		<th>地区</th>
		<th>客户经理</th>
		<th>客户等级</th>
		<th>操作</th>
	</tr>
	<s:iterator value="#request.pu.list" var="cc1" status="s">
	<tr>
		<td class="list_data_number"><s:property value="#request.s.count"/></td>
		<td class="list_data_text">${cc1.custNo}</td>
		<td class="list_data_ltext">${cc1.custName}</td>
		<td class="list_data_text">
		
		<s:iterator value="#request.list" var="bb">
						<s:if test="#request.bb.dictType == '地区' && #request.bb.dictValue==#request.cc1.custRegion">
						${bb.dictItem}
				</s:if>
		</s:iterator>
		</td>
		<td class="list_data_text">${cc1.sysusers.usrName}</td>
		<td class="list_data_text">${cc1.basd.dictItem}</td>
		<td class="list_data_op">
			<img onclick="to('cstc!findById?cc.custNo=${cc1.custNo}');" title="编辑" src="${pageContext.request.contextPath}/html/images/bt_edit.gif" class="op_button" />
			<img onclick="to('link!findcustomerById?cct.custNo=${cc1.custNo}');" title="联系人" src="${pageContext.request.contextPath}/html/images/bt_linkman.gif" class="op_button" />
			<img onclick="to('csta!findActivityById?cct.custNo=${cc1.custNo}');" title="交往记录" src="${pageContext.request.contextPath}/html/images/bt_acti.gif" class="op_button" />
			<img onclick="to('orde!findOrdersById?cct.custNo=${cc1.custNo}');" title="历史订单" src="${pageContext.request.contextPath}/html/images/bt_orders.gif" class="op_button" />
			
			<img onclick="del(${cc1.custNo},'cstc!del?cc.custNo=${cc1.custNo}');" title="删除" src="${pageContext.request.contextPath}/html/images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>

	
	
	<!--<tr>
		<td class="list_data_number">4</td>
		<td class="list_data_text">KH071201006</td>
		<td class="list_data_ltext">云南天河烟草公司</td>
		<td class="list_data_text">中南</td>
		<td class="list_data_text">球球</td>
		
		<td class="list_data_text">重点开发客户</td>
		<td class="list_data_op">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />
			<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" /></td>
	</tr>
	<tr>
		<td class="list_data_number">5</td>
		<td class="list_data_text">KH071201005</td>
		<td class="list_data_ltext">北京天桥信息技术有限公司</td>
		<td class="list_data_text">北京</td>
		<td class="list_data_text">小明</td>
		<td class="list_data_text">大客户</td>
		<td class="list_data_op">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />
			<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" />
			
			<img onclick="del('“客户：聪海信息科技有限公司”');" title="删除" src="../../images/bt_del.gif" class="op_button" /></td>
	</tr>
	<tr>
		<td class="list_data_number">6</td>
		<td class="list_data_text">KH071201004</td>
		<td class="list_data_ltext">北京白羽有限责任公司</td>
		<td class="list_data_text">北京</td>
		<td class="list_data_text">小明</td>
		<td class="list_data_text">普通客户</td>
		<td class="list_data_op">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />
			<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" />
			
			<img onclick="del('“客户：聪海信息科技有限公司”');" title="删除" src="../../images/bt_del.gif" class="op_button" /></td>
	</tr>	
	<tr>
		<td class="list_data_number" height="15">7</td>
		<td class="list_data_text" height="15">KH071201003</td>
		<td class="list_data_ltext" height="15">北京神光培训</td>
		<td class="list_data_text" height="15">北京</td>
		<td class="list_data_text" height="15">阿咪</td>
		<td class="list_data_text" height="15">大客户</td>
		<td class="list_data_op" height="15">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />&nbsp;<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" />
		</td>
	</tr>	
	<tr>
		<td class="list_data_number" height="35">8</td>
		<td class="list_data_text" height="35">KH071201002</td>
		<td class="list_data_ltext" height="35">潍坊青鸟华光</td>
		<td class="list_data_text" height="35">华北</td>
		<td class="list_data_text" height="35">旺财</td>
		<td class="list_data_text" height="35">合作伙伴</td>
		<td class="list_data_op" height="35">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />&nbsp;<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" />
		</td>
	</tr>
	<tr>
		<td class="list_data_number">9</td>
		<td class="list_data_text">KH071201001</td>
		<td class="list_data_ltext">青鸟无限数码</td>
		<td class="list_data_text">北京</td>
		<td class="list_data_text">周洁轮</td>
		<td class="list_data_text">合作伙伴</td>
		<td class="list_data_op">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />&nbsp;<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" />
		</td>
	</tr>
	<tr>
		<td class="list_data_number">10</td>
		<td class="list_data_text">KH071130003</td>
		<td class="list_data_ltext">北京大学</td>
		<td class="list_data_text">北京</td>
		<td class="list_data_text">孙小美</td>
		<td class="list_data_text">战略合作伙伴</td>
		<td class="list_data_op">
			<img onclick="to('edit.html');" title="编辑" src="../../images/bt_edit.gif" class="op_button" />&nbsp;<img onclick="to('linkman.html');" title="联系人" src="../../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('activities.html');" title="交往记录" src="../../images/bt_acti.gif" class="op_button" />
			<img onclick="to('orders.html');" title="历史订单" src="../../images/bt_orders.gif" class="op_button" />
		</td>
	</tr>
	--><tr>
		<th colspan="100" class="pager">
<div class="pager">
        <input id="page" type="hidden" name="page" value="${pu.page}" />
	共${pu.maxCount}条记录 
	每页${pu.count}条
	第${pu.page}页/共${pu.maxPage}页<s:property value="#request.pu.page"/>
	<a href="javascript:fyJump(1)">第一页</a>
	<a href="javascript:fyJump(${pu.page-1})">上一页</a>
	<a href="javascript:fyJump(${pu.page+1})">下一页</a>
	<a href="javascript:fyJump(${pu.maxPage})">最后一页</a>
	转到<text property="page.currPage" size="2"></text>
	页
	<!-- <button width="20" onclick="add();">GO</button> -->
</div>
		</th>
	</tr>
</table>
</form>

</body>
</html>