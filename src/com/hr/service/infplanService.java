package com.hr.service;

import java.util.List;

import com.hr.pojo.SalChance;
import com.hr.pojo.SalPlan;

public interface infplanService {
    
	//��ҳ��ѯ
	public  List<SalPlan> querylist(int start, int length);
	//��ѯ����
	public  List<SalPlan> querylist();
	//id��ѯ
	public  SalPlan idquerylist(Integer id);
	//add���
	public int add(SalPlan sp);
	//update���
	public int update(SalPlan sp);
	//�߼���ѯ
	public List<SalPlan> querygj(SalChance sc,int page,int count);
	
	//��ѯ���ݿ���������ҳ��
	public int findCount(SalChance sc);
		
	
	
	
}