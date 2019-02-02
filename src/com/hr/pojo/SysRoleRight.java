package com.hr.pojo;

/**
 * SysRoleRight entity. @author MyEclipse Persistence Tools
 */

public class SysRoleRight implements java.io.Serializable {

	// Fields

	private Integer rfId;
	private Integer rfRoleId;
	private String rfRightCode;

	// Constructors

	/** default constructor */
	public SysRoleRight() {
	}

	/** full constructor */
	public SysRoleRight(Integer rfRoleId, String rfRightCode) {
		this.rfRoleId = rfRoleId;
		this.rfRightCode = rfRightCode;
	}

	// Property accessors

	public Integer getRfId() {
		return this.rfId;
	}

	public void setRfId(Integer rfId) {
		this.rfId = rfId;
	}

	public Integer getRfRoleId() {
		return this.rfRoleId;
	}

	public void setRfRoleId(Integer rfRoleId) {
		this.rfRoleId = rfRoleId;
	}

	public String getRfRightCode() {
		return this.rfRightCode;
	}

	public void setRfRightCode(String rfRightCode) {
		this.rfRightCode = rfRightCode;
	}

}