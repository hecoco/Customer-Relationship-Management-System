package com.hr.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hr.dao.InfCommonsDao;
import com.hr.pojo.SysUser;
import com.hr.service.InfUserService;
import com.hr.util.PageUtil;

public class UserService implements InfUserService {
	private InfCommonsDao cd;
	public void setCd(InfCommonsDao cd) {
		this.cd = cd;
	}
	
	
	public SysUser login(String name, String pass) {
		String hql = "from SysUser where usrName=? and usrPassword=?";
		List<SysUser> list = cd.findAllHQL(hql, name,pass);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	
	
	
	//查询所有
	
	public List<SysUser> querylistUser() {
		// TODO Auto-generated method stub
		return cd.findAll(SysUser.class);
	}
	//id查询
	
	public SysUser idquerylist(Integer id) {
		// TODO Auto-generated method stub
		return 	(SysUser) cd.findById(SysUser.class, id);
		
	}
	
	
	//查询
	public List<SysUser> findAll() {
		
		return cd.findAll(SysUser.class);
	}
	//添加
	public Serializable add(SysUser user) {
		// TODO Auto-generated method stub
		return cd.add(user);
	}
	//修改
	public void update(SysUser user) {

		cd.update(user);
		
	}
	//删除
	public void delete(SysUser user) {
		// TODO Auto-generated method stub
		cd.del(user);
	}

	public SysUser findById(SysUser user) {
		// TODO Auto-generated method stub
		return (SysUser) cd.findById(SysUser.class, user.getUsrId());
	}

	public int findcount(String hql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageUtil findFy(int page, int count, SysUser user) {
		System.out.println("asdasdasdas");
		String counthql="select count(s.usrId) from SysUser s where 1=1";
		String hql="from SysUser where 1=1";
		List params=new ArrayList();
		if(user!=null){
			if(user.getUsrName()!=null && !"".equals(user.getUsrName())){
				counthql+=" and s.usrName like ?";
				hql+=" and usrName like ?";
				params.add("%"+user.getUsrName()+"%");
			}
			if(user.getUsrFlag()!=null && user.getUsrFlag()!=0){
				counthql+=" and s.usrFlag = ?";
				hql+=" and usrFlag = ?";
				params.add(user.getUsrFlag());
			}
		}
		
		PageUtil pu=new PageUtil(cd, page, count, counthql, hql, params.toArray());
		return pu;
	}
}
