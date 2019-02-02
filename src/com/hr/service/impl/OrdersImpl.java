package com.hr.service.impl;

import java.io.Serializable;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.OrdersLine;
import com.hr.pojo.Product;
import com.hr.service.InfOrders;
import com.sun.xml.internal.ws.util.xml.CDATA;

public class OrdersImpl implements InfOrders {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	
	//根据客户id查询订单
	
	public Object findOrdersById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	//查询所有订单详情
	
	public List<OrdersLine> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll(OrdersLine.class);
	}

	

}
