package com.stee.emer.entity;

import java.io.Serializable;

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
 * ClassName : Organization
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
@Alias("Organization")
public class Organization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -970276362700825363L;

	// 机构编号
	private String id;
	
	// 机构名称
	private String name;
	
	// 地点
	private String location;
	
	// 联系人
	private String contact;
	
	// 联系方式
	private String phone;
	
	// 上级机构编号
	private String supervisor;
	
	// 备注
	private String remark;

	public Organization() {
		super();
	}

	public Organization(String id, String name, String location, String contact, String phone, String supervisor,
			String remark) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.phone = phone;
		this.supervisor = supervisor;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact
				+ ", phone=" + phone + ", supervisor=" + supervisor + ", remark=" + remark + "]";
	}

}
