package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.hr.dao.InfCommonsDao;
import com.hr.pojo.SysRole;
import com.hr.service.InfSysRoleService;
import com.hr.util.PageUtil;

public class SysRoleService implements InfSysRoleService {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//查询
	public List<SysRole> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll(SysRole.class);
	}
	//增加
	public Serializable add(SysRole role) {
		
		return cd.add(role);
	}
	//查询单值
	public SysRole findId(Serializable id) {
		
		return (SysRole) cd.findById(SysRole.class, id);
	}
	//修改
	public void update(SysRole role) {
		cd.update(role);
	}
	//删除
	public void delete(SysRole role) {
		cd.del(role);
	}

	public int findcount(String hql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}
	public PageUtil findFy(int page, int count, SysRole role) {

		String counthql="select count(r.roleId) from SysRole r where 1=1";
		String hql="from SysRole where 1=1";
		List params=new ArrayList();
		if(role!=null){
			if(role.getRoleName()!=null && !"".equals(role.getRoleName())){
				counthql+=" and r.roleName like ?";
				hql+=" and roleName like ?";
				params.add("%"+role.getRoleName()+"%");
			}
			if(role.getRoleDesc()!=null && !"".equals(role.getRoleDesc())){
				counthql+=" and r.roleDesc like ?";
				hql+=" and roleDesc like ?";
				params.add("%"+role.getRoleDesc()+"%");
			}
			if(role.getRoleFlag()!=null && role.getRoleFlag()!=0){
				counthql+=" and r.roleFlag = ?";
				hql+=" and roleFlag like ?";
				params.add(role.getRoleFlag());
			}
		}
		
		PageUtil pu=new PageUtil(cd, page, count, counthql, hql, params.toArray());
		System.out.println(pu);
		return pu;
	}
}
