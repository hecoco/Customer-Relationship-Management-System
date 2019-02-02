package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.SysRole;
import com.hr.util.PageUtil;

public interface InfSysRoleService {
	//查询全部
	public List<SysRole> findAll();
	//增加
	public Serializable add(SysRole role);
	//查询单值
	public SysRole findId(Serializable id);
	//修改
	public void update(SysRole role);
	//删除
	public void delete(SysRole role);
	
	//查询总数
	public int findcount(String hql,Object...params);
	//查询分页
	public PageUtil findFy(int page, int count,SysRole role);
 }
