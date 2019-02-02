package com.hr.pojo;

/**
 * CstLinkman entity. @author MyEclipse Persistence Tools
 */

public class CstLinkman implements java.io.Serializable {

	// Fields

	private Integer lkmId;
	//private String lkmCustNo;
	private String lkmCustName;
	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private String lkmMemo;
	
	//多个联系人对应一个客户
	private CstCustomer customers;

	// Constructors

	/** default constructor */
	public CstLinkman() {
	}

//	/** full constructor */
//	public CstLinkman(String lkmCustNo, String lkmCustName, String lkmName,
//			String lkmSex, String lkmPostion, String lkmTel, String lkmMobile,
//			String lkmMemo) {
//		this.lkmCustNo = lkmCustNo;
//		this.lkmCustName = lkmCustName;
//		this.lkmName = lkmName;
//		this.lkmSex = lkmSex;
//		this.lkmPostion = lkmPostion;
//		this.lkmTel = lkmTel;
//		this.lkmMobile = lkmMobile;
//		this.lkmMemo = lkmMemo;
//	}

	// Property accessors

	public Integer getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Integer lkmId) {
		this.lkmId = lkmId;
	}

//	public String getLkmCustNo() {
//		return this.lkmCustNo;
//	}
//
//	public void setLkmCustNo(String lkmCustNo) {
//		this.lkmCustNo = lkmCustNo;
//	}

	public String getLkmCustName() {
		return this.lkmCustName;
	}

	public void setLkmCustName(String lkmCustName) {
		this.lkmCustName = lkmCustName;
	}

	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public String getLkmSex() {
		return this.lkmSex;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	public String getLkmPostion() {
		return this.lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	public String getLkmTel() {
		return this.lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	public String getLkmMobile() {
		return this.lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmMemo() {
		return this.lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public CstCustomer getCustomers() {
		return customers;
	}

	public void setCustomers(CstCustomer customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CstLinkman [customers=" + customers + ", lkmCustName="
				+ lkmCustName + ", lkmId=" + lkmId + ", lkmMemo=" + lkmMemo
				+ ", lkmMobile=" + lkmMobile + ", lkmName=" + lkmName
				+ ", lkmPostion=" + lkmPostion + ", lkmSex=" + lkmSex
				+ ", lkmTel=" + lkmTel + "]";
	}



	
}