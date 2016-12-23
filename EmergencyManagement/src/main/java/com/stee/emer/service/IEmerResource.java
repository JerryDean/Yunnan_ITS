package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Resource;

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
 * ClassName : IEmerResource
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
public interface IEmerResource {

	/**
	 * 应急资源的录入
	 * 
	 * @param resource
	 *            Resource实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result addResource(Resource resource);

	/**
	 * 应急事件的修改
	 * 
	 * @param resource
	 *            Resource实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result updateResource(Resource resource);

	/**
	 * 应急资源的查找
	 * 
	 * @param id
	 *            Resource的编号
	 * @return Resource实例
	 * @author DengBW
	 */
	public Result findResourceById(String id);

	/**
	 * 应急资源的查找
	 * 
	 * @return List<Resource> Resource集合
	 * @author DengBW
	 */
	public Result getAllResource();

	/**
	 * 应急资源的删除
	 * 
	 * @param resource
	 *            Resource实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result deleteResource(List<String> list);
	
	
	/**
	 * 通过资源的类型以及资源的位置来获取相对应的应急资源
	 * @param type 应急资源类型
	 * @param location 应急资源的位置
	 * @return Result
	 */
	public Result findResourceByTAndL(Integer type, String location);
}
