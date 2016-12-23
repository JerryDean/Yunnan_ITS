package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Proposal;
import com.stee.emer.entity.Proposal;
import com.stee.emer.mapper.EmerInciProposalMapper;
import com.stee.emer.service.IEmerInciProposal;
import com.stee.emer.util.Utils;

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
 * PackageName : com.stee.emer.service.impl
 * </p>
 * <p>
 * ClassName : EmerInciProposalImpl
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年3月7日
 * </p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Service
public class EmerInciProposalImpl implements IEmerInciProposal {

	@Autowired
	EmerInciProposalMapper emerInciProposalMapper;

	@Override
	public Result addInciProposal(Inci_Proposal inciProposal) {

		Result result = new Result();

		if (inciProposal != null) {

			int num = emerInciProposalMapper.addInciProposal(inciProposal);
			String id = inciProposal.getId();

			if (num >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(inciProposal);

			} else {

				result.setStatusCode(Utils.FAIL);

			}
		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;

	}

	@Override
	public Result deleteInciProposal(List<String> id) {

		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (id.size() != 0) {

			for (String idnum : id) {

				int num = emerInciProposalMapper.deleteInciProposal(idnum);
				if (num >= 1) {

					reList.add(idnum + "::" + Utils.SUCCESS);
					ids.add(idnum);

				} else {

					reList.add(idnum + "::" + Utils.FAIL);
					result.setStatusCode(Utils.FAIL);

				}

			}
			Utils.logger.info(reList);
			result.setData(ids);

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result getAllInciProposalByIncidentId(String incidentId) {

		Result result = new Result();

		List<Inci_Proposal> list = emerInciProposalMapper.getAllInciProposalByIncidentId(incidentId);

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciProposal() {

		Result result = new Result();

		List<Inci_Proposal> list = emerInciProposalMapper.getAllInciProposal();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findInciProposalById(String id) {

		Result result = new Result();

		if (!"".equals(id) && id != null) {

			Inci_Proposal inciProposal = emerInciProposalMapper.findInciProposalById(id);

			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(inciProposal);

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result updateInciProposal(Inci_Proposal inciProposal) {

		Result result = new Result();

		if (inciProposal != null) {

			int num = emerInciProposalMapper.updateInciProposal(inciProposal);

			if (num >= 1) {

				result.setId(inciProposal.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(inciProposal);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);
		}

		return result;
	}

	@Override
	public Result getAllContentByTAndL(String incidentLevel, String incidentSubType) {

		Result result = new Result();

		if (incidentLevel == null || "".equals(incidentLevel)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);

			return result;

		}

		if (incidentSubType == null || "".equals(incidentSubType)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);

			return result;

		}
		
		List<Proposal> proposals = emerInciProposalMapper.getAllProposalByTAndL(incidentLevel, incidentSubType);
		
		List<String> content = new ArrayList<String>();
		
		for(Proposal proposal : proposals) {
			
			content.add(proposal.getContent());
			
		}
		
		result.setData(content);
		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

}
