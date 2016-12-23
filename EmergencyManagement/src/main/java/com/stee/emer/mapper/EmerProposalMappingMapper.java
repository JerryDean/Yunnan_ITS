package com.stee.emer.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

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
 * ClassName : EmerProposalMappingMapper
 * </p>
 * <p>
 * Description : This is a EmerProposalMappingMapper interface doing ...
 * </p>
 * <p>
 * Created On :2016-03-30
 * </p>
 *
 * @author lcw
 * @version 1.0
 *
 */
public interface EmerProposalMappingMapper {
	@Insert("INSERT INTO TR_ERS_PROPOSALMAPPING(ID,PROPOSAL_ID,CONTENT_ID ) VALUES (SYS_GUID(),#{proposal_id,jdbcType=VARCHAR},	#{content_id,jdbcType=VARCHAR}	) ")
	public int addProposalRelation(ProposalRelation propMapping);
	@Delete("DELETE TR_ERS_PROPOSALMAPPING  where proposal_id=#{id,jdbcType=VARCHAR}")
	public int deleteProposalRelation(String id);
//	@Update("UPDATE TR_ERS_PROPOSALMAPPING set PROPOSAL_ID=#{proposal_id,jdbcType=VARCHAR},CONTENT_ID=#{content_id,jdbcType=VARCHAR},STATUS=#{status,jdbcType=INTEGER},FLAG='1' )")
//	public int updateProposalRelation(ProposalRelation propMapping);
}
