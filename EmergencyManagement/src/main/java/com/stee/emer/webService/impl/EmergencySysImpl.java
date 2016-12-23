package com.stee.emer.webService.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.stee.dsms.model.Result;
import com.stee.dsms.properties.PropertyConfigurer;
import com.stee.emer.entity.AttachmentFile;
import com.stee.emer.entity.CmsEvent;
import com.stee.emer.entity.Inci_Handle;
import com.stee.emer.entity.Inci_Person;
import com.stee.emer.entity.Inci_Proposal;
import com.stee.emer.entity.Inci_Resource;
import com.stee.emer.entity.Incident;
import com.stee.emer.entity.IncidentLog;
import com.stee.emer.entity.LedInfo;
import com.stee.emer.entity.PreAlarmAction;
import com.stee.emer.entity.PreAlarmInfo;
import com.stee.emer.entity.PreAlarmNoticeOrganization;
import com.stee.emer.entity.Proposal;
import com.stee.emer.entity.ProposalContent;
import com.stee.emer.entity.QueryBean;
import com.stee.emer.entity.Resource;
import com.stee.emer.entity.ResourceStorage;
import com.stee.emer.entity.Troops;
import com.stee.emer.entity.TroopsResource;
import com.stee.emer.mapper.EmerIncidentMapper;
import com.stee.emer.mapper.EmerLedMapper;
import com.stee.emer.service.IEmerAttachment;
import com.stee.emer.service.IEmerInciHandle;
import com.stee.emer.service.IEmerInciPerson;
import com.stee.emer.service.IEmerInciProposal;
import com.stee.emer.service.IEmerInciResource;
import com.stee.emer.service.IEmerIncident;
import com.stee.emer.service.IEmerLed;
import com.stee.emer.service.IEmerPreAlarm;
import com.stee.emer.service.IEmerProposal;
import com.stee.emer.service.IEmerProposalContent;
import com.stee.emer.service.IEmerResource;
import com.stee.emer.service.IEmerResourceStorage;
import com.stee.emer.service.IEmerSMS;
import com.stee.emer.service.IEmerTroops;
import com.stee.emer.util.Utils;
import com.stee.emer.webService.IEmergencySys;

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
 * PackageName : com.stee.emer.webService.impl
 * </p>
 * <p>
 * ClassName : EmergencySysImpl
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
@WebService(endpointInterface = "com.stee.emer.webService.IEmergencySys")
@Component("EmergencySys")
public class EmergencySysImpl implements IEmergencySys {
	@Autowired
	IEmerAttachment emerAttachment;

	@Autowired
	IEmerTroops emerTroops;

	@Autowired
	IEmerIncident emerIncident;

	@Autowired
	IEmerResource emerResource;

	@Autowired
	IEmerProposal emerProposal;

	@Autowired
	IEmerProposalContent emerProposalContent;

	@Autowired
	IEmerResourceStorage emerResourceStorage;

	@Autowired
	IEmerInciProposal emerInciProposal;

	@Autowired
	IEmerInciResource emerInciResource;

	@Autowired
	IEmerInciHandle emerInciHandle;

	@Autowired
	IEmerInciPerson emerInciPerson;

	@Autowired
	IEmerPreAlarm emerPreAlarm;

	@Autowired
	IEmerSMS emerSms;

	@Autowired
	IEmerLed led;

	@Autowired
	EmerIncidentMapper emerIncidentMapper;

	@Autowired
	EmerLedMapper emerLedMapper;

	/* ********************Incident*********************** */
	public Result addIncident(Incident incident) {

		Result result = null;
		try {
			if (null != incident) {
				String desc = incident.getIncidentDesc();
				String other = incident.getOther();
				if (!Strings.isNullOrEmpty(desc)) {
					String temp1 = subStr(desc, "\r", "。");
					incident.setIncidentDesc(subStr(temp1, "\n", "。"));
				}
				if (!Strings.isNullOrEmpty(other)) {
					String temp1 = subStr(other, "\r", "。");
					incident.setOther(subStr(temp1, "\n", "。"));
				}
			}
			if (null != incident.getCarModule() && !incident.getCarModule().isEmpty()) {
				incident.setCarModuleStr(ListToStr(incident.getCarModule()));
			}
			result = emerIncident.addIncident(incident);

		} catch (Exception e) {

			Utils.logger.error(e.getMessage());
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	/**
	 * String集合转String
	 * <p>
	 * ‘，’分隔
	 * 
	 * @param listStr
	 * @return
	 * @author Jerry
	 */
	private String ListToStr(List<String> listStr) {
		if (null == listStr || listStr.isEmpty()) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (String str : listStr) {
			stringBuilder.append(str + ",");
		}
		return stringBuilder.toString().substring(0, stringBuilder.toString().lastIndexOf(","));
	}

	/**
	 * String 转化至 List<String>
	 * <p>
	 * String元素之间以","分隔
	 * 
	 * @param str
	 * @return
	 * @author Jerry
	 */
	private List<String> str2List(String str) {
		if (null == str || str.equals("")) {
			return null;
		}
		List<String> list = new LinkedList<>();
		String[] strs = str.split(",");
		for (String string : strs) {
			list.add(string);
		}
		return list;
	}

	private String subStr(String source, String reg, String replace) {
		int index = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while (source.indexOf(reg, index + 1) != -1) {
			stringBuilder
					.append(source.substring(index == 0 ? index : index + 1, source.indexOf(reg, index + 1)) + replace);
			index = source.indexOf(reg, index + 1);
		}
		return stringBuilder.toString()
				+ (stringBuilder.length() == 0 ? source.substring(index) : source.substring(index + 1));
	}

	public Result updateIncident(Incident incident) {

		Result result = null;

		try {
			Utils.setIncident(incident);
			if (null != incident) {
				String desc = incident.getIncidentDesc();
				String other = incident.getOther();
				if (!Strings.isNullOrEmpty(desc)) {
					String temp1 = subStr(desc, "\r", "。");
					incident.setIncidentDesc(subStr(temp1, "\n", "。"));
				}
				if (!Strings.isNullOrEmpty(other)) {
					String temp1 = subStr(other, "\r", "。");
					incident.setOther(subStr(temp1, "\n", "。"));
				}
			}
			if (null != incident.getCarModule() && !incident.getCarModule().isEmpty()) {
				incident.setCarModuleStr(ListToStr(incident.getCarModule()));
			}
			result = emerIncident.updateIncident(incident);
		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}
		return result;
	}

	public Result deleteIncident(List<String> list) {

		Result result = null;

		try {
			StringBuilder sb = new StringBuilder();
			if (null != list && !list.isEmpty()) {
				for (String s : list) {
					sb.append(s + ",");
				}
				Utils.objectId = sb.toString().substring(0, sb.toString().lastIndexOf(","));
			}
			result = emerIncident.deleteIncident(list);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result findIncidentById(String id) {

		Result result = null;

		try {
			if (null != id) {
				Utils.objectId = id;
			}
			result = emerIncident.findIncidentById(id);
			if (result.getUniqueObject() != null) {
				Incident incident = result.getUniqueObject();
				if (null != incident.getCarModuleStr() && !incident.getCarModuleStr().equals("")) {
					incident.setCarModule(str2List(incident.getCarModuleStr()));
					result.setUniqueData(incident);
				}
			}
		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	public Result getAllIncident() {

		Result result = null;

		try {

			result = emerIncident.getAllIncident();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result findIncidentByTime(String id, Date time1, Date time2) {

		Result result = null;

		try {
			if (null != id) {
				Utils.objectId = id;
			}
			result = emerIncident.findIncidentByTime(id, time1, time2);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	/* ********************Resource*********************** */
	public Result addResource(Resource resource) {

		Result result = null;

		try {

			result = emerResource.addResource(resource);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result updateResource(Resource resource) {

		Result result = null;

		try {

			result = emerResource.updateResource(resource);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result findResourceById(String id) {

		Result result = null;

		try {

			result = emerResource.findResourceById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result getAllResource() {

		Result result = null;

		try {

			result = emerResource.getAllResource();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result deleteResource(List<String> list) {

		Result result = null;

		try {

			result = emerResource.deleteResource(list);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result findResourceByTAndL(Integer type, String location) {

		Result result = null;

		try {

			result = emerResource.findResourceByTAndL(type, location);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	/* ********************Proposal*********************** */
	public Result addProposal(Proposal proposal) {

		Result result = null;

		try {

			result = emerProposal.addProposal(proposal);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result updateProposal(Proposal proposal) {

		Result result = null;

		try {

			result = emerProposal.updateProposal(proposal);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteProposal(List<String> ids) {
		Result result = null;
		try {

			result = emerProposal.deleteProposal(ids);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	public Result findProposalById(String id) {

		Result result = null;

		try {

			result = emerProposal.findProposalById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result getAllProposal() {

		Result result = null;

		try {

			result = emerProposal.getAllProposal();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	public Result findProposalByTAndL(Integer type, Integer subType, Integer incidentLevel) {

		Result result = null;

		try {

			result = emerProposal.findProposalByTAndL(type, subType, incidentLevel);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result getAllProposalContent() {

		Result result = null;

		try {

			result = emerProposalContent.getAllProposalContent();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result updateProposalContent(ProposalContent proposalContent) {

		Result result = null;

		try {

			result = emerProposalContent.updateProposalContent(proposalContent);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result deleteProposalContentById(List<String> list) {

		Result result = null;

		try {

			result = emerProposalContent.deleteProposalContentById(list);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result addProposalContent(ProposalContent proposalContent) {

		Result result = null;

		try {

			result = emerProposalContent.addProposalContent(proposalContent);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result addResourceStorage(ResourceStorage resourceStorage) {

		Result result = null;

		try {

			result = emerResourceStorage.addResourceStorage(resourceStorage);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteResourceStorage(List<String> list) {

		Result result = null;

		try {

			result = emerResourceStorage.deleteResourceStorage(list);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result updateResourceStorage(ResourceStorage resourceStorage) {

		Result result = null;

		try {

			result = emerResourceStorage.updateResourceStorage(resourceStorage);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getResourceStorage() {
		Result result = null;

		try {

			result = emerResourceStorage.getResourceStorage();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findResourceStorageById(String id) {

		Result result = null;

		try {

			result = emerResourceStorage.findResourceStorageById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result addInciProposal(Inci_Proposal inciProposal) {

		Result result = null;

		try {

			result = emerInciProposal.addInciProposal(inciProposal);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteInciProposal(List<String> id) {
		Result result = null;

		try {

			result = emerInciProposal.deleteInciProposal(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciProposalByIncidentId(String incidentId) {
		Result result = null;

		try {

			result = emerInciProposal.getAllInciProposalByIncidentId(incidentId);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciProposal() {
		Result result = null;

		try {

			result = emerInciProposal.getAllInciProposal();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findInciProposalById(String id) {
		Result result = null;

		try {

			result = emerInciProposal.findInciProposalById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result updateInciProposal(Inci_Proposal inciProposal) {
		Result result = null;

		try {

			result = emerInciProposal.updateInciProposal(inciProposal);

		} catch (Exception e) {
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}

		return result;
	}

	public Result getAllContentByTAndL(String incidentLevel, String incidentSubType) {
		Result result = null;

		try {

			result = emerInciProposal.getAllContentByTAndL(incidentLevel, incidentSubType);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;

	}

	@Override
	public Result addInciResource(Inci_Resource inciResource) {
		Result result = null;

		try {

			result = emerInciResource.addInciResource(inciResource);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteInciResource(List<String> id) {
		Result result = null;

		try {

			result = emerInciResource.deleteInciResource(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findInciResourceById(String id) {
		Result result = null;

		try {

			result = emerInciResource.findInciResourceById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllByIncidentId(String incidentId) {
		Result result = null;

		try {

			result = emerInciResource.getAllByIncidentId(incidentId);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciResource() {
		Result result = null;

		try {

			result = emerInciResource.getAllInciResource();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result updateInciResource(Inci_Resource inciResource) {
		Result result = null;

		try {

			result = emerInciResource.updateInciResource(inciResource);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result addInciHandle(Inci_Handle inciHandle) {
		Result result = null;

		try {

			result = emerInciHandle.addInciHandle(inciHandle);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteInciHandle(List<String> id) {
		Result result = null;

		try {

			result = emerInciHandle.deleteInciHandle(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciHandleByIncidentId(String incidentId) {
		Result result = null;

		try {

			result = emerInciHandle.getAllInciHandleByIncidentId(incidentId);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciHandle() {
		Result result = null;

		try {

			result = emerInciHandle.getAllInciHandle();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findInciHandleById(String id) {
		Result result = null;

		try {

			result = emerInciHandle.findInciHandleById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result updateInciHandle(Inci_Handle inciHandle) {
		Result result = null;

		try {

			result = emerInciHandle.updateInciHandle(inciHandle);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result addInciPerson(Inci_Person inciPerson) {

		Result result = null;

		try {

			result = emerInciPerson.addInciPerson(inciPerson);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteInciPerson(List<String> id) {

		Result result = null;

		try {

			result = emerInciPerson.deleteInciPerson(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciPerson() {

		Result result = null;

		try {

			result = emerInciPerson.getAllInciPerson();

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciPersonByIncidentId(String incidentId) {

		Result result = null;

		try {

			result = emerInciPerson.getAllInciPersonByIncidentId(incidentId);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findInciPersonById(String id) {

		Result result = null;

		try {

			result = emerInciPerson.findInciPersonById(id);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result updateInciPerson(Inci_Person inciPerson) {

		Result result = null;

		try {

			result = emerInciPerson.updateInciPerson(inciPerson);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findHistIncidentByTime(Date startTime, Date endTime) {
		Result result = null;

		try {

			result = emerIncident.findHistIncidentByTime(startTime, endTime);

		} catch (Exception e) {

			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result addPreAlarmInfo(PreAlarmInfo preAlarmInfo) {
		Result result = null;
		try {
			result = emerPreAlarm.addPreAlarmInfo(preAlarmInfo);
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result getAllPreAlarmInfo() {
		Result result = null;
		try {
			result = emerPreAlarm.getAllPreAlarmInfo();
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result findPreAlarmInfoById(String id) {
		Result result = null;
		try {
			result = emerPreAlarm.findPreAlarmInfoById(id);
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result addNoticeOrganizations(List<PreAlarmNoticeOrganization> orgs) {
		Result result = null;
		try {
			result = emerPreAlarm.addNoticeOrganizations(orgs);
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result updateNoticeOrganization(PreAlarmNoticeOrganization org) {
		Result result = null;
		try {
			result = emerPreAlarm.updateNoticeOrganization(org);
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(org.getOrganizationId());
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result addPreAlarmAction(PreAlarmAction action) {
		Result result = null;
		try {
			result = emerPreAlarm.addPreAlarmAction(action);
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result updatePreAlarmAction(PreAlarmAction action) {
		Result result = null;
		try {
			result = emerPreAlarm.updatePreAlarmAction(action);
		} catch (Exception e) {
			Utils.logger.error(e);
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result sendSMSMessageInstantly(String number, String content) {
		Result result = null;
		try {
			result = emerSms.sendSMSMessageInstantly(number, content);
		} catch (Exception e) {
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result sendSMSMessageInterval(String number, String content, Date date) {
		Result result = null;
		try {
			result = emerSms.sendSMSMessageInterval(number, content, date);
		} catch (Exception e) {
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result sendIncidentToPTIS(List<String> ids) {
		Result result = null;
		try {
			result = emerIncident.sendIncidentToPTIS(ids);
		} catch (Exception e) {
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result getProposalsByIncidentId(String incidentId) {
		Result result = null;
		try {
			result = emerProposal.getProposalsByIncidentId(incidentId);
		} catch (Exception e) {
			result = new Result();
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public String pushCMSEventList(List<CmsEvent> cmsEvents) {
		Utils.logger.info(cmsEvents);
		if (PropertyConfigurer.getContextProperty("ERS.callcenter.flag").toString().equals("0")) {
			return "000000";
		}
		try {
			for (CmsEvent o : cmsEvents) {
				emerIncidentMapper.addCmsEvent(o);
				// Incident incident = new Incident();
				// incident.setRoad(o.getRoadName());
				// incident.setPoint(o.getRoadStakeNo());
				// incident.setX(o.getLocationLongitude());
				// incident.setY(o.getLocationLatidude());
				// Integer direction = null;
				// switch (o.getRoadDirection()) {
				// case "上行":
				// direction = 1;
				// break;
				// case "下行":
				// direction = 2;
				// break;
				// case "双向":
				// direction = 3;
				// break;
				// default:
				// direction = Integer.parseInt(o.getRoadDirection());
				// }
				// incident.setOrientation(direction);
				// incident.setAddress(o.getLocation());
				// incident.setIncidentDesc("事主姓名:" + o.getCallerName() +
				// ",事主来电电话号码:" + o.getCallerPhoneNo()
				// + ",事主联系电话号码:" + o.getCallerContactPhoneNo() + ",事主车牌号:" +
				// o.getCallerVehiclePlateNo() + ",事件："
				// + o.getEventDescription());
				// Date date = new Date(System.currentTimeMillis());
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				// String dateStr = sdf.format(date);
				// String[] dateArray = dateStr.split("-");
				// StringBuilder sb = new StringBuilder();
				// for (int i = 0; i < dateArray.length; i++) {
				// sb.append(dateArray[i]);
				// }
				// incident.setIncidentNo(sb.toString());
				// emerIncidentMapper.addIncident(incident);
			}
		} catch (Exception e) {
			return "999999";
		}

		return "000000";
	}

	@Override
	public String getObjectIdForOperationHub() {
		return Utils.objectId;
	}

	@Override
	public String getFlowStatus() {
		return Utils.incidentStatus;
	}

	@Override
	public Incident putIncidentToOperationHub() {
		return Utils.getIncident();
	}

	@Override
	public Result getIncidentByQueryBean(QueryBean query) {
		return emerIncident.getIncidentByQueryBean(query);
	}

	@Override
	public Result addAttachmentFile(AttachmentFile file) {
		return emerAttachment.addAttachmentFile(file);
	}

	@Override
	public Result updateAttachmentFile(AttachmentFile file) {
		return emerAttachment.updateAttachmentFile(file);
	}

	@Override
	public Result deleteAttachmentFileByIds(List<String> ids) {
		return emerAttachment.deleteAttachmentFileByIds(ids);
	}

	@Override
	public Result getAttachmentFileInfoByIncidentId(String id) {
		return emerAttachment.getAttachmentFileInfoByIncidentId(id);
	}

	@Override
	public Result findAttachmentFileContentByInfoId(String id) {
		return emerAttachment.findAttachmentFileContentByInfoId(id);
	}

	@Override
	public Result deleteAttachmentFileByIncidentId(String id) {
		return emerAttachment.deleteAttachmentFileByIncidentId(id);
	}

	@Override
	public Result addTroops(Troops team) {
		return emerTroops.addTroops(team);
	}

	@Override
	public Result updateTroops(Troops team) {
		return emerTroops.updateTroops(team);
	}

	@Override
	public Result deleteTroops(List<String> ids) {
		return emerTroops.deleteTroops(ids);
	}

	@Override
	public Result deleteTroopsByIncidentId(String id) {
		return emerTroops.deleteTroopsByIncidentId(id);
	}

	@Override
	public Result getTroopsByIncidentId(String id) {
		return emerTroops.getTroopsByIncidentId(id);
	}

	@Override
	public Result findTroopsById(String id) {
		return emerTroops.findTroopsById(id);
	}

	@Override
	public Incident getIncidentForOperationHub(String incidentId) {
		return emerIncident.getIncidentForOperationHub(incidentId);
	}

	@Override
	public Result getHisPreAlarmInfoByTime(Date startTime, Date endTime) {
		return emerPreAlarm.getHisPreAlarmInfoByTime(startTime, endTime);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result pushIncidentToLed(String incidentId, String instutationId, boolean isStop) {
		Result result = led.pushIncidentToLed(incidentId, instutationId, isStop);
		List<IncidentLog> list = new ArrayList<>();
		if (null != result.getData() && !result.getData().isEmpty()) {
			list = result.getData();
		}
		if (null == list || list.isEmpty()) {
			if (isStop) {
				List<LedInfo> info = emerLedMapper.getByInstutationId(instutationId);
				for (LedInfo ledInfo : info) {
					String ip = ledInfo.getIp();
					String deviceId = ledInfo.getDeviceId();
					String type = "上海三思";
					sendLogToLed(ip, deviceId, type, null);
				}
			}
			return result;
		}
		List<LedInfo> info = emerLedMapper.findById(incidentId);
		for (LedInfo ledInfo : info) {
			if (ledInfo.getFlag() == 1) {
				continue;
			}
			String ip = ledInfo.getIp();
			String deviceId = ledInfo.getDeviceId();
			String type = "上海三思";
			sendLogToLed(ip, deviceId, type, list);
		}
		return result;
	}

	@Override
	public Result updatePreAlarmInfo(PreAlarmInfo preAlarmInfo) {
		return emerPreAlarm.updatePreAlarmInfo(preAlarmInfo);
	}

	@Override
	public Result getAllTroops() {
		return emerTroops.getAllTroops();
	}

	@Override
	public void notifyEmerToUpdateLed(List<String> ids) {
		for (String id : ids) {
			try {
				List<LedInfo> info = emerLedMapper.findById(id);
				if (null == info || info.isEmpty()) {
					continue;
				} else {
					List<IncidentLog> list = emerLedMapper.getLogsByIncidentId(id);
					for (LedInfo ledInfo : info) {
						if (ledInfo.getFlag() == 1) {
							continue;
						}
						String ip = ledInfo.getIp();
						String deviceId = ledInfo.getDeviceId();
						String type = "上海三思";
						sendLogToLed(ip, deviceId, type, list);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 发送日志到LED.
	 * 
	 * @param ip
	 * @param deviceId
	 * @param deviceType
	 * @param list
	 * @author Jerry
	 */
	public String sendLogToLed(String ip, String deviceId, String deviceType, List<IncidentLog> list) {
		LedMessage message = new LedMessage();
		message.setEqtId(deviceId);
		message.setEqtIp(ip);
		message.setSbxh(deviceType);

		if (null == list) {
			message.setStrVmsMessage("");
		} else {
			Collections.sort(list, new Comparator<IncidentLog>() {

				@Override
				public int compare(IncidentLog o1, IncidentLog o2) {
					return o2.getEndDate().compareTo(o1.getEndDate());
				}
			});

			StringBuilder stringBuilder = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (IncidentLog incidentLog : list) {
				stringBuilder.append(sdf.format(incidentLog.getEndDate()) + "," + incidentLog.getContent() + ";");
			}
			message.setStrVmsMessage(stringBuilder.toString());
		}

		StringWriter sw = new StringWriter();
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(sw, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String code = led.updateVmsCurrentMessage(sw.toString());
		Utils.logger.info("Invoke vms service:" + code);
		return code;
	}

	class LedMessage {
		private String eqtIp;

		private String eqtId;

		private String sbxh;

		private String strVmsMessage;

		public String getEqtIp() {
			return eqtIp;
		}

		public void setEqtIp(String eqtIp) {
			this.eqtIp = eqtIp;
		}

		public String getEqtId() {
			return eqtId;
		}

		public void setEqtId(String eqtId) {
			this.eqtId = eqtId;
		}

		public String getSbxh() {
			return sbxh;
		}

		public void setSbxh(String sbxh) {
			this.sbxh = sbxh;
		}

		public String getStrVmsMessage() {
			return strVmsMessage;
		}

		public void setStrVmsMessage(String strVmsMessage) {
			this.strVmsMessage = strVmsMessage;
		}

		@Override
		public String toString() {
			return "LedMessage [eqtIp=" + eqtIp + ", eqtId=" + eqtId + ", sbxh=" + sbxh + ", strVmsMessage="
					+ strVmsMessage + "]";
		}

	}

	@Override
	public Result deletePreAlarmActionById(String id) {
		return emerPreAlarm.deletePreAlarmActionById(id);
	}

	@Override
	public Result addTroopsResource(TroopsResource resource) {
		return emerTroops.addTroopsResource(resource);
	}

	@Override
	public Result deleteTroopsResource(Integer id) {
		return emerTroops.deleteTroopsResource(id);
	}

	@Override
	public Result findTroopsResourceByTroopsId(String id) {
		return emerTroops.findTroopsResourceByTroopsId(id);
	}

	@Override
	public Result updateTroopsResource(TroopsResource resource) {
		return emerTroops.updateTroopsResource(resource);
	}

	@Override
	public byte[] downloadAttachById(String id) {
		return emerAttachment.downloadAttachById(id);
	}

	@Override
	public String exportIncident(String incidentNo, String type) {
		return emerIncident.exportIncident(incidentNo, type);
	}

	// @Override
	// public Result findProposalAndContentById(String id) {
	// Result result =null;
	// try {
	//
	// result = emerProposal.findProposalRelationById(id);
	//
	// } catch (Exception e) {
	//
	// Utils.logger.error(e);
	// result = new Result();
	// result.setId(null);
	// result.setUniqueData(e.getMessage());
	// result.setStatusCode(Utils.FAIL);
	//
	// }
	//
	// return result;
	// }
	//
	//

}
