package com.hr.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer odrId;
	//private String odrCustomer;
	private Timestamp odrDate;
	private String odrAddr;
	private String odrStatus;
    //多个订单对应一个客户
	private CstCustomer customerss;
	//一对多: 一个订单对应多个订单明细
    private List<OrdersLine> ordersLines=new ArrayList<OrdersLine>(0);
	
	
	// Constructors

	/** default constructor */
	public Orders() {
	}
//
//	/** full constructor */
//	public Orders(String odrCustomer, Timestamp odrDate, String odrAddr,
//			String odrStatus) {
//		this.odrCustomer = odrCustomer;
//		this.odrDate = odrDate;
//		this.odrAddr = odrAddr;
//		this.odrStatus = odrStatus;
//	}

	// Property accessors

	public Integer getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Integer odrId) {
		this.odrId = odrId;
	}

//	public String getOdrCustomer() {
//		return this.odrCustomer;
//	}
//
//	public void setOdrCustomer(String odrCustomer) {
//		this.odrCustomer = odrCustomer;
//	}

	public Timestamp getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Timestamp odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrAddr() {
		return this.odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	public String getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	public CstCustomer getCustomerss() {
		return customerss;
	}

	public void setCustomerss(CstCustomer customerss) {
		this.customerss = customerss;
	}

	public List<OrdersLine> getOrdersLines() {
		return ordersLines;
	}

	public void setOrdersLines(List<OrdersLine> ordersLines) {
		this.ordersLines = ordersLines;
	}
	

}