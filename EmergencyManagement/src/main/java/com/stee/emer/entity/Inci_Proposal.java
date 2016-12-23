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
 * ClassName : Inci_Proposal
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年3月7日
 * </p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Alias("Inci_Proposal")
public class Inci_Proposal implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -215240863304644643L;

	// 编号
	private String id;

	// 事件Id
	private String incidentId;

	// 预案名称
	private String name;

	// 描述
	private String description;

	// 事件类型
	private String type;

	// 事件子类型
	private String subType;

	// 事件等级
	private String incidentLevel;

	// 内容
	private String content;

	// 联系人
	private String contact;

	// 联系电话
	private String phone;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人
	 */
	private String createBy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 更新人
	 */
	private String updateBy;

	/**
	 * 审核状态(0-未通过，1-审核通过,2-审核拒绝)
	 */
	private Integer status;

	/**
	 * 执行状态（0--未执行 1--管理处执行 2--中心执行）
	 */
	private Integer implementStatus;

	public Integer getImplementStatus() {
		return implementStatus;
	}

	public void setImplementStatus(Integer implementStatus) {
		this.implementStatus = implementStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getIncidentLevel() {
		return incidentLevel;
	}

	public void setIncidentLevel(String incidentLevel) {
		this.incidentLevel = incidentLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Inci_Proposal [id=" + id + ", incidentId=" + incidentId + ", name=" + name + ", description="
				+ description + ", type=" + type + ", subType=" + subType + ", incidentLevel=" + incidentLevel
				+ ", content=" + content + ", contact=" + contact + ", phone=" + phone + ", createTime=" + createTime
				+ ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + ", status="
				+ status + ", implementStatus=" + implementStatus + "]";
	}

}
