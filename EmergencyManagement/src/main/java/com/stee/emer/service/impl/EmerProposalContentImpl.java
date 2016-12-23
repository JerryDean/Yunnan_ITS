package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.ProposalContent;
import com.stee.emer.mapper.EmerProposalContentMapper;
import com.stee.emer.service.IEmerProposalContent;
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
 * ClassName : EmerProposalContentImpl
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年2月24日
 * </p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Service
public class EmerProposalContentImpl implements IEmerProposalContent {

	@Autowired
	EmerProposalContentMapper emerProposalContentMapper;

	@Override
	public Result getAllProposalContent() {
		
		Result result = new Result();

		List<ProposalContent> list = emerProposalContentMapper.getAllProposalContent();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result updateProposalContent(ProposalContent proposalContent) {


		Result result = new Result();
		
		if(proposalContent != null) {
			
			int num = emerProposalContentMapper.updateProposalContent(proposalContent);
			
			if(num >= 1) {
				
				result.setId(proposalContent.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(proposalContent);
				
			}else{
				
				result.setStatusCode(Utils.FAIL);
				
			}
			
		}else{
			
			result.setStatusCode(Utils.PARA_EXCEPTION);			
		}
		
		
		return result;
		
	}

	@Override
	public Result deleteProposalContentById(List<String> list) {

		Result result = new Result();
		
		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();
		
		result.setStatusCode(Utils.SUCCESS);
		
		if(list.size() != 0) {
			
			for(String id : list) {
				
				int num = emerProposalContentMapper.deleteProposalContentById(id);
				
				if(num >= 1) {
					
					reList.add(id+"::"+Utils.SUCCESS);
					ids.add(id);
					
				}else{
					
					reList.add(id+"::"+Utils.FAIL);
					result.setStatusCode(Utils.FAIL);
					
				}
				
			}
			Utils.logger.info(reList);
			result.setData(ids);
			
		}else{
			
			result.setStatusCode(Utils.PARA_EXCEPTION);
			
		}
		
		return result;
		
	}

	@Override
	public Result addProposalContent(ProposalContent proposalContent) {
		
		Result result = new Result();
		
		if(proposalContent != null) {
			
			int num = emerProposalContentMapper.addProposalContent(proposalContent);
			String id = proposalContent.getId();
			
			if(num >= 1 && id != null && !"".equals(id)) {
				
				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(proposalContent);
				
			}else{
				
				result.setStatusCode(Utils.FAIL);
				
			}
		}else{
			
			result.setStatusCode(Utils.PARA_EXCEPTION);
			
		}
		
		return result;
		
	}
	
	

}
