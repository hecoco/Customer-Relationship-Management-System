package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.SysRight;
import com.hr.util.PageUtil;

public interface InfRightService {
	//查询
	public List<SysRight> findAll();
	//查询id集合
	public List<SysRight> findByIds(List<String> ids);
	//增加
	public Serializable add(SysRight right);
	//修改
	public void update(SysRight right);
	//删除
	public void delete(SysRight right);
	//查询id
	public SysRight findid(SysRight right);
	//
	public SysRight findi(String id);
	
	
	//查询总数
	public int findcount(String hql,Object...params);
	//查询分页
	public PageUtil findFy(int page, int count,SysRight right);
}
