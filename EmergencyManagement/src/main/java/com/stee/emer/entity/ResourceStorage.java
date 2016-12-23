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
 * ClassName : ResourceStorage
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
@Alias("ResourceStorage")
public class ResourceStorage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8231454522337280061L;

	// 物质库编号
	private String id;

	// 物资库名称
	private String name;

	// 管理处名称
	private String manager;

	// 道路名称
	private String road;

	// 路段名称
	private String section;

	// 桩号
	private String point;

	// 位置
	private String location;

	// 物资库描述
	private String description;

	// 开始使用时间
	private Date startTime;

	// 备注
	private String remark;

	public ResourceStorage() {
		super();
	}

	public ResourceStorage(String id, String name, String manager, String road, String section, String point,
			String location, String description, Date startTime, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.road = road;
		this.section = section;
		this.point = point;
		this.location = location;
		this.description = description;
		this.startTime = startTime;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResourceStorage [id=" + id + ", name=" + name + ", manager=" + manager + ", road=" + road + ", section="
				+ section + ", point=" + point + ", location=" + location + ", description=" + description
				+ ", startTime=" + startTime + ", remark=" + remark + "]";
	}

	
	
}
