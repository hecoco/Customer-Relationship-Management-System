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
	
	//查询所有客户信息
	private int page;
	private int count;
	public String findAll()
	{		
		System.out.println("查询所有客户的方法");
	//	List<CstCustomer> cstcs=ccs.findAll();
	//	System.out.println(cstcs);
		PageUtil pu=ccs.findFy(page, count, cc);
		request.put("pu", pu);
		//查询字典表所有的信息
		List<BasDict> basdicts=ccs.findAllbas();
		request.put("list", basdicts);
		//查询所有用户的信息
		List<SysUser> userss=ccs.findAlluser();
		request.put("list1", userss);
		
		return SUCCESS;
	}
	//根据id查询所有客户
	public String findById()
	{
		System.out.println("进入根据id查询所有客户的方法--");
		CstCustomer cst= (CstCustomer) ccs.finfById(CstCustomer.class, cc.getCustNo());
		request.put("cst", cst);
		//查询字典表所有的信息
		List<BasDict> basdicts=ccs.findAllbas();
		request.put("list", basdicts);
		//查询所有用户的信息
		List<SysUser> userss=ccs.findAlluser();
		request.put("list1", userss);
		return "bid";
	}
	//修改客户的方法
	public String update()
	{
		System.out.println("进入修改的方法");
		ccs.update(cc);
		return "up";
	}
	//删除客户信息
	public String del()
	{
		System.out.println("进入删除的方法");
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
