package com.hr.service;

import java.io.Serializable;

import com.hr.pojo.CstActivity;

public interface InfActivity {
//根据客户id查询交易记录
public Object findActivityById(Class clazz,Serializable id);
//添加交易记录
public Serializable addActivity(Object obj);
//修改交易记录
public void updateActivity(CstActivity csty);
//根据id查询所有交易记录
public Object findById(Class clazz,Serializable id);
//删除交易记录
public void delActivity(CstActivity cstty);
}
