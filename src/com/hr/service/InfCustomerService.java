package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.BasDict;
import com.hr.pojo.CstCustomer;
import com.hr.pojo.SysUser;
import com.hr.util.PageUtil;

public interface InfCustomerService {
//��ѯ���пͻ���Ϣ
public List<CstCustomer> findAll();
//����id��ѯ������Ϣ
public Object finfById(Class clazz,Serializable id);
//��ѯ�ֵ�����е���Ϣ
public List<BasDict> findAllbas();
//��ѯ�����û�����Ϣ
public List<SysUser> findAlluser();
//�޸Ŀͻ���Ϣ
public void update(CstCustomer cst);

//��ѯ�������������ݼ���
public PageUtil findFy(int page,int count,CstCustomer cst);
//ɾ���ͻ���Ϣ
public void del(CstCustomer cstCustomer);
}
