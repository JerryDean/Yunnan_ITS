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
@Alias("AttachmentFileInfo")
public class AttachmentFileInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String attachmentName;
	private String attachmentDesc;
	private String incidentId;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;
	private String fileForm;

	public String getFileForm() {
		return fileForm;
	}

	public void setFileForm(String fileForm) {
		this.fileForm = fileForm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentDesc() {
		return attachmentDesc;
	}

	public void setAttachmentDesc(String attachmentDesc) {
		this.attachmentDesc = attachmentDesc;
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
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

	@Override
	public String toString() {
		return "AttachmentFileInfo [id=" + id + ", attachmentName=" + attachmentName + ", attachmentDesc="
				+ attachmentDesc + ", incidentId=" + incidentId + ", createTime=" + createTime + ", createBy="
				+ createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + ", fileForm=" + fileForm + "]";
	}

}
