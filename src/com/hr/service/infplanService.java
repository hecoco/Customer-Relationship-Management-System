package com.hr.service;

import java.util.List;

import com.hr.pojo.SalChance;
import com.hr.pojo.SalPlan;

public interface infplanService {
    
	//分页查询
	public  List<SalPlan> querylist(int start, int length);
	//查询所有
	public  List<SalPlan> querylist();
	//id查询
	public  SalPlan idquerylist(Integer id);
	//add添加
	public int add(SalPlan sp);
	//update添加
	public int update(SalPlan sp);
	//高级查询
	public List<SalPlan> querygj(SalChance sc,int page,int count);
	
	//查询数据库里面表的总页数
	public int findCount(SalChance sc);
		
	
	
	
}