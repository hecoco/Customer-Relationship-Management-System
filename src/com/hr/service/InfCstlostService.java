package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.CstCustomer;
import com.hr.pojo.CstLost;

public interface InfCstlostService {

	//��ѯ����6����û���µ��Ŀͻ�
	public List<CstCustomer> findlost();
	//�޸�״̬
	public void update(List<CstCustomer> list);
	//�����ʧ�ͻ�
	public Serializable add(Object obj);
	//��ѯ��ʧ�ͻ���������Ϣ
	public List<CstLost> findAll();
	//����id���в�ѯ
	public Object findByid(Class clazz,Serializable id);
	//�޸ķ���
	public void update(CstLost clost);

}
