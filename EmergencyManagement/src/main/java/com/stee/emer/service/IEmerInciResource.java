package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Resource;

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
 * <p>ClassName   : IEmerInciResource </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月7日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface IEmerInciResource {

	/**
	 * 添加一条事件资源信息
	 * @param inciResource
	 * @return Result
	 */
	public Result addInciResource(Inci_Resource inciResource);
	
	/**
	 * 删除事件资源
	 * @param id
	 * @return Result
	 */
	public Result deleteInciResource(List<String> id);
	
	/**
	 * 根据事件资源Id获取事件资源信息
	 * @param id
	 * @return Result
	 */
	public Result findInciResourceById(String id);
	
	/**
	 * 获取全部事件Id的事件资源信息
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllByIncidentId(String incidentId);
	
	/**
	 * 获取全部的事件资源信息
	 * @return Result
	 */
	public Result getAllInciResource();
	
	/**
	 * 修改事件资源信息
	 * @param inciResource
	 * @return Result
	 */
	public Result updateInciResource(Inci_Resource inciResource);
}
