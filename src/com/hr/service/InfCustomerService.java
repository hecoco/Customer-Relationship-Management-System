package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.BasDict;
import com.hr.pojo.CstCustomer;
import com.hr.pojo.SysUser;
import com.hr.util.PageUtil;

public interface InfCustomerService {
//查询所有客户信息
public List<CstCustomer> findAll();
//根据id查询所有信息
public Object finfById(Class clazz,Serializable id);
//查询字典表所有的信息
public List<BasDict> findAllbas();
//查询所有用户的信息
public List<SysUser> findAlluser();
//修改客户信息
public void update(CstCustomer cst);

//查询符合条件的数据集合
public PageUtil findFy(int page,int count,CstCustomer cst);
//删除客户信息
public void del(CstCustomer cstCustomer);
}
