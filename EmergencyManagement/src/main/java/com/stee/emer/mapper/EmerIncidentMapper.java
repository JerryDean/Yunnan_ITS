package com.stee.emer.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.AdministratorOffice;
import com.stee.emer.entity.CmsEvent;
import com.stee.emer.entity.Incident;
import com.stee.emer.entity.ReportInfo;

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
 * Project Name : CCS_ERS_Mgt
 * <p>
 * PackageName : com.stee.emer.mapper
 * </p>
 * <p>
 * ClassName : EmerIncidentMapper
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016-01-07
 * </p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface EmerIncidentMapper {

	public int addIncident(Incident incident);

	public int updateIncident(Incident incident);

	public int deleteIncident(String id);

	public Incident findIncidentById(String id);

	public List<Incident> getAllIncident();

	public List<Incident> findIncidentByTime(@Param("id") String id, @Param("time1") Date time1,
			@Param("time2") Date time2);

	public List<Incident> findHistIncidentByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	public List<AdministratorOffice> getAoList();

	public List<Incident> getIncidentByAo(@Param("orgId") String orgId);

	public List<Incident> getIncidentByQueryBean(@Param("startTime") Date startTime, @Param("endTime") Date endTime,
			@Param("section") String section, @Param("type") String type,
			@Param("administrativeOffice") String administrativeOffice);

	public int saveUserReportInfo(ReportInfo info);

	public void addCmsEvent(CmsEvent o);

	public Incident findByIncidentNo(@Param("incidentNo") String incidentNo);

	public String findName(@Param("category") String category, @Param("value") String value);

	public String findByDesc(@Param("descr") String string, @Param("value") String intervalStart);

}
