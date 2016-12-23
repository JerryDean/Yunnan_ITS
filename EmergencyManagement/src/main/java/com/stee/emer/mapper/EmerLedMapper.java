package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.IncidentLog;
import com.stee.emer.entity.LedInfo;

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
public interface EmerLedMapper {

	int updateLedInfo(@Param("instutationId") String instutationId, @Param("incidentId") String incidentId,
			@Param("flag") Integer flag);

	List<IncidentLog> getLogsByIncidentId(@Param("incidentId") String incidentId);

	int updateSwitch(@Param("instutationId") String instutationId, @Param("incidentId") String incidentId,
			@Param("flag") Integer flag);

	List<LedInfo> findById(@Param("id") String id);

	List<LedInfo> getByInstutationId(@Param("instutationId") String instutationId);

}
