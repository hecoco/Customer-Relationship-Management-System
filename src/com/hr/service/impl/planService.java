package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.SalChance;
import com.hr.pojo.SalPlan;
import com.hr.service.infplanService;

public class planService implements infplanService { 
	  private InfCommonsDao cd;
    public void setCd(InfCommonsDao cd) {
	this.cd = cd;
    }
	  /* (non-Javadoc) 查询
	 * @see com.hr.service.infplanService#querylist()
	 */
	public List<SalPlan> querylist() {
		
		List<SalPlan> list= cd.findAll(SalPlan.class); 	 
		  
		return list;
		
	}
	//分页查询
	
	public List<SalPlan> querylist(int start, int length) {
		if (start==0&&length==0) {
			start=0;
            length=1;
			
		}
		return cd.findAllHQLfy("from SalPlan", start, length);
	}
	//id查询
	
	public SalPlan idquerylist(Integer id) {
		// TODO Auto-generated method stub
		return  (SalPlan) cd.findById(SalPlan.class, id);
		
	}
	//添加
	
	public int add(SalPlan sp) {
		// TODO Auto-generated method stub
		Serializable s=cd.add(sp);
		if (!s.equals(null)) {
			return 1;
		}
		return 0;
		
		
	}
	//修改
	
	public int update(SalPlan sp) {
		// TODO Auto-generated method stub
		//int  s=0;
		try {
			 cd.update(sp);
			 return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	//高级查询加分页
	
	public List<SalPlan> querygj(SalChance sc,int page,int count) {
		// TODO Auto-generated method stub
		//String hql="from SalPlan where 1=1";
		//System.out.println("querygj");
		String hql="select sp from SalPlan sp left join sp.slch sa where 1=1";
		List list=new ArrayList();
		if (sc.getChcCustName()!=null && !"".equals(sc.getChcCustName())) {
			hql +=" and sa.chcCustName like ?  ";
			//ss+=name;
			// ss [0] =name;
			list.add("%"+sc.getChcCustName()+"%");
		}if  (sc.getChcTitle()!=null && !"".equals(sc.getChcTitle())) {
			hql +=" and sa.chcTitle like ? ";
			list.add("%"+sc.getChcTitle()+"%");
			
		}if (sc.getChcLinkman()!=null && !"".equals(sc.getChcLinkman())) {
			hql +=" and sa.chcLinkman like ? ";
			list.add("%"+sc.getChcLinkman()+"%");
		}
		//System.out.println(page+"   "+count);
		int first = (page - 1) * count;
		//System.out.println(first);
		return cd.findAllHQLgj(hql,first,count,list.toArray());
	}
	//查询数据库里面表的总页数
	
	public int findCount(SalChance sc) {
		// TODO Auto-generated method stub
		String hql = "select count(sp.plaId) from SalPlan sp left join sp.slch sa where 1=1";
		List list=new ArrayList();
		//System.out.println(sc.getChcCustName());
		if (sc.getChcCustName()!=null && !"".equals(sc.getChcCustName())) {
			hql +=" and sa.chcCustName like ?  ";
			//ss+=name;
			// ss [0] =name;
			list.add("%"+sc.getChcCustName()+"%");
		}
		if  (sc.getChcTitle()!=null && !"".equals(sc.getChcTitle())) {
			hql +=" and sa.chcTitle like ? ";
			list.add("%"+sc.getChcTitle()+"%");
			
		}if (sc.getChcLinkman()!=null && !"".equals(sc.getChcLinkman())) {
			hql +=" and sa.chcLinkman like ? ";
			list.add("%"+sc.getChcLinkman()+"%");
		}
		return (int) cd.findCount(hql, list.toArray());
	}

	
}
