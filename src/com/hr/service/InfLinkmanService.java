package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.CstLinkman;

public interface InfLinkmanService {

	//��ѯ������ϵ��
	public List<CstLinkman> findAll();
	//����id��ѯ������Ϣ
	public Object finfById(Class clazz,Serializable id);
	//�����ϵ��
	public Serializable addlinkman(Object obj);
	//ɾ����ϵ��
	public void dellinkman(CstLinkman clinkman);
	//����id��ѯ��ϵ��
	public Object findlinkamnById(Class clazz,Serializable id);
	//����id�޸���ϵ��
	public void updatelinkman(CstLinkman cl);
}
