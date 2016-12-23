package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Person;

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
 * <p>ClassName   : IEmerInciPerson </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月8日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface IEmerInciPerson {
	/**
	 * 添加一条事件人员信息
	 * @param inciPerson
	 * @return Result
	 */
	public Result addInciPerson(Inci_Person inciPerson);
	
	/**
	 * 删除事件人员信息
	 * @param id
	 * @return Result
	 */
	public Result deleteInciPerson(List<String> id);
	
	/**
	 * 获取全部事件人员信息
	 * @return Result
	 */
	public Result getAllInciPerson();
	
	/**
	 * 根据事件Id 获取相关的事件人员信息
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllInciPersonByIncidentId(String incidentId);
	
	/**
	 * 根据事件人员ID 获取相应的事件人员信息
	 * @param id
	 * @return Result
	 */
	public Result findInciPersonById(String id);
	
	/**
	 * 修改一条事件人员信息
	 * @param inciPerson
	 * @return Result
	 */
	public Result updateInciPerson(Inci_Person inciPerson);
}
