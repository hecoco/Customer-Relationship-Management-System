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
	//���ݿͻ�id��ѯ������ϵ��
	public String findActivityById()
	{
		System.out.println("����	���ݿͻ�id��ѯ������ϵ��");
		CstCustomer cstCustomer= (CstCustomer) ia.findActivityById(CstCustomer.class,cct.getCustNo());
		request.put("activitylist", cstCustomer.getActivitys());
		//�ͻ�id������sesion
		session.put("getno", cstCustomer.getCustNo());
		//���ͻ�id��jsp
		request.put("idd", cstCustomer.getCustNo());
		//���ͻ�����daojsp
		request.put("namen", cstCustomer.getCustName());
		return SUCCESS;
	}
	//��ӽ��׼�¼
	public String addActivity()
	{
		System.out.println("������ӽ��׼�¼");
		tivi.setCustomers((CstCustomer) ia.findActivityById(CstCustomer.class, (String)session.get("getno")));
		ia.addActivity(tivi);
		return "add";
	}
	//�޸Ľ��׼�¼
	public String updateActivity()
	{
		System.out.println("�����޸Ľ��׼�¼");
		tivi.setCustomers((CstCustomer)ia.findActivityById(CstCustomer.class,(String)session.get("getno")));
		ia.updateActivity(tivi);
		return "update";
	}
	//����id��ѯ���׼�¼
	public String findById()
	{
	   CstActivity cstylist=  (CstActivity) ia.findById(CstActivity.class, tivi.getAtvId());
	   request.put("cstylist", cstylist);
		return "bid";
	}
	//ɾ�����׼�¼
	public String delActivity()
	{
		System.out.println("����ɾ�����׼�¼");
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
