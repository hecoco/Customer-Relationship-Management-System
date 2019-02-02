package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.CstService;

public interface InfServiceService {

	public Serializable add(CstService cs);
	public List<CstService> findall(CstService chance,int page,int count,String svrCreateDate1);
	public void del(CstService cs);
	public CstService findByid(Serializable id);
	public void update(CstService cs);
	
}
