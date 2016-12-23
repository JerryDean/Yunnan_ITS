package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Proposal;

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
 * ClassName : IEmerProposal
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
public interface IEmerProposal {

	/**
	 * 应急预案的录入(包括对预案关联任务的添加)
	 * 
	 * @param proposal
	 *            Proposal实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result addProposal(Proposal proposal);

	/**
	 * 应急预案的修改(包括对预案相关的任务修改)
	 * 
	 * @param proposal
	 *            Proposal实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result updateProposal(Proposal proposal);

	/**
	 * 应急预案的查找(包含有相关任务信息)
	 * 
	 * @param id
	 *            Proposal的编号
	 * @return Proposal实例
	 * @author DengBW
	 */
	public Result findProposalById(String id);

	/**
	 * 应急预案的查找(包含有相关任务信息)
	 * 
	 * @return List<Proposal> Proposal集合
	 * @author DengBW
	 */
	public Result getAllProposal();

	/**
	 * 通过应急预案的类型、子类型以及等级来获取相应的预案
	 * 
	 * @param type
	 *            应急预案的类型
	 * @param subType
	 *            应急预案的子类型
	 * @param incidentLevel
	 *            应急预案的等级
	 * @return Result
	 */
	public Result findProposalByTAndL(Integer type, Integer subType, Integer incidentLevel);

	/**
	 * 获取预案的管理任务信息
	 * 
	 * @param id
	 * @return
	 */
	public Result findProposalRelationById(String id);

	/**
	 * 删除预案(同时要删除跟他关联的任务信息)
	 * 
	 * @param props
	 * @return
	 */
	public Result deleteProposal(List<String> ids);

	public Result getProposalsByIncidentId(String incidentId);
}
