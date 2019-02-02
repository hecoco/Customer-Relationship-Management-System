package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.SysRole;
import com.hr.util.PageUtil;

public interface InfSysRoleService {
	//��ѯȫ��
	public List<SysRole> findAll();
	//����
	public Serializable add(SysRole role);
	//��ѯ��ֵ
	public SysRole findId(Serializable id);
	//�޸�
	public void update(SysRole role);
	//ɾ��
	public void delete(SysRole role);
	
	//��ѯ����
	public int findcount(String hql,Object...params);
	//��ѯ��ҳ
	public PageUtil findFy(int page, int count,SysRole role);
 }
