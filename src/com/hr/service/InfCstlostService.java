package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.CstCustomer;
import com.hr.pojo.CstLost;

public interface InfCstlostService {

	//查询超过6个月没有下单的客户
	public List<CstCustomer> findlost();
	//修改状态
	public void update(List<CstCustomer> list);
	//添加流失客户
	public Serializable add(Object obj);
	//查询流失客户的所有信息
	public List<CstLost> findAll();
	//根据id进行查询
	public Object findByid(Class clazz,Serializable id);
	//修改方法
	public void update(CstLost clost);

}
