package com.hr.service;

import java.util.List;

import com.hr.pojo.SalChance;

public interface infChanceService {

	//��ѯ����
	public  List<SalChance> querylist(int start, int length);
	//add���
	public int add(SalChance cs);
	//id��ѯ
	public  SalChance idquerylist(Integer id);
	//�޸�
	public int update(SalChance sc) ;
	//ɾ��
	public int delete(SalChance id) ;
	//�߼���ѯ�ӷ�ҳ
	public List<SalChance> querygj(String name,String title,String Linkman,int page,int count );
	//��ѯ�����ҳ��
	public int findCount(SalChance cs,String name, String title, String Linkman);
	
	
}