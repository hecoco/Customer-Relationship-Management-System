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
	//���ݿͻ�id��ѯ������ϵ��
	
	public Object findActivityById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//��ӽ��׼�¼
	
	public Serializable addActivity(Object obj) {
		// TODO Auto-generated method stub
		return cd.add(obj);
	}
	//�޸Ľ��׼�¼
	
	public void updateActivity(CstActivity csty) {
		// TODO Auto-generated method stub
		cd.update(csty);
		
	}
	//����id��ѯ���н��׼�¼
	
	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//ɾ�����׼�¼
	
	public void delActivity(CstActivity cstty) {
		// TODO Auto-generated method stub
		cd.del(cstty);
	}

}
