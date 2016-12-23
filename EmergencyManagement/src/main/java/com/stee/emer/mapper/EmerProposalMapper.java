package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.stee.emer.entity.Incident;
import com.stee.emer.entity.Proposal;
import com.stee.emer.entity.ProposalRelation;

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
 * PackageName : com.stee.emer.mapper
 * </p>
 * <p>
 * ClassName : EmerProposalMapper
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
public interface EmerProposalMapper {
	@Delete("DELETE TR_ERS_PROPOSAL WHERE ID = #{id, jdbcType=VARCHAR}")
	public int deleteProposal(String id);

	public int addProposal(Proposal proposal);

	public int updateProposal(Proposal proposal);

	public Proposal findProposalById(String id);

	public List<Proposal> getAllProposal();

	public List<Proposal> findProposalByTAndL(@Param("type") Integer type, @Param("subType") Integer subType,
			@Param("incidentLevel") Integer incidentLevel);

	@Select("SELECT * FROM TR_ERS_PROPOSALMAPPING WHERE PROPOSAL_ID = #{id, jdbcType=VARCHAR} ")
	public List<ProposalRelation> findProposalRelationById(String id);

	@Select("select * from TR_ERS_PROPOSAL WHERE type =#{type, jdbcType=INTEGER} and subtype=#{subtype, jdbcType=INTEGER} and incidentlevel=#{incidentLevel, jdbcType=INTEGER}")
	public List<Proposal> getProposalsByIncident(Incident incident);
}
