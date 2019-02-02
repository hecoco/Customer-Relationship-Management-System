package com.hr.service.impl;

import java.io.Serializable;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.CstLinkman;
import com.hr.service.InfLinkmanService;

public class LinkmanServiceImpl implements InfLinkmanService {

	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//查询所有联系人
	
	public List<CstLinkman> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll(CstLinkman.class);
	}
    //根据id查询所有客户
	
	public Object finfById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		 return cd.findById(clazz,id);
	}
	//添加联系人
	
	public Serializable addlinkman(Object obj) {
		// TODO Auto-generated method stub
		return cd.add(obj);
	}
	//删除联系人
	
	public void dellinkman(CstLinkman clinkman) {
	    cd.del(clinkman);
		
	}
	//根据id查询销售机会
	
	public Object findlinkamnById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//根据id修改联系人
	
	public void updatelinkman(CstLinkman cl) {
		// TODO Auto-generated method stub
		cd.update(cl);
	}
}
