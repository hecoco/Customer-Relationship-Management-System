package com.hr.service;

import java.io.Serializable;

import com.hr.pojo.CstActivity;

public interface InfActivity {
//���ݿͻ�id��ѯ���׼�¼
public Object findActivityById(Class clazz,Serializable id);
//��ӽ��׼�¼
public Serializable addActivity(Object obj);
//�޸Ľ��׼�¼
public void updateActivity(CstActivity csty);
//����id��ѯ���н��׼�¼
public Object findById(Class clazz,Serializable id);
//ɾ�����׼�¼
public void delActivity(CstActivity cstty);
}
