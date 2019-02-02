package com.hr.action;

import java.util.List;

import com.hr.pojo.Product;
import com.hr.pojo.Storage;
import com.hr.service.InfProductService;
import com.hr.service.InfStorageService;
import com.hr.util.PageUtil;

public class StorageAction	extends BaseAction {
	private InfStorageService st;
	private InfProductService pt;
	public void setPt(InfProductService pt) {
		this.pt = pt;
	}
	public void setSt(InfStorageService st) {
		this.st = st;
	}
	private Storage sto;
	private int page;
	private int count;
	//≤È—Ø
	public String findAll(){
		//List<Storage> list= st.findAll();
		PageUtil pu= st.findFy(page, count, sto);
		List<Product> list= pt.findAll();
		request.put("list", list);
		request.put("pu", pu);
		return "sele";
	}
	public Storage getSto() {
		return sto;
	}
	public void setSto(Storage sto) {
		this.sto = sto;
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
