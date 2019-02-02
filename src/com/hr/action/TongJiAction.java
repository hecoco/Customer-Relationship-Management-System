package com.hr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;

import com.hr.service.InfTongJiService;

public class TongJiAction extends BaseAction{
	private InfTongJiService infTongJiService;
	public void setInfTongJiService(InfTongJiService infTongJiService) {
		this.infTongJiService = infTongJiService;
	}
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private int fen;
	
	public int getFen() {
		return fen;
	}

	public void setFen(int fen) {
		this.fen = fen;
	}
	private String year;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	private String gyear;
	
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLname1() {
		return lname1;
	}

	public void setLname1(String lname1) {
		this.lname1 = lname1;
	}

	public String getGyear() {
		return gyear;
	}

	public void setGyear(String gyear) {
		this.gyear = gyear;
	}
	private String lname;
	private String lname1;
	private int page;
	private int count;
	private int maxpage;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public String GongXian(){
		if(gyear!=null){
			if("全部".equals(gyear)){
				gyear=null;
			}
		};
		if(name!=null){
			if(name.length()==0){
				name=null;
			}
		}
		System.out.println(name);
		request.put("TongJiList",infTongJiService.GongXian(name,gyear));
		return SUCCESS;
	}
	public String FenXi(){	
		if(fen==0){
			fen=1;
		}
		System.out.println(fen);
		request.put("TongJiList",infTongJiService.FenXi(fen));
		return "FenXi";
	}
	public String FenWu(){	
		if(year!=null){
			if("全部".equals(year)){
				year=null;
			}
		};
		request.put("TongJiList",infTongJiService.FenWu(year));
		return "FenWu";
	}
	public String LiuShi(){	
		if(lname!=null){
			if(lname.length()==0){
				lname=null;
			}
		}
		if(lname1!=null){
			if(lname1.length()==0){
				lname1=null;
			}
		}
		
		if(count==0){
			count=10;
		}
		List l=infTongJiService.LiuShi(lname,lname1,0,1000);
		if(l.size()>0){
			if(l.size()%count==0){
				maxpage=l.size()/count;
			}else{
				maxpage=(l.size()/count)+1;
			}
		}
		if(page<=0){
			page=1;
		}else if(page>=maxpage){
			page=maxpage;
		}
		System.out.println(count);
		List<Object[]> list=infTongJiService.LiuShi(lname,lname1,page,count);	
		System.out.println(page);
		request.put("page", page);
		request.put("maxpage", maxpage);
		request.put("count", count);
		request.put("maxcount", infTongJiService.LiuShi(lname,lname1,0,1000).size());
		request.put("TongJiList",list);
		return "LiuShi";
	}
}
