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
 * Project Name : CCS_ERS_Mgt
 * <p>
 * PackageName : com.stee.emer.entity
 * </p>
 * <p>
 * ClassName : Warning
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016-01-07
 * </p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Alias("Warning")
public class Warning implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3509957051350037409L;

	// 编号
	private String id;

	// 事件类型
	private String type;

	// 事件子类型
	private String subtype;

	// 事件等级
	private String incidentLevel;

	// 信息来源
	private String source;

	// 开始时间
	private Date startTime;

	// 结束时间
	private Date endTime;

	// 事件描述
	private String description;

	public Warning() {
		super();
	}

	public Warning(String id, String type, String subtype, String incidentLevel, String source, Date startTime,
			Date endTime, String description) {
		super();
		this.id = id;
		this.type = type;
		this.subtype = subtype;
		this.incidentLevel = incidentLevel;
		this.source = source;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getIncidentLevel() {
		return incidentLevel;
	}

	public void setIncidentLevel(String incidentLevel) {
		this.incidentLevel = incidentLevel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Warning [id=" + id + ", type=" + type + ", subtype=" + subtype + ", incidentLevel=" + incidentLevel
				+ ", source=" + source + ", startTime=" + startTime + ", endTime=" + endTime + ", description="
				+ description + "]";
	}

	
	
	

}
