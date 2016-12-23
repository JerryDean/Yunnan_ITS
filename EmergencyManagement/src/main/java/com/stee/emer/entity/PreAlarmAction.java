package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Date;

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
@Alias("PreAlarmAction")
public class PreAlarmAction implements Serializable {

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
	 * 预警措施
	 */
	private String action;
	/*
	 * 开始时间
	 */
	private Date startTime;
	/*
	 * 结束时间
	 */
	private Date endTime;
	/*
	 * 确认状态
	 */
	private Integer state;

	/**
	 * 措施编号
	 */
	private String actionId;

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "PreAlarmAction [preAlarmId=" + preAlarmId + ", organizationId=" + organizationId + ", action=" + action
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", state=" + state + ", actionId=" + actionId
				+ "]";
	}

}
