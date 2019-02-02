package com.hr.service.impl;

import java.io.Serializable;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.CstCustomer;
import com.hr.pojo.CstLost;
import com.hr.service.InfCstlostService;

public class CstlostServiceImpl implements InfCstlostService {

	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	
	public List<CstCustomer> findlost() {
		// TODO Auto-generated method stub
		return cd.findlost("select c.*,odr_date from cst_customer c LEFT JOIN orders o ON c.cust_no=o.odr_customer GROUP BY c.cust_no,c.cust_name HAVING DATEDIFF(CURDATE(),MAX(o.odr_date))>180",CstCustomer.class);
	}
	
	public void update(List<CstCustomer> list) {
		for (CstCustomer c: list) {
			c.setCustStatus("2");
			cd.update(c);
		}
		
	}
	
	public Serializable add(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("......");
		return cd.add(obj);
	}
	
	public List<CstLost> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll(CstLost.class);
	}
	
	public Object findByid(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return cd.findById(clazz, id);
	}
	
	public void update(CstLost clost) {
		// TODO Auto-generated method stub
		cd.update(clost);
	}
	

}
