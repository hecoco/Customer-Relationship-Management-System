package com.hr.service;

import java.util.List;

import com.hr.pojo.Product;
import com.hr.util.PageUtil;

public interface InfProductService {
	//��ѯ
	public List<Product> findAll();
	
	//��ѯ����
	public int findcount(String hql,Object...params);
	//��ѯ��ҳ
	public PageUtil findFy(int page, int count,Product prod);
}
