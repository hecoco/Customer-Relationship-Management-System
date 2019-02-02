package com.hr.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * SalChance entity. @author MyEclipse Persistence Tools
 */

public class SalChance implements java.io.Serializable {

	// Fields

	private Integer chcId;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private Integer chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcDesc;
	// 多对一  对应SysUser表
    private SysUser su;
	private Integer chcCreateId;
	private String chcCreateBy;
	private Timestamp chcCreateDate;
	//private Integer chcDueId;
	private String chcDueTo;
	private Timestamp chcDueDate;
	private String chcStatus;
	
	//一对多  对应SalPlan表
    private List<SalPlan> sp=new ArrayList<SalPlan>(0);
    
    
    
	
    
    
	// Constructors

	



	/** default constructor */
	public SalChance() {
	}

	public List<SalPlan> getSp() {
		return sp;
	}

	public void setSp(List<SalPlan> sp) {
		this.sp = sp;
	}

	/** full constructor */
	public SalChance(String chcSource, String chcCustName, String chcTitle,
			Integer chcRate, String chcLinkman, String chcTel, String chcDesc,
			 String chcCreateBy, Timestamp chcCreateDate,
			Integer chcDueId, String chcDueTo, Timestamp chcDueDate,
			String chcStatus) {
		this.chcSource = chcSource;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcDesc = chcDesc;
		this.chcCreateId = chcCreateId;
		this.chcCreateBy = chcCreateBy;
		this.chcCreateDate = chcCreateDate;
		//this.chcDueId = chcDueId;
		this.chcDueTo = chcDueTo;
		this.chcDueDate = chcDueDate;
		this.chcStatus = chcStatus;
	}

	// Property accessors

	public Integer getChcId() {
		return this.chcId;
	}

	public void setChcId(Integer chcId) {
		this.chcId = chcId;
	}

	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	public String getChcCustName() {
		return this.chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public Integer getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(Integer chcRate) {
		this.chcRate = chcRate;
	}

	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	public Integer getChcCreateId() {
		return this.chcCreateId;
	}

	public void setChcCreateId(Integer chcCreateId) {
		this.chcCreateId = chcCreateId;
	}

	public String getChcCreateBy() {
		return this.chcCreateBy;
	}

	public void setChcCreateBy(String chcCreateBy) {
		this.chcCreateBy = chcCreateBy;
	}

	public Timestamp getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Timestamp chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}
/*
	public Integer getChcDueId() {
		return this.chcDueId;
	}

	public void setChcDueId(Integer chcDueId) {
		this.chcDueId = chcDueId;
	}*/

	public String getChcDueTo() {
		return this.chcDueTo;
	}

	public void setChcDueTo(String chcDueTo) {
		this.chcDueTo = chcDueTo;
	}

	public Timestamp getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Timestamp chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	public String getChcStatus() {
		return this.chcStatus;
	}

	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}

	public SysUser getSu() {
		return su;
	}

	public void setSu(SysUser su) {
		this.su = su;
	}

	
	
}