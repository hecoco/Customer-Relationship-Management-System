package com.hr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.Storage;
import com.hr.service.InfStorageService;
import com.hr.util.PageUtil;

public class StorageService implements InfStorageService {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//≤È—Ø
	public List<Storage> findAll() {
		return cd.findAll(Storage.class);
	}
	public int findcount(String hql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}
	public PageUtil findFy(int page, int count, Storage sto) {
		String counthql="select count(s.stkId) from Storage s where 1=1";
		String hql="from Storage where 1=1";
		List params=new ArrayList();
		if(sto!=null){
			if(sto.getStkProdId()!=null && !"".equals(sto.getStkProdId())){
				counthql+=" and s.stkProdId = ?";
				hql+=" and stkProdId = ?";
				params.add(sto.getStkProdId());
			}
			if(sto.getStkWarehouse()!=null && !"".equals(sto.getStkWarehouse())){
				counthql+=" and s.stkWarehouse like ?";
				hql+=" and stkWarehouse like ?";
				params.add("%"+sto.getStkWarehouse()+"%");
			}
		}
		PageUtil pu=new PageUtil(cd, page, count, counthql, hql, params.toArray());
		return pu;
	}
}
