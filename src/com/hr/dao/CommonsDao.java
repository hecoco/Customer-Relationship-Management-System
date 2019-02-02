package com.hr.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CommonsDao implements InfCommonsDao {
	private HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	
	
	public Serializable add(Object obj) {
		//Session session = MySessionFactory.getSession();
		return temp.save(obj);
	}

	
	public void del(Object obj) {
		temp.delete(obj);
	}

	
	public List findAll(Class clazz) {
		//Criteria c = session.createCriteria();
		//c.list
		//Detached: 独立标准
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		return temp.findByCriteria(dc);
	}

	
	public Object findById(Class clazz, Serializable id) {
		//temp的get方法只能通过这个类的主键进行查询,不能通过其他任何列进行查询
		//select * from product where cid=? 此操作使用get不可行
		//select * from product where pname lile ? 此操作使用get不可行
		//select * from product where pid = ? 此操作可行(只能通过主键查询)
		return temp.get(clazz, id);
	}
	
	//编写方法使用自定的hql语句进行查询
	//参数一: hql语句
	//参数二: Object类型的可变参数
	public List findAllHQL(String hql,Object...params){
		//hql: select * from product where cid=?
		//Object: value

		//hql: select * from product where cid = ? and cname = ?
		//Object...values
		return temp.find(hql, params);
	}

	
	public void update(Object obj) {
		temp.update(obj);
	}
    //查询总数的方法
	
	public int findCount(final String hql, final Object... params) {
		//HibernateCallback: 回调函数,将HibernateCallback的返回值作为temp.executeFind返回值
		List list=temp.executeFind(new HibernateCallback<List>() {
			//HibernateCallback是一个抽象类，需要在new的时候重写抽象方法doInHibernate
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				//匿名对象（就是new出来没有使用变量接收的对象，该对象只能使用一次）
				//匿名对象中使用的属性必须是final属性
				Query q=session.createQuery(hql);
				for (int i = 0; i < params.length; i++) {
					q.setParameter(i, params[i]);
				}
				// TODO Auto-generated method stub
				return q.list();//q.list()返回的结果会作为temp.executeFind()调用的结果
			}
		});
		long count=(Long)list.get(0);
		return (int) count;
	}

	//分页的方法
	
	public List findFy(final int index, final int count, final String hql, final Object... params) {
		List list=temp.executeFind(new HibernateCallback<List>() {

			
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query q=session.createQuery(hql);
				for (int i = 0; i < params.length; i++) {
					q.setParameter(i, params[i]);
				}
				q.setFirstResult(index);
				q.setMaxResults(count);
				return q.list();
			}
		});
		return list;
	}
	//查询超过6个月没下单的客户
	
	public List findlost(final String sql,final Class clazz) {
		// TODO Auto-generated method stub
		List list= temp.executeFind(new HibernateCallback<List>() {

			
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				SQLQuery sq= session.createSQLQuery(sql);
				sq.addEntity(clazz);
				return sq.list();
			}
		});
		return list;
	}

	
	
	
	
	
	
	
	
	

	
	
	

	

	
	//分页查询
	public List findAllHQLfy(final String hql,final int start ,final int length){
		/*
		 * String hql = "select p from Product p where p.pid=? and p.pname like ?";
		 * Query q = session.createQuery(hql);
		 * for(int i = 0; i < params.length ;i++){
		 * 	q.setParamater(i,params[i]);
		 * }
		 * List list = q.list();
		 * */
		List list = temp.executeFind(new HibernateCallback<List>() {
			
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				//System.out.println(start+length);
				Query q = session.createQuery(hql);
				//System.out.println(start);
					q.setFirstResult(start);
					//System.out.println(length);
					q.setMaxResults(length);
				
					//System.out.println(q.list());
				return q.list();
			}
		});
		return list;
	}
	
	
	//高级查询加分页   方法一
	public List findAllHQLgj(final String hql,final int first,final int count,final Object...params){
		
		
		List list = temp.executeFind(new HibernateCallback<List>() {
			
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query q = session.createQuery(hql);
//				System.out.println(hql);
//				System.out.println(params.length);
				for (int i = 0; i < params.length; i++) {
//					System.out.println(i+" "+params[i]);
					q.setParameter(i,params[i]);
  				}
				//System.out.println(first+"    "+count);
				q.setFirstResult(first);
				q.setMaxResults(count);
				return q.list();
			}
		});
		return list;
		
	}
	
	//高级查询加分页   方法二
	
	public List findAllHQLgj(final String hql, final List params, final int first, final int count) {
		// TODO Auto-generated method stub
		List list = temp.executeFind(new HibernateCallback<List>() {
			
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery(hql);
				if(params!=null){
					for (int i = 0; i < params.size(); i++) {
						q.setParameter(i, params.get(i));
					}
				}
				
				q.setFirstResult(first);
				q.setMaxResults(count);
				
				return q.list();
			}
		});
		return list;
	}
	
	
	
	
   
}
