package com.stee.emer.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.AttachmentFile;
import com.stee.emer.entity.PreAlarmAction;
import com.stee.emer.entity.PreAlarmInfo;
import com.stee.emer.entity.PreAlarmNoticeOrganization;
import com.stee.emer.mapper.EmerPreAlarmMapper;
import com.stee.emer.service.IEmerAttachment;
import com.stee.emer.service.IEmerPreAlarm;
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
public class EmerPreAlarm implements IEmerPreAlarm {

	@Autowired
	EmerPreAlarmMapper emerPreAlarmMapper;

	@Autowired
	IEmerAttachment attachMgt;

	@Override
	public Result addPreAlarmInfo(PreAlarmInfo preAlarmInfo) {
		Result result = new Result();
		if (null != preAlarmInfo) {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateStr = sdf.format(date);
			String[] dateArray = dateStr.split("-");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < dateArray.length; i++) {
				sb.append(dateArray[i]);
			}
			if (null == preAlarmInfo.getId() || preAlarmInfo.getId().equals(""))
				preAlarmInfo.setId(sb.toString());
			EmerAttachment.preAlarmId = preAlarmInfo.getId();
			int num = emerPreAlarmMapper.addPreAlarmInfo(preAlarmInfo);
			if (num >= 1) {
				result.setId(preAlarmInfo.getId());
				result.setUniqueData(preAlarmInfo);
				result.setStatusCode(Utils.SUCCESS);
				saveAttachs(preAlarmInfo.getId(), preAlarmInfo.getAttachs());
			} else {
				result.setStatusCode(Utils.FAIL);
			}
			List<PreAlarmNoticeOrganization> orgs = preAlarmInfo.getOrgs();
			if (null != orgs && !orgs.isEmpty()) {
				for (PreAlarmNoticeOrganization org : orgs) {
					org.setPreAlarmId(preAlarmInfo.getId());
					emerPreAlarmMapper.addNoticeOrganization(org);
					List<PreAlarmAction> actions = org.getActions();
					if (null != actions && !actions.isEmpty()) {
						for (PreAlarmAction action : actions) {
							action.setPreAlarmId(preAlarmInfo.getId());
							emerPreAlarmMapper.addPreAlarmAction(action);
						}
					}
				}
			}
		} else {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		return result;
	}

	/**
	 * 存储预警附件
	 * 
	 * @param id
	 * @param attachs
	 * @author Jerry
	 */
	private void saveAttachs(String id, List<AttachmentFile> attachs) {
		if (null == attachs) {
			return;
		}
		for (AttachmentFile attach : attachs) {
			attachMgt.addAttachmentFile(attach);
		}
	}

	@Override
	public Result getAllPreAlarmInfo() {
		Result result = new Result();
		try {
			List<PreAlarmInfo> list = emerPreAlarmMapper.getAllPreAlarmInfo();
			List<PreAlarmInfo> realityList = new ArrayList<>();
			if (null != list && !list.isEmpty()) {
				for (PreAlarmInfo pai : list) {
					List<PreAlarmNoticeOrganization> orgs = emerPreAlarmMapper
							.getNoticeOrganizationByAlarmId(pai.getId());
					if (null != orgs && !orgs.isEmpty()) {
						for (PreAlarmNoticeOrganization paa : orgs) {
							List<PreAlarmAction> actions = emerPreAlarmMapper.getPreAlarmActionsByOrgId(pai.getId(),
									paa.getOrganizationId());
							if (null != actions && !actions.isEmpty()) {
								paa.setActions(actions);
							}
						}
						pai.setOrgs(orgs);
					}
					realityList.add(pai);
				}
			}
			result.setId(null);
			result.setData(realityList);
			result.setStatusCode(Utils.SUCCESS);
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}

		return result;
	}

	@Override
	public Result findPreAlarmInfoById(String id) {
		Result result = new Result();
		PreAlarmInfo pai = null;
		try {
			pai = emerPreAlarmMapper.findPreAlarmInfoById(id);
		} catch (Exception e) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		if (null != pai) {
			List<PreAlarmNoticeOrganization> list = emerPreAlarmMapper.getNoticeOrganizationByAlarmId(id);
			for (PreAlarmNoticeOrganization pano : list) {
				List<PreAlarmAction> actions = emerPreAlarmMapper.getPreAlarmActionsByOrgId(id,
						pano.getOrganizationId());
				pano.setActions(actions);
			}
			pai.setOrgs(list);
			result.setId(id);
			result.setUniqueData(pai);
			result.setStatusCode(Utils.SUCCESS);
		} else {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result addNoticeOrganizations(List<PreAlarmNoticeOrganization> orgs) {
		Result result = new Result();
		if (null != orgs && !orgs.isEmpty()) {
			try {
				int num = 0;
				for (PreAlarmNoticeOrganization org : orgs) {
					num = emerPreAlarmMapper.addNoticeOrganization(org);
					List<PreAlarmAction> actions = org.getActions();
					if (null != actions) {
						for (PreAlarmAction action : actions) {
							if (null == action.getOrganizationId() || action.getOrganizationId().equals("")) {
								action.setOrganizationId(org.getOrganizationId());
							}
							emerPreAlarmMapper.addPreAlarmAction(action);
						}
					}
				}
				if (num > 0) {
					result.setId(null);
					result.setData(orgs);
					result.setStatusCode(Utils.SUCCESS);
				}
			} catch (Exception e) {
				result.setStatusCode(Utils.FAIL);
			}
		} else {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		return result;
	}

	@Override
	public Result updateNoticeOrganization(PreAlarmNoticeOrganization org) {
		Result result = new Result();
		if (null != org) {
			int num = emerPreAlarmMapper.updateNoticeOrganization(org);
			if (num > 0) {
				result.setId(org.getOrganizationId());
				result.setUniqueData(org);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.FAIL);
			}
		} else {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		return result;
	}

	@Override
	public Result addPreAlarmAction(PreAlarmAction action) {
		Result result = new Result();
		if (null != action) {
			int num = emerPreAlarmMapper.addPreAlarmAction(action);
			if (num > 0) {
				result.setId(null);
				result.setUniqueData(action);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.FAIL);
			}
		} else {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		return result;
	}

	@Override
	public Result updatePreAlarmAction(PreAlarmAction action) {
		Result result = new Result();
		if (null != action) {
			int num = emerPreAlarmMapper.updatePreAlarmAction(action);
			if (num > 0) {
				result.setId(null);
				result.setUniqueData(action);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.FAIL);
			}
		} else {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		return result;
	}

	@Override
	public Result getHisPreAlarmInfoByTime(Date startTime, Date endTime) {
		Result result = new Result();
		if (null == startTime || null == endTime) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			List<PreAlarmInfo> resultList = new ArrayList<>();

			List<PreAlarmInfo> list = emerPreAlarmMapper.getHisPreAlarmInfoByTime(startTime, endTime);
			for (PreAlarmInfo preAlarmInfo : list) {
				PreAlarmInfo alarmInfo = (PreAlarmInfo) preAlarmInfo.clone();
				List<PreAlarmNoticeOrganization> orgaList = new ArrayList<>();

				List<PreAlarmNoticeOrganization> noList = emerPreAlarmMapper
						.getNoticeOrganizationByAlarmId(preAlarmInfo.getId());
				for (PreAlarmNoticeOrganization preAlarmNoticeOrganization : noList) {
					PreAlarmNoticeOrganization noticeOrganization = (PreAlarmNoticeOrganization) preAlarmNoticeOrganization
							.clone();
					List<PreAlarmAction> actionList = emerPreAlarmMapper.getPreAlarmActionsByOrgId(preAlarmInfo.getId(),
							preAlarmNoticeOrganization.getOrganizationId());
					noticeOrganization.setActions(actionList);
					orgaList.add(noticeOrganization);
				}

				alarmInfo.setOrgs(orgaList);
				resultList.add(alarmInfo);
			}
			if (resultList.isEmpty()) {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			} else {
				result.setData(resultList);
				result.setStatusCode(Utils.SUCCESS);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}

		return result;
	}

	@Override
	public Result updatePreAlarmInfo(PreAlarmInfo preAlarmInfo) {
		Result result = new Result();
		if (null == preAlarmInfo) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			int num = emerPreAlarmMapper.updatePreAlarmInfo(preAlarmInfo);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result deletePreAlarmActionById(String id) {
		Result result = new Result();
		result.setId(id);
		if (null == id) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			int num = emerPreAlarmMapper.deletePreAlarmActionById(id);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

}
