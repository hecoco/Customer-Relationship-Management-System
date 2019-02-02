package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.CstLinkman;

public interface InfLinkmanService {

	//查询所有联系人
	public List<CstLinkman> findAll();
	//根据id查询所有信息
	public Object finfById(Class clazz,Serializable id);
	//添加联系人
	public Serializable addlinkman(Object obj);
	//删除联系人
	public void dellinkman(CstLinkman clinkman);
	//根据id查询联系人
	public Object findlinkamnById(Class clazz,Serializable id);
	//根据id修改联系人
	public void updatelinkman(CstLinkman cl);
}
