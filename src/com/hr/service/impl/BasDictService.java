package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.BasDict;
import com.hr.service.InfBasDictService;
import com.hr.util.PageUtil;

public class BasDictService implements InfBasDictService{
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//查询
	public List<BasDict> findAll() {
		return cd.findAll(BasDict.class);
	}
	//增加
	public Serializable addBasDict(BasDict bd) {
		return cd.add(bd);
	}
	//查询单值
	public BasDict findId(Serializable id) {
		
		return (BasDict) cd.findById(BasDict.class, id);
	}
	//修改
	public void update(BasDict bd) {
		cd.update(bd);
	}
	//删除
	public void delete(BasDict bd) {
		cd.del(bd);
	}

	
	
	public int findcount(String hql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}
	public PageUtil findFy(int page, int count, BasDict dict) {
		String counthql="select count(s.dictId) from BasDict s where 1=1";
		String hql="from BasDict where 1=1";
		List params=new ArrayList();
		if(dict!=null){
			if(dict.getDictType()!=null && !"".equals(dict.getDictType())){
				counthql+=" and s.dictType like ?";
				hql+=" and dictType like ?";
				params.add(dict.getDictType());
			}
			if(dict.getDictItem()!=null && !"".equals(dict.getDictItem())){
				counthql+=" and s.dictItem like ?";
				hql+=" and dictItem like ?";
				params.add(dict.getDictItem());
			}
			if(dict.getDictValue()!=null && !"".equals(dict.getDictValue())){
				counthql+=" and s.dictValue like ?";
				hql+=" and dictValue like ?";
				params.add(dict.getDictValue());
			}
		}
		PageUtil pu=new PageUtil(cd, page, count, counthql, hql, params.toArray());
		return pu;
	}
}
