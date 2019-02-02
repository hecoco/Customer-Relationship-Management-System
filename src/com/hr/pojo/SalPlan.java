package com.hr.pojo;

import java.sql.Timestamp;

/**
 * SalPlan entity. @author MyEclipse Persistence Tools
 */

public class SalPlan implements java.io.Serializable {

	// Fields
	private Integer plaId;
	//多对一    SalChance表
	private SalChance slch;
	private Timestamp plaDate;
	private String plaTodo;
	private String plaResult;

	// Constructors

	/** default constructor */
	public SalPlan() {
	}

	/** full constructor */
	public SalPlan( Timestamp plaDate, String plaTodo,
			String plaResult) {
	
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	// Property accessors

	public Integer getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}



	public Timestamp getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Timestamp plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaTodo() {
		return this.plaTodo;
	}

	public SalChance getSlch() {
		return slch;
	}

	public void setSlch(SalChance slch) {
		this.slch = slch;
	}
	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}