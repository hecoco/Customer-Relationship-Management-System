package com.hr.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * BasDict entity. @author MyEclipse Persistence Tools
 */

public class BasDict implements java.io.Serializable {

	// Fields

	private Integer dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private String dictIsEditable;
	
	//一个等级对应多个用户
	private List<CstCustomer> customers=new ArrayList<CstCustomer>(0);

	// Constructors

	/** default constructor */
	public BasDict() {
	}

	/** full constructor */
	public BasDict(String dictType, String dictItem, String dictValue,
			String dictIsEditable) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
	}

	// Property accessors

	public Integer getDictId() {
		return this.dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictIsEditable() {
		return this.dictIsEditable;
	}

	public void setDictIsEditable(String dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

	public List<CstCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CstCustomer> customers) {
		this.customers = customers;
	}
	

}