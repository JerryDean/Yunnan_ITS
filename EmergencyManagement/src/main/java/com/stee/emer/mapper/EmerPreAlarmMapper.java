package com.stee.emer.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
public interface EmerPreAlarmMapper {

	public int addPreAlarmInfo(PreAlarmInfo preAlarmInfo);

	public List<PreAlarmInfo> getAllPreAlarmInfo();

	public List<PreAlarmNoticeOrganization> getNoticeOrganizationByAlarmId(@Param("preAlarmId") String id);

	public List<PreAlarmAction> getPreAlarmActionsByOrgId(@Param("id") String id,
			@Param("organizationId") String organizationId);

	public PreAlarmInfo findPreAlarmInfoById(@Param("id") String id);

	public int addNoticeOrganization(PreAlarmNoticeOrganization org);

	public int addPreAlarmAction(PreAlarmAction preAlarmAction);

	public int updateNoticeOrganization(PreAlarmNoticeOrganization org);

	public int updatePreAlarmAction(PreAlarmAction action);

	public List<PreAlarmInfo> getHisPreAlarmInfoByTime(@Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	public int updatePreAlarmInfo(PreAlarmInfo preAlarmInfo);

	public int deletePreAlarmActionById(@Param("id") String id);

}
