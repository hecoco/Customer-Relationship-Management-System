package com.hr.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer prodId;
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String prodUnit;
	private Double prodPrice;
	private String prodMemo;
    //多对一：多个商品属于一个订单
	//private OrdersLine ordersLiness;
	//一对多：一个商品对应多个订单详情
	  private List<OrdersLine> ordersLiness=new ArrayList<OrdersLine>(0);
	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String prodName, String prodType, String prodBatch,
			String prodUnit, Double prodPrice, String prodMemo) {
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodBatch = prodBatch;
		this.prodUnit = prodUnit;
		this.prodPrice = prodPrice;
		this.prodMemo = prodMemo;
	}

	// Property accessors

	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdBatch() {
		return this.prodBatch;
	}

	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}

	public String getProdUnit() {
		return this.prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

	public Double getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdMemo() {
		return this.prodMemo;
	}

	public void setProdMemo(String prodMemo) {
		this.prodMemo = prodMemo;
	}

	public List<OrdersLine> getOrdersLiness() {
		return ordersLiness;
	}

	public void setOrdersLiness(List<OrdersLine> ordersLiness) {
		this.ordersLiness = ordersLiness;
	}

//	public OrdersLine getOrdersLiness() {
//		return ordersLiness;
//	}
//
//	public void setOrdersLiness(OrdersLine ordersLiness) {
//		this.ordersLiness = ordersLiness;
//	}
	

}