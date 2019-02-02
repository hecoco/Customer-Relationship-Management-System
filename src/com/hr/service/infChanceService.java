package com.hr.service;

import java.util.List;

import com.hr.pojo.SalChance;

public interface infChanceService {

	//查询所有
	public  List<SalChance> querylist(int start, int length);
	//add添加
	public int add(SalChance cs);
	//id查询
	public  SalChance idquerylist(Integer id);
	//修改
	public int update(SalChance sc) ;
	//删除
	public int delete(SalChance id) ;
	//高级查询加分页
	public List<SalChance> querygj(String name,String title,String Linkman,int page,int count );
	//查询表的总页数
	public int findCount(SalChance cs,String name, String title, String Linkman);
	
	
}