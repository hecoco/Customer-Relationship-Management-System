package com.hr.action;

import java.util.List;

import com.hr.pojo.SysRight;
import com.hr.pojo.SysRole;
import com.hr.service.InfRightService;
import com.hr.service.InfSysRoleService;
import com.hr.util.PageUtil;

public class SysRoleAction extends BaseAction {
	private InfSysRoleService rs;
	public void setRs(InfSysRoleService rs) {
		this.rs = rs;
	}
	private InfRightService rg;
	public void setRg(InfRightService rg) {
		this.rg = rg;
	}
	private int page;
	private int count;
	
	
	//��ѯ
	public String findAll(){
		System.out.println("asdasd");
//		List<SysRole> roles=rs.findAll();
		PageUtil pu= rs.findFy(page, count, role);
		//����pageutil�����й��ڷ�ҳ�����ݣ�ҳ�������ҳ�������ҳ�����������ݡ��������У�;ֱ�ӽ�pageutil�󶨵�request��
		request.put("pu", pu);
		return "sele";
	}
	private SysRole role;
	
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	//��ѯ��ֵ
	public String findid(){
		SysRole sr= rs.findId(role.getRoleId());
		request.put("sr",sr);
		
		List<SysRight> rights=rg.findAll();
		request.put("rights", rights);
		return "sid";
	}
	//Ȩ��id����
	private List<String> sysRight;
	
	public List<String> getSysRight() {
		return sysRight;
	}
	public void setSysRight(List<String> sysRight) {
		this.sysRight = sysRight;
	}
	//�޸�Ȩ��
	public String update(){
		//1�ҵ�����Ľ�ɫ
		SysRole r= rs.findId(role.getRoleId());
		//2��Ȩ�޼��ϸ�ֵ����ɫ
		System.out.println("���յ��ȵ���Ҫ���赱ǰ��ɫ��Id"+sysRight);
		//��õĶ���Ȩ�޵�ID���ϣ�������Ȩ�޶���ļ���
		//����Ȩ�޵�ID���ϲ�ѯ���е�Ȩ�޶���
		List<SysRight> list= rg.findByIds(sysRight);
		//��ɫ����Ȩ�޽�����ϵ
		r.setRights(list);
		//3�޸�
		rs.update(r);
		
		return SUCCESS;
	}
	//��ѯ
	public String findiddetail(){
		SysRole r= rs.findId(role.getRoleId());
		request.put("r", r);
		return "detail";
	}
	//����id��ѯ�༭
	public String findidedit(){
		SysRole sys= rs.findId(role.getRoleId());
		request.put("sys", sys);
		return "edit";
	}
	//�޸�
	public String updateedit(){
		rs.update(role);
		return SUCCESS;
	}
	//���
	public String add(){
		rs.add(role);
		return SUCCESS;
	}
	//ɾ��
	public String delete(){
		rs.delete(role);
		return SUCCESS;
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
