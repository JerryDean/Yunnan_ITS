package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.AttachmentFile;

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
public interface IEmerAttachment {

	Result addAttachmentFile(AttachmentFile file);

	Result updateAttachmentFile(AttachmentFile file);

	Result deleteAttachmentFileByIds(List<String> ids);

	Result getAttachmentFileInfoByIncidentId(String id);

	Result findAttachmentFileContentByInfoId(String id);

	Result deleteAttachmentFileByIncidentId(String id);

	byte[] downloadAttachById(String id);

}
