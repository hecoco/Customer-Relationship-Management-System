package com.hr.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hr.dao.InfTongJiDao;


public class TongJiDaoImpl implements InfTongJiDao {
	private HibernateTemplate temp;
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	/* (non-Javadoc)
	 * @see dao.impl.InfTongJiDao#GongXian()
	 */
	public List<Object[]> GongXian(final String name,final String year){
		List<Object[]> obj= temp.execute(new HibernateCallback<List<Object[]>>() {

			public List<Object[]> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql="select c.cust_no,c.cust_name,count(o.odr_id),sum(ol.odd_price) from cst_customer c left join orders o on c.cust_no=o.odr_customer"+ 
						" left JOIN orders_line ol on ol.odd_order_id=o.odr_id where 1=1";
				List<String> list=new ArrayList<String>(0);
				if(name!=null){
					sql+=" and c.cust_name like ?";
					list.add("%"+name+"%");
				}
				if(year!=null){
					sql+=" and YEAR(o.odr_date)=YEAR(?)";
					list.add(year+"-01-01");
				}
				sql+=" and c.cust_status=1 group by c.cust_no,c.cust_name";	
				SQLQuery sq=session.createSQLQuery(sql);
				if(list.size()>0){
					for (int i = 0; i < list.size(); i++) {
						sq.setParameter(i, list.get(i));						
					}
				}
				
				return sq.list();
			}
		});
		return obj;
	}
	public List<Object[]> FenXi(final int fen) {
		List<Object[]> obj= temp.execute(new HibernateCallback<List<Object[]>>() {

			public List<Object[]> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql="select b.dict_item,count(*) from cst_customer c left join bas_dict b on";
				if(fen==1){
					sql+=" c.cust_level=b.dict_id where b.dict_type='企业客户等级' and c.cust_status=1 GROUP BY b.dict_item order by b.dict_id";
				}else if(fen==2){
					sql+=" c.cust_credit=b.dict_id where b.dict_type='信用度' and c.cust_status=1 GROUP BY b.dict_item order by b.dict_id";										
				}else{
					sql+=" c.cust_satisfy=b.dict_id where b.dict_type='满意度' and c.cust_status=1 GROUP BY b.dict_item order by b.dict_id";	
				}
				SQLQuery sq=session.createSQLQuery(sql);
				return sq.list();
			}
		});
		return obj;
	}
	public List<Object[]> FenWu(final String year) {
		List<Object[]> obj= temp.execute(new HibernateCallback<List<Object[]>>() {

			public List<Object[]> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql="select c.svr_type,count(*) from cst_service c LEFT JOIN cst_customer s on c.svr_cust_no=s.cust_no ";
				if(year!=null){
					sql+="	where YEAR(c.svr_deal_date)=YEAR(?)";						
				}
				sql+="	GROUP BY c.svr_type";
				SQLQuery sq=session.createSQLQuery(sql);
				if(year!=null){
					sq.setParameter(0, year+"-01-01");
				}
				return sq.list();
			}
		});
		return obj;
	}
	public List<Object[]> LiuShi(final String lname,final String lname1,final int page,final int count) {
		List<Object[]> obj= temp.execute(new HibernateCallback<List<Object[]>>() {

			public List<Object[]> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String sql="select year(c.lst_lost_date),s.cust_name," +
						"c.lst_cust_manager_name,c.lst_reason from cst_lost c " +
						"LEFT JOIN cst_customer s on c.lst_cust_no=s.cust_no where 1=1";
				List<String> list=new ArrayList<String>(0);
				if(lname!=null){
					sql+=" and s.cust_name like ? ";
					list.add("%"+lname+"%");
				}
				if(lname1!=null){
					sql+=" and c.lst_cust_manager_name like ?";
					list.add("%"+lname1+"%");
				}
				sql+=" and c.lst_status=3";
				SQLQuery sq=session.createSQLQuery(sql);
				for (int i = 0; i <list.size(); i++) {
					sq.setParameter(i, list.get(i));
				}
				sq.setFirstResult((page-1)*count);
				sq.setMaxResults(count);
				return sq.list();
			}
		});
		return obj;
	}
}
