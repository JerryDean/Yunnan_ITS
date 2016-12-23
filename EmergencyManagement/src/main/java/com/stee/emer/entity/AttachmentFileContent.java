package com.stee.emer.entity;

import java.io.Serializable;

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
public class AttachmentFileContent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fileContent;
	private String attachmentFileInfoId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String getAttachmentFileInfoId() {
		return attachmentFileInfoId;
	}

	public void setAttachmentFileInfoId(String attachmentFileInfoId) {
		this.attachmentFileInfoId = attachmentFileInfoId;
	}

	@Override
	public String toString() {
		return "AttachmentFileContent [id=" + id + ", fileContent=" + fileContent + ", attachmentFileInfoId="
				+ attachmentFileInfoId + "]";
	}

}
