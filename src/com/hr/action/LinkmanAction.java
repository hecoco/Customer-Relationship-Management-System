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
//���ݿͻ�id��ѯ����������ϵ��
public String findcustomerById()
{
	System.out.println("������ݿͻ�id��ѯ����������ϵ��");
	CstCustomer cstCustomer=(CstCustomer) ils.finfById(CstCustomer.class, cct.getCustNo());
	request.put("linklist", cstCustomer.getLinkmans());
	session.put("getno", cstCustomer.getCustNo());
	request.put("idd", cstCustomer.getCustNo());
	request.put("namen", cstCustomer.getCustName());
	return "customerById";
	}

//�����ϵ��
public String addlinkman()
{
	System.out.println("���������ϵ��");
	clk.setCustomers((CstCustomer)ils.finfById(CstCustomer.class,(String)session.get("getno")));
	ils.addlinkman(clk);
	return "add";
	}
//ɾ����ϵ��
public String dellinkman()
{
	System.out.println("����ɾ����ϵ��");
	  //
	  ils.dellinkman(clk);
	  clk.setCustomers((CstCustomer)ils.finfById(CstCustomer.class, (String)session.get("getno")));
	  return "del";
	}
//����id��ѯ���ۻ���
public String findByIdlinkman()
{
	System.out.println("�������id��ѯ���ۻ���");
	CstLinkman cl= (CstLinkman) ils.findlinkamnById(CstLinkman.class, clk.getLkmId());
	request.put("cl", cl);
	return "bid";
	}
//����id�޸���ϵ��
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
