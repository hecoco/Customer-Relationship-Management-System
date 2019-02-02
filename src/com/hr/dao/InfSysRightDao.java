package com.hr.dao;

import java.util.List;

import com.hr.pojo.SysRight;

public interface InfSysRightDao {
	public List<SysRight> findByIds(String hql,List<String> ids);
}
