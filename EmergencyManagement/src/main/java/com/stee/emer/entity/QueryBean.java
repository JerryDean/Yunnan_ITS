package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Date;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : CCS_ERS_Mgt
 * File Name    : QueryBean.java
 * Author       : Jerry
 * Created      : 2016年12月1日 下午2:27:15
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class QueryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date startTime;
	private Date endTime;

	private String section;
	private String type;

	private String administrativeOffice;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdministrativeOffice() {
		return administrativeOffice;
	}

	public void setAdministrativeOffice(String administrativeOffice) {
		this.administrativeOffice = administrativeOffice;
	}

	@Override
	public String toString() {
		return "QueryBean [startTime=" + startTime + ", endTime=" + endTime + ", section=" + section + ", type=" + type
				+ ", administrativeOffice=" + administrativeOffice + "]";
	}

}
