package com.hr.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;


import com.hr.pojo.SysRight;

public class SysRightDao implements InfSysRightDao {
	private HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	public List<SysRight> findByIds(final String hql, final List<String> ids) {
		if(ids!=null && ids.size()>0){
			List<SysRight> list= temp.executeFind(new HibernateCallback<List<SysRight>>() {

				public List<SysRight> doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q= session.createQuery(hql);
					
					q.setParameterList("ids", ids);
					return q.list();
				}
			});
			return list;
		}else{
			return null;
		}		
	}

}
