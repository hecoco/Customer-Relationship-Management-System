package com.hr.dao;

import java.util.List;

public interface InfTongJiDao {

	public abstract List<Object[]> GongXian(String name,String year);
	public abstract List<Object[]> FenXi(int fen);
	public abstract List<Object[]> FenWu(String year);
	public abstract List<Object[]> LiuShi(String lname,String lname1,int page,int count);
}