package com.hr.pojo;

import java.sql.Timestamp;

/**
 * CstActivity entity. @author MyEclipse Persistence Tools
 */

public class CstActivity implements java.io.Serializable {

	// Fields

	private Integer atvId;
	//private String atvCustNo;
	private String atvCustName;
	private Timestamp atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private String atvBz;
	//多张交易记录对应一个客户
	private CstCustomer customers;

	// Constructors

	/** default constructor */
	public CstActivity() {
	}

	/** full constructor */
//	public CstActivity(String atvCustNo, String atvCustName, Timestamp atvDate,
//			String atvPlace, String atvTitle, String atvDesc) {
//		this.atvCustNo = atvCustNo;
//		this.atvCustName = atvCustName;
//		this.atvDate = atvDate;
//		this.atvPlace = atvPlace;
//		this.atvTitle = atvTitle;
//		this.atvDesc = atvDesc;
//	}

	// Property accessors

	public Integer getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Integer atvId) {
		this.atvId = atvId;
	}

//	public String getAtvCustNo() {
//		return this.atvCustNo;
//	}
//
//	public void setAtvCustNo(String atvCustNo) {
//		this.atvCustNo = atvCustNo;
//	}

	public String getAtvCustName() {
		return this.atvCustName;
	}

	public void setAtvCustName(String atvCustName) {
		this.atvCustName = atvCustName;
	}

	public Timestamp getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Timestamp atvDate) {
		this.atvDate = atvDate;
	}

	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}
	

	public String getAtvBz() {
		return atvBz;
	}

	public void setAtvBz(String atvBz) {
		this.atvBz = atvBz;
	}

	public CstCustomer getCustomers() {
		return customers;
	}

	public void setCustomers(CstCustomer customers) {
		this.customers = customers;
	}
	
    
	
}