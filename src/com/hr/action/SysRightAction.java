package com.hr.action;

import java.util.List;

import com.hr.pojo.SysRight;
import com.hr.pojo.SysRole;
import com.hr.service.InfRightService;
import com.hr.util.PageUtil;

public class SysRightAction extends BaseAction{
	private InfRightService rg;
	public void setRg(InfRightService rg) {
		this.rg = rg;
	}
	
	private SysRight right;
	private int page;
	private int count;
	//��ѯ
	public String findAll(){
		/*List<SysRight> list= rg.findAll();*/
		PageUtil pu=rg.findFy(page, count, right);
		List<SysRight> list= rg.findAll();
		request.put("pu", pu);
		request.put("list", list);
		return "sele";
	}
	//��Ӳ�ѯ
	public String findAlladd(){
		List<SysRight> list= rg.findAll();
		request.put("list", list);
		return "sead";
	}
	//���
	public String add(){
		rg.add(right);
		return SUCCESS;
	}
	//ɾ��
	public String delete(){
		rg.delete(right);
		return SUCCESS;
	}
	//�鿴
	public String findcK(){
		SysRight r= rg.findid(right); 
		request.put("r", r);
		return "ck";
	}
	//��ѯid
	public String findbyid(){
		SysRight rr= rg.findid(right);
		request.put("rr", rr);
		
		List<SysRight> list= rg.findAll();
		request.put("list", list);
		return "findid";
	}
	//�޸�
	public String update(){
		
		SysRight sr=rg.findi(right.getRightCode());
		right.setRoles(sr.getRoles());
		rg.update(right);
		return SUCCESS;
	}
	public SysRight getRight() {
		return right;
	}
	public void setRight(SysRight right) {
		this.right = right;
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
