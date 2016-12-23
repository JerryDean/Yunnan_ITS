package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD All rights
 * reserved.
 *
 * This software is confidential and proprietary property of ST Electronics
 * Info-comm Systems PTE. LTD. The user shall not disclose the contents of this
 * software and shall only use it in accordance with the terms and conditions
 * stated in the contract or licence agreement with ST Electronics Info-comm
 * Systems PTE. LTD.
 *
 * @author Jerry
 * @version 1.0
 *
 */
@Alias("NoticeORG")
public class PreAlarmNoticeOrganization implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 预警编号
	 */
	private String preAlarmId;
	/*
	 * 单位编号
	 */
	private String organizationId;
	/*
	 * 通知时间
	 */
	private Date noticeTime;
	/*
	 * 响应时间
	 */
	private Date responseTime;

	/**
	 * 该预警单位采取措施的集合
	 */
	private List<PreAlarmAction> actions;

	public List<PreAlarmAction> getActions() {
		return actions;
	}

	public void setActions(List<PreAlarmAction> actions) {
		this.actions = actions;
	}

	public String getPreAlarmId() {
		return preAlarmId;
	}

	public void setPreAlarmId(String preAlarmId) {
		this.preAlarmId = preAlarmId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	@Override
	public String toString() {
		return "PreAlarmNoticeOrganization [preAlarmId=" + preAlarmId + ", organizationId=" + organizationId
				+ ", noticeTime=" + noticeTime + ", responseTime=" + responseTime + ", actions=" + actions + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
