package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Arrays;

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
@Alias("attachmentContent")
public class AttachmentFileContentByte implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private byte[] fileContent;
	private String attachmentFileInfoId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
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
		return "AttachmentFileContentByte [id=" + id + ", fileContent=" + Arrays.toString(fileContent)
				+ ", attachmentFileInfoId=" + attachmentFileInfoId + "]";
	}

}
