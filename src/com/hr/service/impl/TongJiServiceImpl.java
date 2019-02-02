package com.hr.service.impl;

import java.util.List;

import com.hr.dao.InfTongJiDao;

import com.hr.service.InfTongJiService;

public class TongJiServiceImpl implements InfTongJiService{
	private InfTongJiDao infTongJiDao;
	public void setInfTongJiDao(InfTongJiDao infTongJiDao) {
		this.infTongJiDao = infTongJiDao;
	}
	public List<Object[]> GongXian(String name,String year) {
		return infTongJiDao.GongXian(name,year);
	}
	public List<Object[]> FenXi(int fen) {
		return infTongJiDao.FenXi(fen);
	}
	public List<Object[]> FenWu(String year) {
		return infTongJiDao.FenWu(year);
	}
	public List<Object[]> LiuShi(String lname, String lname1,int page,int count) {
		return infTongJiDao.LiuShi(lname, lname1,page,count);
	}
}
