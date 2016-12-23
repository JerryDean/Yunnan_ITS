package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Handle;

/** Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or licence agreement with ST Electronics Info-comm Systems PTE. LTD.
 *
 * Project Name : CCS_ERS_Mgt
 * <p>PackageName : com.stee.emer.service</p>
 * <p>ClassName   : IEmerInciHandle </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月7日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface IEmerInciHandle {

	/**
	 * 添加事件善后信息
	 * @param inciHandle
	 * @return Result
	 */
	public Result addInciHandle(Inci_Handle inciHandle);
	
	/**
	 * 删除事件善后信息
	 * @param id
	 * @return Result
	 */
	public Result deleteInciHandle(List<String> id);
	
	/**
	 * 根据事件Id 获取相关全部事件善后信息
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllInciHandleByIncidentId(String incidentId);
	
	/**
	 * 获取全部事件善后信息
	 * @return Result
	 */
	public Result getAllInciHandle();
	
	/**
	 * 根据事件善后Id 获取事件善后信息
	 * @param id
	 * @return Result
	 */
	public Result findInciHandleById(String id);
	
	/**
	 * 修改事件善后信息
	 * @param inciHandle
	 * @return Result
	 */
	public Result updateInciHandle(Inci_Handle inciHandle);
}
