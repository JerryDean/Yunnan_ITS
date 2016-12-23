package com.stee.emer.service;

import java.util.Date;
import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.PreAlarmAction;
import com.stee.emer.entity.PreAlarmInfo;
import com.stee.emer.entity.PreAlarmNoticeOrganization;

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
public interface IEmerPreAlarm {

	public Result addPreAlarmInfo(PreAlarmInfo preAlarmInfo);

	public Result getAllPreAlarmInfo();

	public Result findPreAlarmInfoById(String id);

	public Result addNoticeOrganizations(List<PreAlarmNoticeOrganization> orgs);

	public Result updateNoticeOrganization(PreAlarmNoticeOrganization org);

	public Result addPreAlarmAction(PreAlarmAction action);

	public Result updatePreAlarmAction(PreAlarmAction action);

	public Result getHisPreAlarmInfoByTime(Date startTime, Date endTime);

	public Result updatePreAlarmInfo(PreAlarmInfo preAlarmInfo);

	public Result deletePreAlarmActionById(String id);

}
