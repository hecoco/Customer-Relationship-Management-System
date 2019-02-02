package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.BasDict;
import com.hr.util.PageUtil;

public interface InfBasDictService {
	//查询
	public List<BasDict> findAll();
	//添加
	public Serializable addBasDict(BasDict bd);
	//查询单值
	public BasDict findId(Serializable id);
	//修改
	public void update(BasDict bd);
	//删除
	public void delete(BasDict bd);
	
	
	//查询总数
	public int findcount(String hql,Object...params);
	//查询分页
	public PageUtil findFy(int page, int count,BasDict dict);
}
