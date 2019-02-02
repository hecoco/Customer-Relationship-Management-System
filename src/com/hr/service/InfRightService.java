package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.SysRight;
import com.hr.util.PageUtil;

public interface InfRightService {
	//��ѯ
	public List<SysRight> findAll();
	//��ѯid����
	public List<SysRight> findByIds(List<String> ids);
	//����
	public Serializable add(SysRight right);
	//�޸�
	public void update(SysRight right);
	//ɾ��
	public void delete(SysRight right);
	//��ѯid
	public SysRight findid(SysRight right);
	//
	public SysRight findi(String id);
	
	
	//��ѯ����
	public int findcount(String hql,Object...params);
	//��ѯ��ҳ
	public PageUtil findFy(int page, int count,SysRight right);
}
