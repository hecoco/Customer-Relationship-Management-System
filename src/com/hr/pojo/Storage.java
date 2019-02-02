package com.hr.pojo;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class Storage implements java.io.Serializable {

	// Fields

	private Integer stkId;
	private Integer stkProdId;
	private String stkWarehouse;
	private String stkWare;
	private Integer stkCount;
	private String stkMemo;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** full constructor */
	public Storage(Integer stkProdId, String stkWarehouse, String stkWare,
			Integer stkCount, String stkMemo) {
		this.stkProdId = stkProdId;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
	}

	// Property accessors

	public Integer getStkId() {
		return this.stkId;
	}

	public void setStkId(Integer stkId) {
		this.stkId = stkId;
	}

	public Integer getStkProdId() {
		return this.stkProdId;
	}

	public void setStkProdId(Integer stkProdId) {
		this.stkProdId = stkProdId;
	}

	public String getStkWarehouse() {
		return this.stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Integer getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return this.stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

}