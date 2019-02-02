  package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.dao.InfServiceDao;
import com.hr.pojo.CstService;
import com.hr.service.InfServiceService;

public class ServiceService implements InfServiceService {

	private InfCommonsDao cd;

	public InfCommonsDao getCd() {
		return cd;
	}

	private InfServiceDao sd;

	public void setSd(InfServiceDao sd) {
		this.sd = sd;
	}

	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}

	public Serializable add(CstService cs) {

		return cd.add(cs);
	}

	public void del(CstService cs) {
		cd.del(cs);
	}

	public CstService findByid(Serializable id) {

		return (CstService) cd.findById(CstService.class, id);
	}

	public void update(CstService cs) {

		cd.update(cs);

	}

	public List<CstService> findall(CstService service, int page, int count,String svrCreateDate1) {
		String hql = "from CstService where 1=1  ";
	

		List list = new ArrayList();

		if (service != null) {
			if(service.getSvrCustName()!=null && !"".equals(service.getSvrCustName())){
				hql+=" and svr_cust_name like ?";
				list.add("%"+service.getSvrCustName()+"%");
			}	
			if(service.getSvrTitle()!=null && !"".equals(service.getSvrTitle())){
				hql+=" and svr_title like ?";
				list.add("%"+service.getSvrTitle()+"%");
			}	
			if(service.getSvrType()!="全部" && !"全部".equals(service.getSvrType())){
				hql+=" and svr_type=?";
				list.add(service.getSvrType());
			}
			if(service.getSvrCreateDate()!=null && !"".equals(service.getSvrCreateDate())){
				hql+=" and svr_create_date  > ? ";
				list.add(service.getSvrCreateDate());
			}
			if(svrCreateDate1!=null && !"".equals(svrCreateDate1)){
				hql+=" and svr_create_date  < ?";
				list.add(svrCreateDate1);
			}
			if(service.getSvrStatus()!=null && !"".equals(service.getSvrStatus())){
				hql+=" and svr_status =? ";
				list.add(service.getSvrStatus());
				
			}
			System.err.println(hql);
		}

		return sd.findFy(hql, list, page, count,svrCreateDate1);
	}

}
