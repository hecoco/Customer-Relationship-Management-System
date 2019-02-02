package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.dao.InfSysRightDao;
import com.hr.pojo.SysRight;
import com.hr.service.InfRightService;
import com.hr.util.PageUtil;

public class RightService implements InfRightService {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	private InfSysRightDao rd;
	public void setRd(InfSysRightDao rd) {
		this.rd = rd;
	}
	//查询
	public List<SysRight> findAll() {
		return cd.findAll(SysRight.class);
	}
	//查询id
	public List<SysRight> findByIds(List<String> ids) {
		String hql=" from SysRight  where rightCode in (:ids) ";
		
		return rd.findByIds(hql, ids);
	}
	//增加
	public Serializable add(SysRight right) {
		// TODO Auto-generated method stub
		return cd.add(right);
	}
	//修改
	public void update(SysRight right) {
		// TODO Auto-generated method stub
		cd.update(right);
	}
	//删除
	public void delete(SysRight right) {
		// TODO Auto-generated method stub
		cd.del(right);
	}
	public SysRight findid(SysRight right) {
		// TODO Auto-generated method stub
		
		return (SysRight) cd.findById(SysRight.class,right.getRightCode());
	}
	public SysRight findi(String id) {
		
		return (SysRight) cd.findById(SysRight.class, id);
	}
	public int findcount(String hql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}
	public PageUtil findFy(int page, int count, SysRight right) {
		String counthql="select count(s.rightCode) from SysRight s where 1=1";
		String hql="from SysRight where 1=1";
		List params=new ArrayList();
		if(right !=null){
			if(right.getRightText()!=null && !"".equals(right.getRightText())){
				counthql+=" and s.rightText like ?";
				hql+=" and rightText like ?";
				params.add("%"+right.getRightText()+"%");
			}
			if(right.getRightTip()!=null && !"".equals(right.getRightTip())){
				counthql+=" and s.rightTip like ?";
				hql+=" and rightTip like ?";
				params.add("%"+right.getRightTip()+"%");
			}
			if(right.getRightParent()!=null && !"".equals(right.getRightParent())){
				counthql+=" and s.rightParent = ?";
				hql+=" and rightParent = ?";
				params.add(right.getRightParent());
			}
		}
		PageUtil pu=new PageUtil(cd, page, count, counthql, hql, params.toArray());
		return pu;
	}
	
}
