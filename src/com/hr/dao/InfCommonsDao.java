package com.hr.dao;

import java.io.Serializable;
import java.util.List;

public interface InfCommonsDao {
	//��ӵķ���
	public Serializable add(Object obj);
	//ɾ���ķ���
	public void del(Object obj);
	//�޸ĵķ���
	public void update(Object obj);
	//��ѯ���еķ���
	public List findAll(Class clazz);
	//����id���в�ѯ�ķ���
	public Object findById(Class clazz,Serializable id);
	
	public List findAllHQL(String hql,Object...params);
	//��ҳ�ķ���
	//��ѯ������������������
	public int findCount(String hql,Object...params);
	//��ѯ�������������ݼ���
	public List findFy(int index,int count,String hql,Object...params);
	//��ѯ����6����û�µ��Ŀͻ�
	public List findlost(String sql,Class clazz);
	
	
	
	

	

	

	
	
	

	
	public List findAllHQLgj(final String hql,final int first,final int count,final Object...params);
	
	public List findAllHQLgj(final String hql,final List params,final int first,final int count);
	
	public List findAllHQLfy(final String hql,final int start ,final int length);
    
	
	
	
	
	
	
	
}
