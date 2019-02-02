package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.SysUser;
import com.hr.util.PageUtil;

public interface InfUserService {
	
	public SysUser login(String name,String pass);
	
	
	
	//查询所有
	public List<SysUser> querylistUser();
	//id查询
	public  SysUser idquerylist(Integer id);
	
	//查询
	public List<SysUser> findAll();
	//添加
	public Serializable add(SysUser user);
	//修改
	public void update(SysUser user);
	//删除
	public void delete(SysUser user);
	//查询id
	public SysUser findById(SysUser user);
	
	
	//查询总数
	public int findcount(String hql,Object...params);
	//查询分页
	public PageUtil findFy(int page, int count,SysUser user);
}
