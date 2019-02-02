package com.hr.service;

import java.util.List;

public interface InfTongJiService {
	public List<Object[]> GongXian(String name,String year);
	public List<Object[]> FenXi(int name);
	public abstract List<Object[]> FenWu(String year);
	public abstract List<Object[]> LiuShi(String lname,String lname1,int page,int count);
}
