package com.hr.util;

import java.util.List;

import com.hr.dao.InfCommonsDao;

public class PageUtil {

	private int page=1;
	private int count=1;
	private int maxCount;
	private int maxPage;
	private int index;
	private List list;
	
	
	public PageUtil(InfCommonsDao cd,int page,int count,String countHql,String hql,Object...params)
	{
		int maxCount=cd.findCount(countHql, params);
		this.maxCount=maxCount;
		
		if(count==0)
		{
			count=1;
		}
		this.count=count;
		
		int maxPage=maxCount%count==0?maxCount/count:maxCount/count+1;
		this.maxPage=maxPage;
		
		if(page<1)
		{
			page=1;
		}
		else if(page>maxPage)
		{
			page=maxPage;
		}
		this.page=page;
		
		int index=(page-1)*count;
		this.index=index;
		
		List list=cd.findFy(index, count, hql, params);
		this.list=list;
	}
	
	
	
	@Override
	public String toString() {
		return "PageUtil [count=" + count + ", index=" + index + ", list="
				+ list + ", maxCount=" + maxCount + ", maxPage=" + maxPage
				+ ", page=" + page + "]";
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
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
