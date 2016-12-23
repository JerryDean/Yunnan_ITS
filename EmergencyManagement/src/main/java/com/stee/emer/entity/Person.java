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
 * ClassName : Person
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
@Alias("Person")
public class Person implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2278517312974935957L;

	// 人员编号
	private String id;
	
	// 机构编号
	private String organizationId;
	
	// 职务
	private String title;
	
	// 联系方式
	private String phone;
	
	// 备注
	private String remark;

	public Person() {
		super();
	}

	public Person(String id, String organizationId, String title, String phone, String remark) {
		super();
		this.id = id;
		this.organizationId = organizationId;
		this.title = title;
		this.phone = phone;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", organizationId=" + organizationId + ", title=" + title + ", phone=" + phone
				+ ", remark=" + remark + "]";
	}

}
