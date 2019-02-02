package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;
import org.hibernate.hql.ast.tree.FromClause;

import com.hr.dao.CommonsDao;
import com.hr.dao.InfCommonsDao;
import com.hr.pojo.BasDict;
import com.hr.pojo.CstCustomer;
import com.hr.pojo.SysUser;
import com.hr.service.InfCustomerService;
import com.hr.util.PageUtil;
import com.sun.org.apache.xpath.internal.operations.And;

public class CustomerServiceImpl implements InfCustomerService {
	
	private InfCommonsDao cd;
	public void setCd(CommonsDao cd) {
		this.cd = cd;
	}
    //��ѯ���пͻ���Ϣ
	
	public List<CstCustomer> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll(CstCustomer.class);
	}
    //����id��ѯ���пͻ�
	
	public Object finfById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		 return cd.findById(clazz,id);
	}
	//��ѯ�ֵ�����е���Ϣ
	
	public List<BasDict> findAllbas() {
		// TODO Auto-generated method stub
		return cd.findAll(BasDict.class);
	}
	//��ѯ�����û�����Ϣ
	
	public List<SysUser> findAlluser() {
		// TODO Auto-generated method stub
		return cd.findAll(SysUser.class);
	}
	//�޸Ŀͻ���Ϣ
	
	public void update(CstCustomer cst) {
		// TODO Auto-generated method stub
		cd.update(cst);
	}
	
	//��ѯ�������������ݼ���
	public PageUtil findFy(int page, int count, CstCustomer cst) {
		// �鳤�ȵ�hql���
		String countHql="select count(c.custNo) from CstCustomer c left join  c.sysusers s left join  c.basd b where 1=1 ";
		//��ȫ�����ݵ�hql
		String hql="from CstCustomer c left join fetch c.sysusers s  left join fetch c.basd b where 1=1";
		List params=new ArrayList();
		//���cst����Ϊ��˵������������
		if(cst!=null)
		{
			if(cst.getCustNo()!=null && !"".equals(cst.getCustNo()))
			{
			countHql+=" and c.custNo like ?";
			hql+=" and c.custNo like ?";
			params.add("%"+cst.getCustNo()+"%");
			}
			if(cst.getCustName()!=null && !"".equals(cst.getCustName()))
			{
			countHql+=" and c.custName like ?";
			hql+=" and c.custName like ?";
			params.add("%"+cst.getCustName()+"%");
			}
			if(!cst.getCustRegion().equals("0"))
			{
				countHql+=" and c.custRegion like ?";
				hql+=" and c.custRegion like ?";
				params.add("%"+cst.getCustRegion()+"%");
			}
			if(cst.getSysusers().getUsrId()!=0)
			{
				countHql+=" and s.usrId  = ?";
				hql+=" and s.usrId = ?";
				params.add(cst.getSysusers().getUsrId());
			}
			if(cst.getBasd().getDictId()!=0)
			{
				countHql+=" and b.dictId = ?";
				hql+=" and b.dictId = ?";
				params.add(cst.getBasd().getDictId());
			}
		}
		PageUtil pu=new PageUtil(cd, page, count, countHql, hql, params.toArray());
		System.out.println(pu);
		return pu;
	}
	
	//ɾ���ͻ���Ϣ
	public void del(CstCustomer cstCustomer) {
		// TODO Auto-generated method stub
		cd.del(cstCustomer);
		
	}

}
