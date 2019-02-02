package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.SysUser;
import com.hr.util.PageUtil;

public interface InfUserService {
	
	public SysUser login(String name,String pass);
	
	
	
	//��ѯ����
	public List<SysUser> querylistUser();
	//id��ѯ
	public  SysUser idquerylist(Integer id);
	
	//��ѯ
	public List<SysUser> findAll();
	//���
	public Serializable add(SysUser user);
	//�޸�
	public void update(SysUser user);
	//ɾ��
	public void delete(SysUser user);
	//��ѯid
	public SysUser findById(SysUser user);
	
	
	//��ѯ����
	public int findcount(String hql,Object...params);
	//��ѯ��ҳ
	public PageUtil findFy(int page, int count,SysUser user);
}
