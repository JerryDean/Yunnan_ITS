package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.AttachmentFileContentByte;
import com.stee.emer.entity.AttachmentFileInfo;

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
public interface EmerAttachmentMapper {

	int addAttachmentFileInfo(AttachmentFileInfo info);

	int addAttachmentFileContent(AttachmentFileContentByte content);

	int updateAttachmentFileInfo(AttachmentFileInfo info);

	int updateAttachmentFileContent(AttachmentFileContentByte content);

	int deleteAttachmentFileInfo(@Param("id") String id);

	int deleteAttachmentFileContent(@Param("id") String id);

	List<AttachmentFileInfo> getAttachmentFileInfoByIncidentId(@Param("id") String id);

	AttachmentFileContentByte findAttachmentFileContentByInfoId(@Param("id") String id);

	int deleteAttachmentFileInfoByIncidentId(@Param("id") String id);

	AttachmentFileInfo findAttachmentFileInfoById(@Param("id") String id);

}
