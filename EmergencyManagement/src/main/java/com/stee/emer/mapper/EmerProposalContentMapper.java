package com.stee.emer.mapper;

import java.util.List;

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
 * <p>PackageName : com.stee.emer.mapper</p>
 * <p>ClassName   : EmerProposalContentMapper </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月24日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface EmerProposalContentMapper {
	
	public int addProposalContent(ProposalContent proposalContent);

	public List<ProposalContent> getAllProposalContent();
	
	public int updateProposalContent(ProposalContent proposalContent);
	
	public int deleteProposalContentById(String id);
}
