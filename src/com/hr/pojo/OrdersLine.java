package com.hr.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */

public class OrdersLine implements java.io.Serializable {

	// Fields

	private Integer oddId;
	//private Integer oddOrderId;
	//private Integer oddProdId;
	private Integer oddCount;
	private String oddUnit;
	private Double oddPrice;
	//多对一: 多个订单详情属于一个订单
	private Orders ordersss;
	//一对多：一个订单详情对应多个商品
	//private List<Product> products=new ArrayList<Product>(0);
	//多对一：多个订单详情对应一个商品
	private Product products;

	// Constructors

	/** default constructor */
	public OrdersLine() {
	}

	/** full constructor */
//	public OrdersLine(Integer oddOrderId, Integer oddProdId, Integer oddCount,
//			String oddUnit, Double oddPrice) {
//		this.oddOrderId = oddOrderId;
//		this.oddProdId = oddProdId;
//		this.oddCount = oddCount;
//		this.oddUnit = oddUnit;
//		this.oddPrice = oddPrice;
//	}

	// Property accessors

	public Integer getOddId() {
		return this.oddId;
	}

	public void setOddId(Integer oddId) {
		this.oddId = oddId;
	}

//	public Integer getOddOrderId() {
//		return this.oddOrderId;
//	}
//
//	public void setOddOrderId(Integer oddOrderId) {
//		this.oddOrderId = oddOrderId;
//	}

//	public Integer getOddProdId() {
//		return this.oddProdId;
//	}
//
//	public void setOddProdId(Integer oddProdId) {
//		this.oddProdId = oddProdId;
//	}

	public Integer getOddCount() {
		return this.oddCount;
	}

	public void setOddCount(Integer oddCount) {
		this.oddCount = oddCount;
	}

	public String getOddUnit() {
		return this.oddUnit;
	}

	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}

	public Double getOddPrice() {
		return this.oddPrice;
	}

	public void setOddPrice(Double oddPrice) {
		this.oddPrice = oddPrice;
	}

	public Orders getOrdersss() {
		return ordersss;
	}

	public void setOrdersss(Orders ordersss) {
		this.ordersss = ordersss;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrdersLine [oddCount=" + oddCount + ", oddId=" + oddId
				+ ", oddPrice=" + oddPrice + ", oddUnit=" + oddUnit
				+ ", ordersss=" + ordersss + ", products=" + products + "]";
	}

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	

}