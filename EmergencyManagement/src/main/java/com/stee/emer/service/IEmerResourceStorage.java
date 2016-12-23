package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.ResourceStorage;

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
 * <p>ClassName   : IEmerResourceStorage </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月25日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface IEmerResourceStorage {

	/**
	 * 添加一条应急资源库信息
	 * @param resourceStorage
	 * @return Result
	 */
	public Result addResourceStorage(ResourceStorage resourceStorage);
	
	/**
	 * 删除一条应急资源库信息
	 * @param id 资源库编号
	 * @return Result
	 */
	public Result deleteResourceStorage(List<String> list);
	
	/**
	 * 修改一条应急资源库信息
	 * @param resourceStorage
	 * @return Result
	 */
	public Result updateResourceStorage(ResourceStorage resourceStorage);
	
	/**
	 * 获取全部的应急资源库信息
	 * @return Result
	 */
	public Result getResourceStorage();
	
	/**
	 * 按照应急资源库的编号获取一条应急资源库信息
	 * @param id 应急资源库编号
	 * @return Result
	 */
	public Result findResourceStorageById(String id);
}
