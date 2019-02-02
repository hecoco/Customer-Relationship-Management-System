package com.hr.service;

import java.util.List;

import com.hr.pojo.Product;
import com.hr.util.PageUtil;

public interface InfProductService {
	//查询
	public List<Product> findAll();
	
	//查询总数
	public int findcount(String hql,Object...params);
	//查询分页
	public PageUtil findFy(int page, int count,Product prod);
}
