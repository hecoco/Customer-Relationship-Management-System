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
	
	
	//查询
	public String findAll(){
		System.out.println("asdasd");
//		List<SysRole> roles=rs.findAll();
		PageUtil pu= rs.findFy(page, count, role);
		//由于pageutil中所有关于分页的数据（页数，最大页数，最大页数，集合数据。。。都有）;直接将pageutil绑定到request中
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
	//查询单值
	public String findid(){
		SysRole sr= rs.findId(role.getRoleId());
		request.put("sr",sr);
		
		List<SysRight> rights=rg.findAll();
		request.put("rights", rights);
		return "sid";
	}
	//权限id集合
	private List<String> sysRight;
	
	public List<String> getSysRight() {
		return sysRight;
	}
	public void setSysRight(List<String> sysRight) {
		this.sysRight = sysRight;
	}
	//修改权限
	public String update(){
		//1找到赋予的角色
		SysRole r= rs.findId(role.getRoleId());
		//2将权限集合赋值给角色
		System.out.println("接收到等等需要赋予当前角色的Id"+sysRight);
		//获得的都是权限的ID集合，而不是权限对象的集合
		//根据权限的ID集合查询所有的权限对象
		List<SysRight> list= rg.findByIds(sysRight);
		//角色与多个权限建立关系
		r.setRights(list);
		//3修改
		rs.update(r);
		
		return SUCCESS;
	}
	//查询
	public String findiddetail(){
		SysRole r= rs.findId(role.getRoleId());
		request.put("r", r);
		return "detail";
	}
	//根据id查询编辑
	public String findidedit(){
		SysRole sys= rs.findId(role.getRoleId());
		request.put("sys", sys);
		return "edit";
	}
	//修改
	public String updateedit(){
		rs.update(role);
		return SUCCESS;
	}
	//添加
	public String add(){
		rs.add(role);
		return SUCCESS;
	}
	//删除
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
