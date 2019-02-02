package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.OrdersLine;
import com.hr.pojo.Product;

public interface InfOrders {
	//根据客户id查询订单
public Object findOrdersById(Class clazz,Serializable id);
//查询所有订单详情
public List<OrdersLine> findAll();
}
