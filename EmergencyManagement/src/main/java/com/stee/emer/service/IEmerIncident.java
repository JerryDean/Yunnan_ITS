package com.stee.emer.service;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Incident;
import com.stee.emer.entity.QueryBean;

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
 * PackageName : com.stee.emer.service
 * </p>
 * <p>
 * ClassName : IEmerIncident
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
public interface IEmerIncident {

	/**
	 * 应急事件的录入
	 * 
	 * @param incident
	 *            Incident实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result addIncident(Incident incident);

	/**
	 * 应急事件的修改
	 * 
	 * @param incident
	 *            Incident实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result updateIncident(Incident incident);

	/**
	 * 应急事件的删除
	 * 
	 * @param incident
	 *            Incident实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result deleteIncident(List<String> list);

	/**
	 * 应急事件的查找
	 * 
	 * @param id
	 *            Incident的编号
	 * @return Incident实例
	 * @author DengBW
	 */
	public Result findIncidentById(String id);

	/**
	 * 应急事件的查找
	 * 
	 * @return List<Incident> Incident集合
	 * @author DengBW
	 */
	public Result getAllIncident();

	/**
	 * 根据应急事件的编号、发生时间区间来查询相应的应急事件
	 * 
	 * @param id
	 *            应急事件编号
	 * @param time1
	 *            应急事件发生时间1
	 * @param time2
	 *            应急事件发生时间2
	 * @return Result
	 */
	public Result findIncidentByTime(String id, Date time1, Date time2);

	/**
	 * 查询历史事件 (只查已结束状态的)
	 * 
	 * @param startTime
	 *            查询的开始时间
	 * @param endTime
	 *            结束的结束时间
	 * @return
	 */
	public Result findHistIncidentByTime(Date startTime, Date endTime);

	/**
	 * 查询事件等级为1、2的且未完成的事件数量。
	 * 
	 * @return
	 */
	public String findIncidentByState();

	public Result sendIncidentToPTIS(List<String> ids);

	public Result getIncidentByQueryBean(QueryBean query);

	/**
	 * 保存公众报料信息
	 * 
	 * @param jsonObj
	 * @author Jerry
	 */
	public void saveUserReportInfo(JSONObject jsonObj);

	public Incident getIncidentForOperationHub(String incidentId);

	public String exportIncident(String incidentNo, String type);
}
