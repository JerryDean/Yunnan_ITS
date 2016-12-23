package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.Inci_Proposal;
import com.stee.emer.entity.Proposal;

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
 * <p>ClassName   : EmerInciProposalMapper </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月7日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface EmerInciProposalMapper {

	public int addInciProposal(Inci_Proposal inciProposal);
	
	public int deleteInciProposal(@Param("id")String id);
	
	public List<Inci_Proposal> getAllInciProposalByIncidentId(@Param("incidentId")String incidentId);
	
	public List<Inci_Proposal> getAllInciProposal();
	
	public Inci_Proposal findInciProposalById(@Param("id")String id);
	
	public int updateInciProposal(Inci_Proposal inciProposal);
	
	public List<Proposal> getAllProposalByTAndL(@Param("incidentLevel")String incidentLevel, @Param("incidentSubType")String incidentSubType);
}
