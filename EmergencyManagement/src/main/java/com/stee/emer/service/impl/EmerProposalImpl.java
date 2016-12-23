package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Incident;
import com.stee.emer.entity.Proposal;
import com.stee.emer.entity.ProposalRelation;
import com.stee.emer.mapper.EmerIncidentMapper;
import com.stee.emer.mapper.EmerProposalMapper;
import com.stee.emer.mapper.EmerProposalMappingMapper;
import com.stee.emer.service.IEmerProposal;
import com.stee.emer.util.GUIDUtils;
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
 * ClassName : EmerProposalImpl
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
@Service
public class EmerProposalImpl implements IEmerProposal {

	@Autowired
	EmerProposalMapper emerProposalMapper;
	@Autowired
	EmerProposalMappingMapper emerProposalMappingMapper;
	@Autowired
	EmerIncidentMapper emerIncidentMapper;

	@Autowired
	@Qualifier("sqlSessionFactory")
	SqlSessionFactoryBean sfb;

	@Override
	public Result addProposal(Proposal proposal) {

		Result result = new Result();
		if (proposal != null) {
			String guid = GUIDUtils.getGUID();
			proposal.setId(guid);

			SqlSessionFactory sf = null;
			SqlSession ss = null;
			int num = -1;
			try {
				sf = sfb.getObject();
				ss = sf.openSession();
				Map<String, Object> parameterMap = new HashMap<>();
				parameterMap.put("type", proposal.getType());
				parameterMap.put("subtype", proposal.getSubtype());
				parameterMap.put("incidentLevel", proposal.getIncidentLevel());
				parameterMap.put("id", proposal.getId());
				parameterMap.put("name", proposal.getName());
				parameterMap.put("description", proposal.getDescription());
				parameterMap.put("generate", proposal.getGenerate());
				parameterMap.put("lastUpdate", proposal.getLastUpdate());
				parameterMap.put("content", proposal.getContent());
				parameterMap.put("state", proposal.getState());
				parameterMap.put("resultNum", -1);
				ss.selectOne("com.stee.emer.mapper.EmerProposalMapper.addProposal", parameterMap);
				num = (int) parameterMap.get("resultNum");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ss.close();
			}
			// 新增调用procedure,避免type、subtype、incidentLevel三值相同。
			// int num = emerProposalMapper.addProposal(proposal);
			// 预案新增的同时 可以为该预案添加相关的任务
			int num1 = 0;
			List<ProposalRelation> propMapping = proposal.getPropMapping();
			for (ProposalRelation prop : propMapping) {
				prop.setProposal_id(guid);
				num1 = emerProposalMappingMapper.addProposalRelation(prop);
			}
			String id = proposal.getId();
			if (num >= 1 && num1 >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(proposal);

			} else if (num == 0) {

				result.setStatusCode(Utils.USER_ALREADY_EXITS);

			} else {
				result.setStatusCode(Utils.FAIL);
			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}
		return result;
	}

	@Override
	public Result updateProposal(Proposal proposal) {

		Result result = new Result();

		if (proposal != null) {
			SqlSessionFactory sf = null;
			SqlSession ss = null;
			int num = -1;
			try {
				sf = sfb.getObject();
				ss = sf.openSession();
				Map<String, Object> parameterMap = new HashMap<>();
				parameterMap.put("type", proposal.getType());
				parameterMap.put("subtype", proposal.getSubtype());
				parameterMap.put("incidentLevel", proposal.getIncidentLevel());
				parameterMap.put("id", proposal.getId());
				parameterMap.put("name", proposal.getName());
				parameterMap.put("description", proposal.getDescription());
				parameterMap.put("generate", proposal.getGenerate());
				parameterMap.put("lastUpdate", proposal.getLastUpdate());
				parameterMap.put("content", proposal.getContent());
				parameterMap.put("state", proposal.getState());
				parameterMap.put("resultNum", -1);
				ss.selectOne("com.stee.emer.mapper.EmerProposalMapper.updateProposal", parameterMap);
				num = (int) parameterMap.get("resultNum");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ss.close();
			}
			int num2 = 0;
			// 更新预案
			// 改用存储过程，以控制 预案匹配条件的原子性。
			// int num = emerProposalMapper.updateProposal(proposal);
			// 先删除预案相关的任务，后对修改的任务进行新增
			emerProposalMappingMapper.deleteProposalRelation(proposal.getId());

			List<ProposalRelation> propMapping = proposal.getPropMapping();
			if (propMapping.size() > 0) {
				for (ProposalRelation propRe : propMapping) {
					num2 = emerProposalMappingMapper.addProposalRelation(propRe);
				}
			}

			if (num >= 1 && num2 >= 1) {

				result.setId(proposal.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(proposal);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}
		return result;
	}

	@Override
	public Result findProposalById(String id) {

		Result result = new Result();

		if (id != null && !"".equals(id)) {

			Proposal proposal = emerProposalMapper.findProposalById(id);
			// if (proposal != null) {
			// 通过预案编号 同时获取对应预案的任务信息放到预案实体注入的propMapping集合属性
			List<ProposalRelation> propRelations = emerProposalMapper.findProposalRelationById(id);
			proposal.setPropMapping(propRelations);

			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(proposal);

			// } else {
			//
			// result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			//
			// }

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result getAllProposal() {

		Result result = new Result();

		List<Proposal> list = emerProposalMapper.getAllProposal();

		if (list != null) {
			for (Proposal prop : list) {
				String proposalId = prop.getId();
				List<ProposalRelation> propRelations = emerProposalMapper.findProposalRelationById(proposalId);
				prop.setPropMapping(propRelations);
			}

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findProposalByTAndL(Integer type, Integer subType, Integer incidentLevel) {

		Result result = new Result();

		if (type == null || "".equals(type)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;
		}

		if (subType == null || "".equals(subType)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;
		}

		if (incidentLevel == null || "".equals(incidentLevel)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;
		}

		List<Proposal> list = emerProposalMapper.findProposalByTAndL(type, subType, incidentLevel);
		if (list.size() > 0) {
			for (Proposal prop : list) {
				String proposalId = prop.getId();
				List<ProposalRelation> propRelations = emerProposalMapper.findProposalRelationById(proposalId);
				prop.setPropMapping(propRelations);
			}
		}

		result.setData(list);
		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

	@Override
	public Result findProposalRelationById(String id) {
		Result result = new Result();
		if (id != null && id != "") {
			Proposal prop = emerProposalMapper.findProposalById(id);
			List<ProposalRelation> propRelations = emerProposalMapper.findProposalRelationById(id);
			prop.setPropMapping(propRelations);
			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(prop);
		} else {
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}
		return result;
	}

	@Override
	public Result deleteProposal(List<String> ids) {
		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> idsList = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (ids.size() != 0) {

			for (String id : ids) {

				int num = emerProposalMapper.deleteProposal(id);
				if (num >= 1) {
					Utils.logger.info("==>deleteProposal( " + id + " )==>SUCCESS");
					int num2 = emerProposalMappingMapper.deleteProposalRelation(id);
					if (num2 >= 1) {
						Utils.logger.info("==>deleteProposalRelation( " + id + " )==>SUCCESS");
					}
					reList.add(id + "::" + Utils.SUCCESS);
					idsList.add(id);

				} else {
					Utils.logger.info("==>deleteProposal( " + id + " )==>FAIL");
					reList.add(id + "::" + Utils.FAIL);
					result.setStatusCode(Utils.FAIL);
				}
			}

			Utils.logger.info(reList);
			result.setData(idsList);

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}
		return result;
	}

	@Override
	public Result getProposalsByIncidentId(String incidentId) {
		Result result = new Result();
		Incident incident = null;
		if (null != incidentId && !incidentId.equals("")) {
			try {
				incident = emerIncidentMapper.findIncidentById(incidentId);
			} catch (Exception e) {
				e.getStackTrace();
				result.setStatusCode(Utils.PARA_EXCEPTION);
			}
		}
		if (null != incident && null != incident.getType() && null != incident.getSubtype()
				&& null != incident.getIncidentLevel()) {
			List<Proposal> props = emerProposalMapper.getProposalsByIncident(incident);
			if (null != props && !props.isEmpty()) {
				result.setData(props);
				result.setStatusCode(Utils.SUCCESS);
			}
		} else {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

}
