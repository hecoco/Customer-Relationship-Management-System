package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.SalChance;
import com.hr.service.infChanceService;

public class ChanceService implements infChanceService {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	//分页查询
	/* (non-Javadoc) 
	 * @see com.hr.service.infChanceService#querylist(int, int)
	 */
	public List<SalChance> querylist(int start,int length) {
		if (start==0&&length==0) {
			start=0;
            length=1;
			
		}
		return cd.findAllHQLfy("from SalChance", start, length);
		
	}
	//添加
	
	public int add(SalChance cs) {
		// TODO Auto-generated method stub
		Serializable s=cd.add(cs);
		if (!s.equals(null)) {
			return 1;
		}
		return 0;
		
	}
    //id查询
	
	public  SalChance idquerylist(Integer id) {
		// TODO Auto-generated method stub
		return 	(SalChance) cd.findById(SalChance.class, id);
		
	
	}
	//修改
	
	public int update(SalChance sc) {
		// TODO Auto-generated method stub
		int count = 0;
	  	try {
			cd.update(sc);
			count=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	//删除
	
	public int delete(SalChance sc) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			cd.del(sc);
			count = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	//高级查询加分页
	
	public List<SalChance> querygj(String name, String title, String Linkman,int page,int count) {
		// TODO Auto-generated method stub
		//System.out.println(name+title+Linkman);
		//String [] ss = null;
		List list=new ArrayList();
		String hql="from SalChance where 1=1";
		if (name!=null && !"".equals(name)) {
			hql +=" and chc_cust_name like ?  ";
			//ss+=name;
			// ss [0] =name;
			list.add("%"+name+"%");
		}if  (title!=null && !"".equals(title)) {
			hql +=" and chc_title like ? ";
			list.add("%"+title+"%");
			
		}if (Linkman!=null && !"".equals(Linkman)) {
			hql +=" and chc_linkman like ? ";
			list.add("%"+Linkman+"%");
		}
		//求出开始数据的下标
		//System.out.println(page);
		int first = (page - 1) * count;
		//System.out.println(first);
		
		return  cd.findAllHQLgj(hql, first, count, list.toArray());
	}
	//查询数据库里面表的总页数
	
	public int findCount(SalChance cs,String name, String title, String Linkman) {
		// TODO Auto-generated method stub
		String hql = "select count(r.chcId) from SalChance r where 1=1";
		List list=new ArrayList();
		if (name!=null && !"".equals(name)) {
			hql +=" and chc_cust_name like ?  ";
			//ss+=name;
			// ss [0] =name;
			list.add("%"+name+"%");
		}if  (title!=null && !"".equals(title)) {
			hql +=" and chc_title like ? ";
			list.add("%"+title+"%");
			
		}if (Linkman!=null && !"".equals(Linkman)) {
			hql +=" and chc_linkman like ? ";
			list.add("%"+Linkman+"%");
		}
		return (int) cd.findCount(hql, list.toArray());
	}

}
