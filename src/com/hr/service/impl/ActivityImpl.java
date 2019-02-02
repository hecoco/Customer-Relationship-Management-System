package com.hr.service.impl;

import java.io.Serializable;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.CstActivity;
import com.hr.service.InfActivity;

public class ActivityImpl implements InfActivity {

	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//根据客户id查询所有联系人
	
	public Object findActivityById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//添加交易记录
	
	public Serializable addActivity(Object obj) {
		// TODO Auto-generated method stub
		return cd.add(obj);
	}
	//修改交易记录
	
	public void updateActivity(CstActivity csty) {
		// TODO Auto-generated method stub
		cd.update(csty);
		
	}
	//根据id查询所有交易记录
	
	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//删除交易记录
	
	public void delActivity(CstActivity cstty) {
		// TODO Auto-generated method stub
		cd.del(cstty);
	}

}
