package com.hr.action;

import java.util.List;

import com.hr.pojo.Product;
import com.hr.service.InfProductService;
import com.hr.util.PageUtil;

public class ProductAction extends BaseAction {
	private InfProductService pd;
	public void setPd(InfProductService pd) {
		this.pd = pd;
	}
	private Product prod;
	private int page;
	private int count;
	//≤È—Ø
	public String findAll(){
		/*List<Product> list= pd.findAll();*/
		PageUtil pu= pd.findFy(page, count, prod);
		request.put("pu", pu);
		return "sele";
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
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
