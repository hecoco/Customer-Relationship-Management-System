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
	//��ѯ������ϵ��
	
	public List<CstLinkman> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll(CstLinkman.class);
	}
    //����id��ѯ���пͻ�
	
	public Object finfById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		 return cd.findById(clazz,id);
	}
	//�����ϵ��
	
	public Serializable addlinkman(Object obj) {
		// TODO Auto-generated method stub
		return cd.add(obj);
	}
	//ɾ����ϵ��
	
	public void dellinkman(CstLinkman clinkman) {
	    cd.del(clinkman);
		
	}
	//����id��ѯ���ۻ���
	
	public Object findlinkamnById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//����id�޸���ϵ��
	
	public void updatelinkman(CstLinkman cl) {
		// TODO Auto-generated method stub
		cd.update(cl);
	}
}
