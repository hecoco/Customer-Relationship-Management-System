package com.hr.action;

import java.util.List;

import com.hr.pojo.BasDict;
import com.hr.service.InfBasDictService;
import com.hr.util.PageUtil;

public class BasDictAction extends BaseAction {
	private InfBasDictService bd;
	public void setBd(InfBasDictService bd) {
		this.bd = bd;
	}
	//��ѯ
	public String select(){
		//List<BasDict> list= bd.findAll();
		PageUtil pu= bd.findFy(page, count, dict);
		request.put("pu",pu);
		return "li";
	}
	private BasDict dict;
	private int page;
	private int count;
	//���
	public String add(){
		if(dict.getDictIsEditable() == null){
			dict.setDictIsEditable("0");
		}
		int count= (Integer) bd.addBasDict(dict);
		return "ad";
	
	}
	//��ѯ��ֵ
	public String selectid(){
		System.out.println("idֵ"+dict.getDictId());
		BasDict b= bd.findId(dict.getDictId());
		request.put("b", b);
		return "sid";
	}
	//�޸�
	public String update(){
		if(dict.getDictIsEditable() == null){
			dict.setDictIsEditable("0");
		}
		bd.update(dict);
		return "ad";
	}
	//ɾ��
	public String delete(){
		bd.delete(dict);
		return "ad";
	}
	public BasDict getDict() {
		return dict;
	}
	public void setDict(BasDict dict) {
		this.dict = dict;
	}
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
	
}
