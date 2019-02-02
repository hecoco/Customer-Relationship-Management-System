package com.hr.action;

import java.io.Serializable;

import com.hr.pojo.CstActivity;
import com.hr.pojo.CstCustomer;
import com.hr.service.InfActivity;

public class ActivityAction extends BaseAction {

	private InfActivity ia;
	public void setIa(InfActivity ia) {
		this.ia = ia;
	}
	
	private CstCustomer cct;
	private CstActivity tivi;
	//根据客户id查询所有联系人
	public String findActivityById()
	{
		System.out.println("进入	根据客户id查询所有联系人");
		CstCustomer cstCustomer= (CstCustomer) ia.findActivityById(CstCustomer.class,cct.getCustNo());
		request.put("activitylist", cstCustomer.getActivitys());
		//客户id保存在sesion
		session.put("getno", cstCustomer.getCustNo());
		//传客户id到jsp
		request.put("idd", cstCustomer.getCustNo());
		//传客户名称daojsp
		request.put("namen", cstCustomer.getCustName());
		return SUCCESS;
	}
	//添加交易记录
	public String addActivity()
	{
		System.out.println("进入添加交易记录");
		tivi.setCustomers((CstCustomer) ia.findActivityById(CstCustomer.class, (String)session.get("getno")));
		ia.addActivity(tivi);
		return "add";
	}
	//修改交易记录
	public String updateActivity()
	{
		System.out.println("进入修改交易记录");
		tivi.setCustomers((CstCustomer)ia.findActivityById(CstCustomer.class,(String)session.get("getno")));
		ia.updateActivity(tivi);
		return "update";
	}
	//根据id查询交易记录
	public String findById()
	{
	   CstActivity cstylist=  (CstActivity) ia.findById(CstActivity.class, tivi.getAtvId());
	   request.put("cstylist", cstylist);
		return "bid";
	}
	//删除交易记录
	public String delActivity()
	{
		System.out.println("进入删除交易记录");
		tivi.setCustomers((CstCustomer)ia.findActivityById(CstCustomer.class,(String)session.get("getno")));
		ia.delActivity(tivi);
		return "del";
	}

	public CstCustomer getCct() {
		return cct;
	}

	public void setCct(CstCustomer cct) {
		this.cct = cct;
	}

	public CstActivity getTivi() {
		return tivi;
	}

	public void setTivi(CstActivity tivi) {
		this.tivi = tivi;
	}
	
	
	
}
