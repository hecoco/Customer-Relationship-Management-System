package com.hr.dao;

import java.io.Serializable;
import java.util.List;

public interface InfCommonsDao {
	//添加的方法
	public Serializable add(Object obj);
	//删除的方法
	public void del(Object obj);
	//修改的方法
	public void update(Object obj);
	//查询所有的方法
	public List findAll(Class clazz);
	//根据id进行查询的方法
	public Object findById(Class clazz,Serializable id);
	
	public List findAllHQL(String hql,Object...params);
	//分页的方法
	//查询符合条件的数据总数
	public int findCount(String hql,Object...params);
	//查询符合条件的数据集合
	public List findFy(int index,int count,String hql,Object...params);
	//查询超过6个月没下单的客户
	public List findlost(String sql,Class clazz);
	
	
	
	

	

	

	
	
	

	
	public List findAllHQLgj(final String hql,final int first,final int count,final Object...params);
	
	public List findAllHQLgj(final String hql,final List params,final int first,final int count);
	
	public List findAllHQLfy(final String hql,final int start ,final int length);
    
	
	
	
	
	
	
	
}
