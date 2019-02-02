package com.hr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.Product;
import com.hr.service.InfProductService;
import com.hr.util.PageUtil;

public class ProductService implements InfProductService {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//≤È—Ø
	public List<Product> findAll() {
		
		return cd.findAll(Product.class);
	}

	
	public int findcount(String hql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}
	public PageUtil findFy(int page, int count, Product prod) {
		String counthql="select count(s.prodId) from Product s where 1=1";
		String hql="from Product where 1=1";
		List params=new ArrayList();
		if(prod!=null){
			if(prod.getProdName()!=null && !"".equals(prod.getProdName())){
				counthql+=" and s.prodName like ?";
				hql+=" and prodName like ?";
				params.add("%"+prod.getProdName()+"%");
			}
			if(prod.getProdType()!=null && !"".equals(prod.getProdType())){
				counthql+=" and s.prodType like ?";
				hql+=" and prodType like ?";
				params.add("%"+prod.getProdType()+"%");
			}
			if(prod.getProdBatch()!=null && !"".equals(prod.getProdBatch())){
				counthql+=" and s.prodBatch like ?";
				hql+=" and prodBatch like ?";
				params.add("%"+prod.getProdBatch()+"%");
			}
		}
		PageUtil pu=new PageUtil(cd, page, count, counthql, hql, params.toArray());
		return pu;
	}
}
