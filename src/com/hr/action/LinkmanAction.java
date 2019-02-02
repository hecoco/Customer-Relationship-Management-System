package com.hr.action;

import java.util.List;

import com.hr.pojo.CstCustomer;
import com.hr.pojo.CstLinkman;
import com.hr.service.InfLinkmanService;

public class LinkmanAction extends BaseAction {
private InfLinkmanService ils;
public void setIls(InfLinkmanService ils) {
	this.ils = ils;
}

private CstLinkman clk;
private CstCustomer cct;
//根据客户id查询属于他的联系人
public String findcustomerById()
{
	System.out.println("进入根据客户id查询属于他的联系人");
	CstCustomer cstCustomer=(CstCustomer) ils.finfById(CstCustomer.class, cct.getCustNo());
	request.put("linklist", cstCustomer.getLinkmans());
	session.put("getno", cstCustomer.getCustNo());
	request.put("idd", cstCustomer.getCustNo());
	request.put("namen", cstCustomer.getCustName());
	return "customerById";
	}

//添加联系人
public String addlinkman()
{
	System.out.println("进入添加联系人");
	clk.setCustomers((CstCustomer)ils.finfById(CstCustomer.class,(String)session.get("getno")));
	ils.addlinkman(clk);
	return "add";
	}
//删除联系人
public String dellinkman()
{
	System.out.println("进入删除联系人");
	  //
	  ils.dellinkman(clk);
	  clk.setCustomers((CstCustomer)ils.finfById(CstCustomer.class, (String)session.get("getno")));
	  return "del";
	}
//根据id查询销售机会
public String findByIdlinkman()
{
	System.out.println("进入根据id查询销售机会");
	CstLinkman cl= (CstLinkman) ils.findlinkamnById(CstLinkman.class, clk.getLkmId());
	request.put("cl", cl);
	return "bid";
	}
//根据id修改联系人
public String updatelinkman()
{
	clk.setCustomers((CstCustomer)ils.finfById(CstCustomer.class,(String)session.get("getno")));
	ils.updatelinkman(clk);
	
	return "update";
	}

public CstLinkman getClk() {
	return clk;
}
public void setClk(CstLinkman clk) {
	this.clk = clk;
}
public CstCustomer getCct() {
	return cct;
}
public void setCct(CstCustomer cct) {
	this.cct = cct;
}



}
