package com.stee.emer.entity;

import org.apache.ibatis.type.Alias;

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
 * PackageName : com.stee.emer.entity
 * </p>
 * <p>
 * ClassName : ProposalRelation
 * </p>
 * <p>
 * Description : This is a ProposalRelation entity class ...
 * </p>
 * <p>
 * Created On :2016-03-30
 * </p>
 *
 * @author lcw
 * @version 1.0
 *
 */
@Alias("TR_ERS_PROPOSALMAPPING")
public class ProposalRelation {
	private String id;
	private String proposal_id;
	private String content_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProposal_id() {
		return proposal_id;
	}

	public void setProposal_id(String proposal_id) {
		this.proposal_id = proposal_id;
	}

	public String getContent_id() {
		return content_id;
	}

	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}

	public ProposalRelation(String id, String proposal_id, String content_id) {
		super();
		this.id = id;
		this.proposal_id = proposal_id;
		this.content_id = content_id;

	}

	public ProposalRelation() {
		super();
	}

	@Override
	public String toString() {
		return "ProposalMapping [id=" + id + ", proposal_id=" + proposal_id + ", content_id=" + content_id + "]";
	}

}
