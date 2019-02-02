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
	//��ҳ��ѯ
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
	//���
	
	public int add(SalChance cs) {
		// TODO Auto-generated method stub
		Serializable s=cd.add(cs);
		if (!s.equals(null)) {
			return 1;
		}
		return 0;
		
	}
    //id��ѯ
	
	public  SalChance idquerylist(Integer id) {
		// TODO Auto-generated method stub
		return 	(SalChance) cd.findById(SalChance.class, id);
		
	
	}
	//�޸�
	
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
	//ɾ��
	
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
	//�߼���ѯ�ӷ�ҳ
	
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
		//�����ʼ���ݵ��±�
		//System.out.println(page);
		int first = (page - 1) * count;
		//System.out.println(first);
		
		return  cd.findAllHQLgj(hql, first, count, list.toArray());
	}
	//��ѯ���ݿ���������ҳ��
	
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
