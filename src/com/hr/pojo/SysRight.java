package com.hr.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysRight implements java.io.Serializable {

	// Fields

	private String rightCode;
	private String rightParent;
	private String rightType;
	private String rightText;
	private String rightUrl;
	private String rightTip;
	
	private List<SysRole> roles = new ArrayList<SysRole>(0);

	// Constructors

	/** default constructor */
	public SysRight() {
	}

	/** minimal constructor */
	public SysRight(String rightCode) {
		this.rightCode = rightCode;
	}

	/** full constructor */
	public SysRight(String rightCode, String rightParent, String rightType,
			String rightText, String rightUrl, String rightTip) {
		this.rightCode = rightCode;
		this.rightParent = rightParent;
		this.rightType = rightType;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.rightTip = rightTip;
	}

	// Property accessors

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParent() {
		return this.rightParent;
	}

	public void setRightParent(String rightParent) {
		this.rightParent = rightParent;
	}

	public String getRightType() {
		return this.rightType;
	}

	public void setRightType(String rightType) {
		this.rightType = rightType;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public String getRightTip() {
		return this.rightTip;
	}

	public void setRightTip(String rightTip) {
		this.rightTip = rightTip;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

}