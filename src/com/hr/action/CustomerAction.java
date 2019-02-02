package com.hr.action;

import java.util.List;

import javax.swing.text.html.CSS;

import com.hr.pojo.BasDict;
import com.hr.pojo.CstCustomer;
import com.hr.pojo.SysUser;
import com.hr.service.InfCustomerService;
import com.hr.util.PageUtil;

public class CustomerAction extends BaseAction {

	private InfCustomerService ccs;
	public void setCcs(InfCustomerService ccs) {
		this.ccs = ccs;
	}
	
	private CstCustomer cc;
	private BasDict bbd;
	

	
	
	public BasDict getBbd() {
		return bbd;
	}
	public void setBbd(BasDict bbd) {
		this.bbd = bbd;
	}
	
	//��ѯ���пͻ���Ϣ
	private int page;
	private int count;
	public String findAll()
	{		
		System.out.println("��ѯ���пͻ��ķ���");
	//	List<CstCustomer> cstcs=ccs.findAll();
	//	System.out.println(cstcs);
		PageUtil pu=ccs.findFy(page, count, cc);
		request.put("pu", pu);
		//��ѯ�ֵ�����е���Ϣ
		List<BasDict> basdicts=ccs.findAllbas();
		request.put("list", basdicts);
		//��ѯ�����û�����Ϣ
		List<SysUser> userss=ccs.findAlluser();
		request.put("list1", userss);
		
		return SUCCESS;
	}
	//����id��ѯ���пͻ�
	public String findById()
	{
		System.out.println("�������id��ѯ���пͻ��ķ���--");
		CstCustomer cst= (CstCustomer) ccs.finfById(CstCustomer.class, cc.getCustNo());
		request.put("cst", cst);
		//��ѯ�ֵ�����е���Ϣ
		List<BasDict> basdicts=ccs.findAllbas();
		request.put("list", basdicts);
		//��ѯ�����û�����Ϣ
		List<SysUser> userss=ccs.findAlluser();
		request.put("list1", userss);
		return "bid";
	}
	//�޸Ŀͻ��ķ���
	public String update()
	{
		System.out.println("�����޸ĵķ���");
		ccs.update(cc);
		return "up";
	}
	//ɾ���ͻ���Ϣ
	public String del()
	{
		System.out.println("����ɾ���ķ���");
		ccs.del(cc);
		return "del";
	}
	
	
	
	public CstCustomer getCc() {
		return cc;
	}
	public void setCc(CstCustomer cc) {
		this.cc = cc;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	



	
	
	
	
	
}
