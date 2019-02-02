<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jb-aptech毕业设计项目</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/html/css/style.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/html/script/common.js"></script>
	</head>
	<body>

		<div class="page_title">
			客户信息管理 > 客户信息
		</div>
		<div class="button_bar">
			<button class="common_button" onclick="help('');">
				帮助
			</button>
			<button class="common_button" onclick="to('link!findcustomerById?cct.custNo=${cst.custNo}');">
				联系人
			</button>
			<button class="common_button" onclick="to('csta!findActivityById?cct.custNo=${cst.custNo}');">
				交往记录
			</button>
			<button class="common_button" onclick="to('orde!findOrdersById?cct.custNo=${cst.custNo}');">
				历史订单
			</button>

			<button class="common_button" onclick="back();">
				返回
			</button>
			<!-- document.getElementById('form1').submit() -->
			  <button class="common_button" onclick="document.getElementById('form1').submit()">保存</button>
		</div>
		<form action="cstc!update" method="post" id="form1">
		<table class="query_form_table">
			<tr>
				<th>
					客户编号
				</th>
				<td>
					${cst.custNo}
				</td>
				<th>
					名称
				</th>
				<td>
					<input value="${cst.custName}" name="cc.custName" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					地区
				</th>
				<td>
					<select name="cc.custRegion">
						<option>
							请选择...
						</option>
						<!-- 所有地区 -->
						<s:iterator value="#request.list" var="bb">
							<s:if test="#request.bb.dictType == '地区'">
								<option value="${bb.dictValue}"
									<s:if test="#request.cst.custRegion == #request.bb.dictValue">selected="selected"</s:if>>
									${bb.dictItem}
								</option>
							</s:if>
						</s:iterator>
					</select>
					<span class="red_star">*</span>
				</td>
				<th>
					客户经理
				</th>
				<td>
					<select name="cc.sysusers.usrId">
						<option>
							请选择...
						</option>
						<!-- 所有用户 -->
						<s:iterator value="#request.list1" var="bb1">
							<option value="${bb1.usrId}"
								<s:if test="#request.cst.sysusers.usrId == #request.bb1.usrId">selected="selected"</s:if>>
								${bb1.usrId}
							</option>
						</s:iterator>

					</select>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					客户等级
				</th>
				<td>
					<select name="cc.basd.dictId">
						<option>
							请选择...
						</option>
						<!-- 所有客户等级 -->
						<s:iterator value="#request.list" var="bb">
							<s:if test="#request.bb.dictType == '企业客户等级'">
								<option value="${bb.dictId}"
									<s:if test="#request.cst.basd.dictId == #request.bb.dictId">selected="selected"</s:if>>
									${bb.dictItem}
								</option>
							</s:if>
						</s:iterator>

					</select>
					<span class="red_star">*</span>
				</td>
				<th>
				</th>
				<td>
				</td>
			</tr>
            
            <th>
					客户满意度
				</th>
				<td>
					<!--<s:iterator var="i" begin="1" end="5">
						☆
					</s:iterator>-->
					<select name="cc.custSatisfy">
						<option value="">
							未指定
						</option>
                        <!-- 客户满意度 -->
						<s:iterator value="#request.list" var="bb">
							<s:if test="#request.bb.dictType == '满意度'">
								<option value="${bb.dictValue}"
									<s:if test="#request.cst.custSatisfy == #request.bb.dictValue">selected="selected"</s:if>>
									${bb.dictItem}
								</option>
							</s:if>
						</s:iterator>

					</select>
					<span class="red_star">*</span>
				</td>
               
               <th>
					客户信用度
				</th>
				<td>
					<select name="cc.custCredit">
						<option value="">
							未指定
						</option>
						  <!-- 客户信用度 -->
						<s:iterator value="#request.list" var="bb">
							<s:if test="#request.bb.dictType == '信用度'">
								<option value="${bb.dictValue}"
									<s:if test="#request.cst.custCredit == #request.bb.dictValue">selected="selected"</s:if>>
									${bb.dictItem}
								</option>
							</s:if>
						</s:iterator>
						
					</select>
					<span class="red_star">*</span>
				</td>
			</tr>


		</table>
		<br />
		<table class="query_form_table" id="table1">
			<tr>
				<th>
					地址
				</th>
				<td>
					<input value="${cst.custAddr}" name="cc.custAddr" />
					<span class="red_star">*</span>
				</td>
				<th>
					邮政编码
				</th>
				<td>
					<input value="${cst.custZip}" name="cc.custZip" size="20" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					电话
				</th>
				<td>
					<input value="${cst.custTel}" name="cc.custTel" size="20" />
					<span class="red_star">*</span>
				</td>
				<th>
					传真
				</th>
				<td>
					<input value="${cst.custFax}" name="cc.custFax" size="20" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					网址
				</th>
				<td>
					<input value="${cst.custWebsite}" name="cc.custWebsite" size="20" />
					<span class="red_star">*</span>
				</td>
				<th>
				</th>
				<td>
				</td>
			</tr>
		</table>
		<br />
		<table class="query_form_table" id="table2">
			<tr>
				<th>
					营业执照注册号
				</th>
				<td>
					<input value="${cst.custLicenceNo}" name="cc.custLicenceNo"
						size="20" />
				</td>
				<th>
					法人
				</th>
				<td>
					<input value="${cst.custChieftain}" name="cc.custChieftain"
						size="20" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					注册资金（万元）
				</th>
				<td>
					<input value="${cst.custBankroll}" name="cc.custBankroll" size="20" />
				</td>
				<th>
					年营业额
				</th>
				<td>
					<input value="${cst.custTurnover}" name="cc.custTurnover" size="20" />
				</td>
			</tr>
			<tr>
				<th>
					开户银行
				</th>
				<td>
					<input value="${cst.custBank}" name="cc.custBank" size="20" />
					<span class="red_star">*</span>
				</td>
				<th>
					银行帐号
				</th>
				<td>
					<input value="${cst.custBankAccount}" name="cc.custBankAccount"
						size="20" />
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					地税登记号
				</th>
				<td>
					<input value="${cst.custLocalTaxNo}" name="cc.custLocalTaxNo"
						size="20" />
				</td>
				<th>
					国税登记号
				</th>
				<td>
					<input value="${cst.custNationalTaxNo}" name="cc.custNationalTaxNo"
						size="20" />
				</td>
			</tr>
		</table>
		</form>
		<p>
		</p>
	</body>
</html>