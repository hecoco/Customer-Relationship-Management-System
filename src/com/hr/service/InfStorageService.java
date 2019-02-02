package com.hr.service;

import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.Storage;
import com.hr.util.PageUtil;

public interface InfStorageService {
	//查询
	public List<Storage> findAll();

	
	//查询总数
	public int findcount(String hql,Object...params);
	//查询分页
	public PageUtil findFy(int page, int count,Storage sto);
}
