package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.OrdersLine;
import com.hr.pojo.Product;

public interface InfOrders {
	//���ݿͻ�id��ѯ����
public Object findOrdersById(Class clazz,Serializable id);
//��ѯ���ж�������
public List<OrdersLine> findAll();
}
