package com.hr.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.hr.pojo.CstService;
import com.hr.pojo.SysUser;
import com.hr.service.InfServiceService;
import com.hr.service.InfUserService;
import com.hr.util.ResponseUtil;

public class ServiceAction extends BaseAction {

	private CstService cs;
	private InfServiceService ss;

	private String svrCreateDate1;
	// 页数
	private int page;
	// 条数
	private int count;
	// 最大页数
	private int maxpage;

	public String add() {
		ss.add(cs);
		
		return "add";
	}

	private InfUserService us;

	public void setUs(InfUserService us) {
		this.us = us;
	}

	public String findall() {
		// 条数默认为5
		if (count == 0) {
			count = 5;
		}
		/* System.out.println(cs.getSvrCustName()); */
		List<CstService> sumcount = ss.findall(cs, 0, 10000, svrCreateDate1);
		if (sumcount.size() > 0) {
			if (sumcount.size() % count == 0) {
				// 1 10
				maxpage = sumcount.size() / count;
			} else {
				maxpage = (sumcount.size() / count) + 1;
			}
		}
		if (page <= 0) {
			page = 1;
		} else if (maxpage <= page) {
			page = maxpage;

		}

		List<CstService> list = ss.findall(cs, page, count, svrCreateDate1);
		request.put("list", list);
		request.put("sumcount", sumcount.size());

		// 下拉框的值
		session.put("user", us.findAll());
		return "list";
	}

	public String findall1() {
		// 条数默认为5
		if (count == 0) {
			count = 5;
		}
		/* System.out.println(cs.getSvrCustName()); */
		List<CstService> sumcount = ss.findall(cs, 0, 10000, svrCreateDate1);
		if (sumcount.size() > 0) {
			if (sumcount.size() % count == 0) {
				// 1 10
				maxpage = sumcount.size() / count;
			} else {
				maxpage = (sumcount.size() / count) + 1;
			}
		}
		if (page <= 0) {
			page = 1;
		} else if (maxpage <= page) {
			page = maxpage;

		}

		List<CstService> list1 = ss.findall(cs, page, count, svrCreateDate1);
		request.put("list1", list1);
		return "list1";
	}

	public String findall2() {
		// 条数默认为5
		if (count == 0) {
			count = 5;
		}
		/* System.out.println(cs.getSvrCustName()); */
		List<CstService> sumcount = ss.findall(cs, 0, 10000, svrCreateDate1);
		if (sumcount.size() > 0) {
			if (sumcount.size() % count == 0) {
				// 1 10
				maxpage = sumcount.size() / count;
			} else {
				maxpage = (sumcount.size() / count) + 1;
			}
		}
		if (page <= 0) {
			page = 1;
		} else if (maxpage <= page) {
			page = maxpage;

		}

		List<CstService> list1 = ss.findall(cs, page, count, svrCreateDate1);
		request.put("list1", list1);
		return "list3";
	}

	public String findall3() {
		// 条数默认为5
		if (count == 0) {
			count = 5;
		}
		/* System.out.println(cs.getSvrCustName()); */
		List<CstService> sumcount = ss.findall(cs, 0, 10000, svrCreateDate1);
		if (sumcount.size() > 0) {
			if (sumcount.size() % count == 0) {
				// 1 10
				maxpage = sumcount.size() / count;
			} else {
				maxpage = (sumcount.size() / count) + 1;
			}
		}
		if (page <= 0) {
			page = 1;
		} else if (maxpage <= page) {
			page = maxpage;

		}

		List<CstService> list1 = ss.findall(cs, page, count, svrCreateDate1);
		request.put("list1", list1);
		return "list5";
	}

	public String delete() throws IOException {

		ss.del(cs);
		ResponseUtil.jump(response, "删除成功", "service!findall");
		return null;
	}

	public String findByida() {
		System.out.println(cs.getSvrId());
		CstService list21 = ss.findByid(cs.getSvrId());
		request.put("list21", list21);
		return "list2";
	}

	public String findByidb() {
		System.out.println(cs.getSvrId());
		CstService service = ss.findByid(cs.getSvrId());
		request.put("service", service);
		return "list4";
	}

	public String findByidc() {
		System.out.println(cs.getSvrId());
		CstService service = ss.findByid(cs.getSvrId());
		request.put("service", service);
		return "list6";
	}

	// 服务处理修改
	public String update() throws IOException {

		System.out.println(cs.getSvrId());
		CstService service = ss.findByid(cs.getSvrId());
		service.setSvrDeal(cs.getSvrDeal());
		service.setSvrDealId(cs.getSvrDealId());
		service.setSvrDealBy(cs.getSvrDealBy());
		service.setSvrStatus("已处理");
		ss.update(service);
		ResponseUtil.jump(response, "处理成功", "service!findall2");
		return null;

	}

	public String update1() throws IOException {

		ss.update(cs);
		ResponseUtil.jump(response, "成功", "service!findall1");
		return null;

	}

	// 服务分配修改
	public String update2() {
		CstService list2 = ss.findByid(cs.getSvrId());
		list2.setSvrStatus("已分配");
		list2.setSvrDueId(cs.getSvrDueId());
		list2.setSvrDueTo(cs.getSvrDueTo());
		list2.setSvrDueDate(new Timestamp(new Date().getTime()));
		System.out.println(list2.getSvrDueId() + list2.getSvrDueTo());
		ss.update(list2);
		ResponseUtil.jump(response, "分配成功", "service!findall");
		return null;

	}

	// 服务反馈修改
	public String update3() {
		CstService list2 = ss.findByid(cs.getSvrId());
		if (cs.getSvrSatisfy() >= 3) {
			list2.setSvrResult(cs.getSvrResult());
			list2.setSvrStatus("已反馈");
			list2.setSvrSatisfy(cs.getSvrSatisfy());
			ss.update(list2);
			ResponseUtil.jump(response, "处理成功", "service!findall3");
		} else {
			list2.setSvrStatus("已分配");
			ss.update(list2);
			ResponseUtil.jump(response, "处理失败", "service!findall1");
		}
		return null;

	}

	public InfServiceService getSs() {
		return ss;
	}

	public void setSs(InfServiceService ss) {
		this.ss = ss;
	}

	public CstService getCs() {
		return cs;
	}

	public void setCs(CstService cs) {
		this.cs = cs;
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

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public String getSvrCreateDate1() {
		return svrCreateDate1;
	}

	public void setSvrCreateDate1(String svrCreateDate1) {
		this.svrCreateDate1 = svrCreateDate1;
	}

}
