package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.ProposalContent;

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
 * <p>ClassName   : IEmerProposalContent </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月23日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface IEmerProposalContent {

	/**
	 * 获取所有的应急预案内容
	 * @return Result
	 */
	public Result getAllProposalContent();
	
	/**
	 * 修改应急预案的内容
	 * @param proposalContent
	 * @return Result
	 */
	public Result updateProposalContent(ProposalContent proposalContent);
	
	/**
	 * 删除应急预案的内容
	 * @param id 应急预案内容Id
	 * @return Result
	 */
	public Result deleteProposalContentById(List<String> list);
	
	/**
	 * 添加一条应急预案内容
	 * @param proposalContent
	 * @return Result
	 */
	public Result addProposalContent(ProposalContent proposalContent);
}
