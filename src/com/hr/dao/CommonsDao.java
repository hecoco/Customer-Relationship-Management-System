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
		//Detached: ������׼
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		return temp.findByCriteria(dc);
	}

	
	public Object findById(Class clazz, Serializable id) {
		//temp��get����ֻ��ͨ���������������в�ѯ,����ͨ�������κ��н��в�ѯ
		//select * from product where cid=? �˲���ʹ��get������
		//select * from product where pname lile ? �˲���ʹ��get������
		//select * from product where pid = ? �˲�������(ֻ��ͨ��������ѯ)
		return temp.get(clazz, id);
	}
	
	//��д����ʹ���Զ���hql�����в�ѯ
	//����һ: hql���
	//������: Object���͵Ŀɱ����
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
    //��ѯ�����ķ���
	
	public int findCount(final String hql, final Object... params) {
		//HibernateCallback: �ص�����,��HibernateCallback�ķ���ֵ��Ϊtemp.executeFind����ֵ
		List list=temp.executeFind(new HibernateCallback<List>() {
			//HibernateCallback��һ�������࣬��Ҫ��new��ʱ����д���󷽷�doInHibernate
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				//�������󣨾���new����û��ʹ�ñ������յĶ��󣬸ö���ֻ��ʹ��һ�Σ�
				//����������ʹ�õ����Ա�����final����
				Query q=session.createQuery(hql);
				for (int i = 0; i < params.length; i++) {
					q.setParameter(i, params[i]);
				}
				// TODO Auto-generated method stub
				return q.list();//q.list()���صĽ������Ϊtemp.executeFind()���õĽ��
			}
		});
		long count=(Long)list.get(0);
		return (int) count;
	}

	//��ҳ�ķ���
	
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
	//��ѯ����6����û�µ��Ŀͻ�
	
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

	
	
	
	
	
	
	
	
	

	
	
	

	

	
	//��ҳ��ѯ
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
	
	
	//�߼���ѯ�ӷ�ҳ   ����һ
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
	
	//�߼���ѯ�ӷ�ҳ   ������
	
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
