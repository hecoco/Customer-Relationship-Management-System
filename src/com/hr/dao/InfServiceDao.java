package com.hr.dao;

import java.util.List;

import com.hr.pojo.CstService;

public interface InfServiceDao {
	public  List<CstService>  findFy(String hql,List params,int page,int count,String svrCreateDate1);
}
