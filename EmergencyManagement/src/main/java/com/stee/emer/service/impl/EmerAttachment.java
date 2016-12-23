package com.stee.emer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.AttachmentFile;
import com.stee.emer.entity.AttachmentFileContent;
import com.stee.emer.entity.AttachmentFileContentByte;
import com.stee.emer.entity.AttachmentFileInfo;
import com.stee.emer.mapper.EmerAttachmentMapper;
import com.stee.emer.service.IEmerAttachment;
import com.stee.emer.util.GUIDUtils;
import com.stee.emer.util.ImageUtils;
import com.stee.emer.util.Utils;

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
@Service
public class EmerAttachment implements IEmerAttachment {
	@Autowired
	EmerAttachmentMapper emerattachmentMapper;

	public static String preAlarmId;

	enum OperationType {
		UPDATE, INSERT
	}

	@Override
	public Result addAttachmentFile(AttachmentFile file) {
		Result result = new Result();

		Map<String, Object> map = splitAttachmentFile(OperationType.INSERT, file);
		if (null == map) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		AttachmentFileInfo info = (AttachmentFileInfo) map.get("info");
		result.setId(info.getId());
		AttachmentFileContentByte content = (AttachmentFileContentByte) map.get("content");

		int num = emerattachmentMapper.addAttachmentFileInfo(info);

		int num1 = emerattachmentMapper.addAttachmentFileContent(content);

		if (num != -1 && num1 != -1) {
			result.setStatusCode(Utils.SUCCESS);
		} else {
			result.setStatusCode(Utils.FAIL);
		}

		return result;
	}

	private Map<String, Object> splitAttachmentFile(OperationType type, AttachmentFile file) {
		if (null == file) {
			return null;
		}

		String guid = GUIDUtils.getGUID();

		Map<String, Object> map = new HashMap<>();

		AttachmentFileInfo info = new AttachmentFileInfo();
		info.setAttachmentDesc(file.getAttachmentDesc());
		info.setAttachmentName(file.getAttachmentName());
		info.setCreateBy(file.getCreateBy());
		info.setCreateTime(file.getCreateTime());
		if (type == OperationType.INSERT) {
			info.setId(guid);
		}
		info.setIncidentId(file.getIncidentId() == null ? preAlarmId : file.getIncidentId());
		info.setUpdateBy(file.getUpdateBy());
		info.setUpdateTime(file.getUpdateTime());
		info.setFileForm(ImageUtils.getImgForm(file.getFileContent()));

		map.put("info", info);

		AttachmentFileContentByte content = new AttachmentFileContentByte();
		if (type == OperationType.INSERT) {
			content.setAttachmentFileInfoId(guid);
			content.setId(GUIDUtils.getGUID());
		}

		String imgStr = ImageUtils.cutImgStr(file.getFileContent());
		byte[] imgByte = ImageUtils.getImgBinary(imgStr);
		content.setFileContent(ImageUtils.compressImg(imgByte));

		map.put("content", content);

		return map;
	}

	@Override
	public Result updateAttachmentFile(AttachmentFile file) {
		Result result = new Result();
		result.setId(file.getId());

		Map<String, Object> map = splitAttachmentFile(OperationType.UPDATE, file);
		if (null == map) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		AttachmentFileInfo info = (AttachmentFileInfo) map.get("info");
		AttachmentFileContentByte content = (AttachmentFileContentByte) map.get("content");

		int num = emerattachmentMapper.updateAttachmentFileInfo(info);

		int num1 = emerattachmentMapper.updateAttachmentFileContent(content);

		if (num != -1 && num1 != -1) {
			result.setStatusCode(Utils.SUCCESS);
		} else {
			result.setStatusCode(Utils.FAIL);
		}

		return result;
	}

	@Override
	public Result deleteAttachmentFileByIds(List<String> ids) {
		Result result = new Result();
		if (ids.isEmpty()) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		for (String id : ids) {
			int num = emerattachmentMapper.deleteAttachmentFileInfo(id);

			int num1 = emerattachmentMapper.deleteAttachmentFileContent(id);

			if (num != num1) {
				result.setStatusCode(Utils.FAIL);
				break;
			}
		}
		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

	@Override
	public Result getAttachmentFileInfoByIncidentId(String id) {
		Result result = new Result();
		if (null == id || id.equals("")) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		List<AttachmentFileInfo> list = emerattachmentMapper.getAttachmentFileInfoByIncidentId(id);
		if (list.isEmpty()) {
			result.setStatusCode(Utils.OBJECT_NOT_EXIST);
		} else {
			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);
		}
		return result;
	}

	@Override
	public Result findAttachmentFileContentByInfoId(String id) {
		Result result = new Result();
		if (null == id || id.equals("")) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		AttachmentFileInfo attachmentFileInfo = emerattachmentMapper.findAttachmentFileInfoById(id);
		AttachmentFileContentByte attachmentFileContent = emerattachmentMapper.findAttachmentFileContentByInfoId(id);
		AttachmentFileContent afc = new AttachmentFileContent();

		try {
			afc.setId(attachmentFileContent.getId());
			afc.setAttachmentFileInfoId(attachmentFileContent.getAttachmentFileInfoId());
			byte[] imgByte = ImageUtils.uncompressImg(attachmentFileContent.getFileContent());
			String imgStr = ImageUtils.getImgBase64Str(imgByte);
			afc.setFileContent(ImageUtils.packageImageStr(attachmentFileInfo.getFileForm(), imgStr));
		} catch (Exception e) {
			afc = null;
			e.printStackTrace();
		}

		if (null == afc) {
			result.setStatusCode(Utils.OBJECT_NOT_EXIST);
		} else {
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(afc);
		}
		return result;
	}

	@Override
	public Result deleteAttachmentFileByIncidentId(String id) {
		Result result = new Result();
		if (null == id || id.equals("")) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			List<AttachmentFileInfo> list = emerattachmentMapper.getAttachmentFileInfoByIncidentId(id);
			for (AttachmentFileInfo info : list) {
				emerattachmentMapper.deleteAttachmentFileContent(info.getId());
			}
			emerattachmentMapper.deleteAttachmentFileInfoByIncidentId(id);
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}

		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

	@Override
	public byte[] downloadAttachById(String id) {
		AttachmentFileContentByte attachmentFileContent = emerattachmentMapper.findAttachmentFileContentByInfoId(id);
		return ImageUtils.uncompressImg(attachmentFileContent.getFileContent());
	}

}
