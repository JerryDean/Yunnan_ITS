package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

/** Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or licence agreement with ST Electronics Info-comm Systems PTE. LTD.
 *
 * Project Name : CCS_ERS_Mgt
 * <p>PackageName : com.stee.emer.entity</p>
 * <p>ClassName   : ProposalContent </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月23日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Alias("ProposalContent")
public class ProposalContent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4812983491264292984L;

	//编号
	private String id;
	
	//预案内容
    private String content;         
    
    //时间
    private Date startTime;         
    
    //联系人
    private String contact;          
    
    //联系电话
    private String phone;            
    
    //描述
    private String description;

	public ProposalContent() {
		super();
	}

	public ProposalContent(String id, String content, Date startTime, String contact, String phone,
			String description) {
		super();
		this.id = id;
		this.content = content;
		this.startTime = startTime;
		this.contact = contact;
		this.phone = phone;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProposalContent [id=" + id + ", content=" + content + ", startTime=" + startTime + ", contact="
				+ contact + ", phone=" + phone + ", description=" + description + "]";
	}
    
    
}
