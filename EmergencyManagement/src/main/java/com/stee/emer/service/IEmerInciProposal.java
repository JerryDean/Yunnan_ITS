package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Proposal;

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
 * <p>ClassName   : IEmerInciProposal </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月7日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface IEmerInciProposal {

	/**
	 * 添加事件预案信息
	 * @param inciProposal
	 * @return Result
	 */
	public Result addInciProposal(Inci_Proposal inciProposal);
	
	/**
	 * 删除事件预案信息
	 * @param id
	 * @return Result
	 */
	public Result deleteInciProposal(List<String> id);
	
	/**
	 * 获取全部事件ID的预案信息
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllInciProposalByIncidentId(String incidentId);
	
	/**
	 * 获取全部事件预案信息
	 * @return Result
	 */
	public Result getAllInciProposal();
	
	/**
	 * 按照事件预案id获取事件预案
	 * @param id
	 * @return Result
	 */
	public Result findInciProposalById(String id);
	
	/**
	 * 修改事件预案信息
	 * @param inciProposal
	 * @return Result
	 */
	public Result updateInciProposal(Inci_Proposal inciProposal);
	
	/**
	 * 初始化（根据事件的等级和子类型 获取预案的内容）
	 * @param incidentLevel 事件等级
	 * @param incidentSubType 事件子类型
	 * @return Result
	 */
	public Result getAllContentByTAndL(String incidentLevel, String incidentSubType);
}
