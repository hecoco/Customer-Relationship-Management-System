package com.hr.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hr.pojo.CstService;

public class ServiceDao implements InfServiceDao{
	private HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	
	public List<CstService> findFy(final String hql, final List params, final int page, final int count,String svrCreateDate1) {
		@SuppressWarnings("unchecked")
		List<CstService> list= temp.executeFind(new HibernateCallback<List<CstService>>() {
			public List<CstService> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q= session.createQuery(hql);
				if(q!=null){
					for (int i = 0; i < params.size(); i++) {
						q.setParameter(i,params.get(i));
						System.out.println(params.get(i));
					}
					
				}
				q.setFirstResult((page-1)*count);
				q.setMaxResults(count);
				return q.list();
			}
		});
		return list;
	}

}
