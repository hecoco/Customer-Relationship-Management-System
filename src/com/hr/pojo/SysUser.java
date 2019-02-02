package com.hr.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer usrId;
	private String usrName;
	private String usrPassword;
	private Integer usrFlag;
	
	private SysRole role;
	
	//一个经理对应多个客户
	private List<CstCustomer> cust=new ArrayList<CstCustomer>(0);
   
	// Constructors
	
	/** default constructor */
	public SysUser() {
	}

	
	// Property accessors

	public Integer getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public Integer getUsrFlag() {
		return this.usrFlag;
	}

	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}


	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}


	public List<CstCustomer> getCust() {
		return cust;
	}


	public void setCust(List<CstCustomer> cust) {
		this.cust = cust;
	}



	

}