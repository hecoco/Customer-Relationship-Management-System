package com.hr.service;

import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.Storage;
import com.hr.util.PageUtil;

public interface InfStorageService {
	//��ѯ
	public List<Storage> findAll();

	
	//��ѯ����
	public int findcount(String hql,Object...params);
	//��ѯ��ҳ
	public PageUtil findFy(int page, int count,Storage sto);
}
