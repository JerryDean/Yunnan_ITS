package com.stee.emer.webService;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.AttachmentFile;
import com.stee.emer.entity.AttachmentFileContent;
import com.stee.emer.entity.AttachmentFileInfo;
import com.stee.emer.entity.CmsEvent;
import com.stee.emer.entity.Inci_Handle;
import com.stee.emer.entity.Inci_Person;
import com.stee.emer.entity.Inci_Proposal;
import com.stee.emer.entity.Inci_Resource;
import com.stee.emer.entity.Incident;
import com.stee.emer.entity.IncidentLog;
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
 * PackageName : com.stee.emer.webService
 * </p>
 * <p>
 * ClassName : IEmergencySyspush
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

@WebService
@XmlSeeAlso({ AttachmentFileInfo.class, AttachmentFileContent.class, IncidentLog.class })
public interface IEmergencySys {

	/* ********************Incident*********************** */
	/**
	 * 应急事件的录入
	 * 
	 * @param incident
	 *            Incident实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result addIncident(Incident incident);

	/**
	 * 应急事件的修改
	 * 
	 * @param incident
	 *            Incident实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result updateIncident(Incident incident);

	/**
	 * 应急事件的删除
	 * 
	 * @param incident
	 *            Incident实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result deleteIncident(List<String> list);

	/**
	 * 应急事件的查找
	 * 
	 * @param id
	 *            Incident的编号
	 * @return Result实例
	 * @author DengBW
	 */
	public Result findIncidentById(String id);

	/**
	 * 应急事件的查找
	 * 
	 * @return List<Incident> Incident集合
	 * @author DengBW
	 */
	public Result getAllIncident();

	/**
	 * 根据应急事件的编号、发生时间区间来查询相应的应急事件
	 * 
	 * @param id
	 *            应急事件编号
	 * @param time1
	 *            应急事件发生时间1
	 * @param time2
	 *            应急事件发生时间2
	 * @return Result
	 */
	public Result findIncidentByTime(String id, Date time1, Date time2);

	public Result findHistIncidentByTime(Date startTime, Date endTime);

	/**
	 * 通过QueryBean封装查询属性，获取符合事件集合。
	 * 
	 * @param query
	 * @return
	 * @author Jerry
	 */
	public Result getIncidentByQueryBean(QueryBean query);

	/* ********************Resource*********************** */

	/**
	 * 应急资源的录入
	 * 
	 * @param resource
	 *            Resource实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result addResource(Resource resource);

	/**
	 * 应急资源的修改
	 * 
	 * @param resource
	 *            Resource实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result updateResource(Resource resource);

	/**
	 * 应急资源的查找
	 * 
	 * @param id
	 *            StorageId
	 * @return Result实例
	 * @author DengBW
	 */
	public Result findResourceById(String id);

	/**
	 * 应急资源的查找
	 * 
	 * @return List<Resource> Resource集合
	 * @author DengBW
	 */
	public Result getAllResource();

	/**
	 * 应急资源的删除
	 * 
	 * @param resource
	 *            Resource实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result deleteResource(List<String> list);

	/**
	 * 通过资源的类型以及资源的位置来获取相对应的应急资源
	 * 
	 * @param type
	 *            应急资源类型
	 * @param location
	 *            应急资源的位置
	 * @return Result
	 */
	public Result findResourceByTAndL(Integer type, String location);

	/* ********************Proposal*********************** */

	/**
	 * 应急预案的录入
	 * 
	 * @param proposal
	 *            Proposal实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result addProposal(Proposal proposal);

	/**
	 * 应急预案的修改
	 * 
	 * @param proposal
	 *            Proposal实例
	 * @return Result 结果实例
	 * @author DengBW
	 */
	public Result updateProposal(Proposal proposal);

	/**
	 * 删除预案(同时删除关联的任务信息)
	 * 
	 * @param id
	 * @return
	 */
	public Result deleteProposal(List<String> ids);

	/**
	 * 应急预案的查找
	 * 
	 * @param id
	 *            Proposal的编号
	 * @return Result实例
	 * @author DengBW
	 */
	public Result findProposalById(String id);

	/**
	 * 应急预案的查找
	 * 
	 * @return List<Proposal> Proposal集合
	 * @author DengBW
	 */
	public Result getAllProposal();

	/**
	 * 通过应急预案的类型、子类型以及等级来获取相应的预案
	 * 
	 * @param type
	 *            应急预案的类型
	 * @param subType
	 *            应急预案的子类型
	 * @param incidentLevel
	 *            应急预案的等级
	 * @return Result
	 */
	public Result findProposalByTAndL(Integer type, Integer subType, Integer incidentLevel);

	/**
	 * 获取所有的应急预案内容
	 * 
	 * @return Result
	 */
	public Result getAllProposalContent();

	/**
	 * 修改应急预案的内容
	 * 
	 * @param proposalContent
	 * @return Result
	 */
	public Result updateProposalContent(ProposalContent proposalContent);

	/**
	 * 删除应急预案的内容
	 * 
	 * @param id
	 *            应急预案内容Id
	 * @return Result
	 */
	public Result deleteProposalContentById(List<String> list);

	/**
	 * 添加一条应急预案内容
	 * 
	 * @param proposalContent
	 * @return Result
	 */
	public Result addProposalContent(ProposalContent proposalContent);

	/**
	 * 通过事件编号匹配预案。
	 * 
	 * @param incidentId
	 * @return
	 */
	public Result getProposalsByIncidentId(String incidentId);

	/* ********************ResourceStorage*********************** */
	/**
	 * 添加一条应急资源库信息
	 * 
	 * @param resourceStorage
	 * @return Result
	 */
	public Result addResourceStorage(ResourceStorage resourceStorage);

	/**
	 * 删除一条应急资源库信息
	 * 
	 * @param id
	 *            资源库编号
	 * @return Result
	 */
	public Result deleteResourceStorage(List<String> list);

	/**
	 * 修改一条应急资源库信息
	 * 
	 * @param resourceStorage
	 * @return Result
	 */
	public Result updateResourceStorage(ResourceStorage resourceStorage);

	/**
	 * 获取全部的应急资源库信息
	 * 
	 * @return Result
	 */
	public Result getResourceStorage();

	/**
	 * 按照应急资源库的编号获取一条应急资源库信息
	 * 
	 * @param id
	 *            应急资源库编号
	 * @return Result
	 */
	public Result findResourceStorageById(String id);

	/* **************InciProposal************** */

	/**
	 * 添加事件预案信息
	 * 
	 * @param inciProposal
	 * @return Result
	 */
	public Result addInciProposal(Inci_Proposal inciProposal);

	/**
	 * 删除事件预案信息
	 * 
	 * @param id
	 * @return Result
	 */
	public Result deleteInciProposal(List<String> id);

	/**
	 * 获取全部事件ID的预案信息
	 * 
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllInciProposalByIncidentId(String incidentId);

	/**
	 * 获取全部事件预案信息
	 * 
	 * @return Result
	 */
	public Result getAllInciProposal();

	/**
	 * 按照事件预案id获取事件预案
	 * 
	 * @param id
	 * @return Result
	 */
	public Result findInciProposalById(String id);

	/**
	 * 修改事件预案信息
	 * 
	 * @param inciProposal
	 * @return Result
	 */
	public Result updateInciProposal(Inci_Proposal inciProposal);

	/**
	 * 初始化（根据事件的等级和子类型 获取预案的内容）
	 * 
	 * @param incidentLevel
	 *            事件等级
	 * @param incidentSubType
	 *            事件子类型
	 * @return Result
	 */
	public Result getAllContentByTAndL(String incidentLevel, String incidentSubType);

	/* **************InciResource************** */

	/**
	 * 添加一条事件资源信息
	 * 
	 * @param inciResource
	 * @return Result
	 */
	public Result addInciResource(Inci_Resource inciResource);

	/**
	 * 删除事件资源
	 * 
	 * @param id
	 * @return Result
	 */
	public Result deleteInciResource(List<String> id);

	/**
	 * 根据事件资源Id获取事件资源信息
	 * 
	 * @param id
	 * @return Result
	 */
	public Result findInciResourceById(String id);

	/**
	 * 获取全部事件Id的事件资源信息
	 * 
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllByIncidentId(String incidentId);

	/**
	 * 获取全部的事件资源信息
	 * 
	 * @return Result
	 */
	public Result getAllInciResource();

	/**
	 * 修改事件资源信息
	 * 
	 * @param inciResource
	 * @return Result
	 */
	public Result updateInciResource(Inci_Resource inciResource);

	/* **************InciHandle************** */

	/**
	 * 添加事件善后信息
	 * 
	 * @param inciHandle
	 * @return Result
	 */
	public Result addInciHandle(Inci_Handle inciHandle);

	/**
	 * 删除事件善后信息
	 * 
	 * @param id
	 * @return Result
	 */
	public Result deleteInciHandle(List<String> id);

	/**
	 * 根据事件Id 获取相关全部事件善后信息
	 * 
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllInciHandleByIncidentId(String incidentId);

	/**
	 * 获取全部事件善后信息
	 * 
	 * @return Result
	 */
	public Result getAllInciHandle();

	/**
	 * 根据事件善后Id 获取事件善后信息
	 * 
	 * @param id
	 * @return Result
	 */
	public Result findInciHandleById(String id);

	/**
	 * 修改事件善后信息
	 * 
	 * @param inciHandle
	 * @return Result
	 */
	public Result updateInciHandle(Inci_Handle inciHandle);

	/* **************InciPerson************** */

	/**
	 * 添加一条事件人员信息
	 * 
	 * @param inciPerson
	 * @return Result
	 */
	public Result addInciPerson(Inci_Person inciPerson);

	/**
	 * 删除事件人员信息
	 * 
	 * @param id
	 * @return Result
	 */
	public Result deleteInciPerson(List<String> id);

	/**
	 * 获取全部事件人员信息
	 * 
	 * @return Result
	 */
	public Result getAllInciPerson();

	/**
	 * 根据事件Id 获取相关的事件人员信息
	 * 
	 * @param incidentId
	 * @return Result
	 */
	public Result getAllInciPersonByIncidentId(String incidentId);

	/**
	 * 根据事件人员ID 获取相应的事件人员信息
	 * 
	 * @param id
	 * @return Result
	 */
	public Result findInciPersonById(String id);

	/**
	 * 修改一条事件人员信息
	 * 
	 * @param inciPerson
	 * @return Result
	 */
	public Result updateInciPerson(Inci_Person inciPerson);

	/**
	 * 通过预案编号 获取预案信息以及相关的任务信息 (暂不用 获取任务的逻辑放到之前的增 删改预案接口)
	 */
	// public Result findProposalAndContentById(String id);

	/* ************ PreAlarm ***************************** */
	/**
	 * 新增预警信息
	 * 
	 * @param preAlarInfo
	 * @return Result
	 */
	public Result addPreAlarmInfo(PreAlarmInfo preAlarmInfo);

	/**
	 * 更新预警（解除预警）
	 * 
	 * @param preAlarmInfo
	 * @return
	 * @author Jerry
	 */
	public Result updatePreAlarmInfo(PreAlarmInfo preAlarmInfo);

	/**
	 * 获取所有预警信息
	 * 
	 * @return Result
	 */
	public Result getAllPreAlarmInfo();

	/**
	 * 通过预警编号查询预警信息(包括通知单位、应急措施)
	 * 
	 * @param id
	 * @return
	 */
	public Result findPreAlarmInfoById(String id);

	/**
	 * 创建通知单位（一个预警或有多个单位）
	 * 
	 * @param orgs
	 * @return
	 */
	public Result addNoticeOrganizations(List<PreAlarmNoticeOrganization> orgs);

	/**
	 * 更新通知单位(响应时间的更新)
	 * 
	 * @param orgId
	 * @return
	 */
	public Result updateNoticeOrganization(PreAlarmNoticeOrganization org);

	/**
	 * 新增预警措施
	 * 
	 * @param action
	 * @return
	 */
	public Result addPreAlarmAction(PreAlarmAction action);

	/**
	 * 更新措施(确认状态的更新)
	 * 
	 * @param action
	 * @return
	 */
	public Result updatePreAlarmAction(PreAlarmAction action);

	/**
	 * 查询给定事件范围内的历史预警
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 * @author Jerry
	 */
	public Result getHisPreAlarmInfoByTime(Date startTime, Date endTime);

	/**
	 * 根据措施编号删除对应措施
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result deletePreAlarmActionById(String id);

	/* ********************* SMS ************************************* */

	/**
	 * 立即发送短信内容
	 * 
	 * @param number
	 * @param content
	 * @return
	 */
	public Result sendSMSMessageInstantly(String phone, String content);

	/**
	 * 定时发送短信内容
	 * 
	 * @param number
	 * @param content
	 * @param date
	 * @return
	 */
	public Result sendSMSMessageInterval(String phone, String content, Date date);

	/*
	 * *********************** Troops *********************************
	 */

	/**
	 * 新增应急队伍
	 * 
	 * @param team
	 * @return
	 * @author Jerry
	 */
	public Result addTroops(Troops team);

	/**
	 * 更新应急队伍
	 * 
	 * @param team
	 * @return
	 * @author Jerry
	 */
	public Result updateTroops(Troops team);

	/**
	 * 删除应急队伍
	 * 
	 * @param ids
	 * @return
	 * @author Jerry
	 */
	public Result deleteTroops(List<String> ids);

	/**
	 * 根据事件编号删除对应的应急队伍
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result deleteTroopsByIncidentId(String id);

	/**
	 * 通过事件编号获取对应应急队伍集合
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result getTroopsByIncidentId(String id);

	/**
	 * 通过队伍编号获取队伍
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result findTroopsById(String id);

	/**
	 * 获取所有的应急队伍
	 * 
	 * @return
	 * @author Jerry
	 */
	public Result getAllTroops();
	/*
	 * **************************** PTIS **************************************
	 */

	/**
	 * 推送事件至PTIS(公众出行)
	 * 
	 * @param incident
	 * @return
	 */
	public Result sendIncidentToPTIS(List<String> ids);

	/*
	 * ***************************** CallCenter ********************************
	 */
	public String pushCMSEventList(List<CmsEvent> CmsEvents);

	/*
	 * ***************************** OperationHub *****************************
	 */

	/**
	 * 返回Incident ID 给OperationHub.
	 * 
	 * @return
	 */
	public String getObjectIdForOperationHub();

	/**
	 * 返回Incident状态给OperationHub.
	 * 
	 * @return
	 * @author Jerry
	 */
	public String getFlowStatus();

	/**
	 * 发送Incident给OperationHub.
	 * 
	 * @return
	 * @author Jerry
	 */
	public Incident putIncidentToOperationHub();

	/**
	 * 提供operationHub，获取事件
	 * 
	 * @param incidentId
	 * @return
	 * @author Jerry
	 */
	public Incident getIncidentForOperationHub(String incidentId);

	/**
	 * 日志记录完毕，通知ERS更新LED信息
	 * 
	 * @return
	 * @author Jerry
	 */
	public void notifyEmerToUpdateLed(List<String> ids);

	/*
	 * **************************** Incident Image ***************************
	 */

	/**
	 * 新增附件
	 * 
	 * @param file
	 * @return
	 * @author Jerry
	 */
	public Result addAttachmentFile(AttachmentFile file);

	/**
	 * 更新附件
	 * 
	 * @param file
	 * @return
	 * @author Jerry
	 */
	public Result updateAttachmentFile(AttachmentFile file);

	/**
	 * 删除附件
	 * 
	 * @param ids
	 *            -- 为附件信息id集合
	 * @return
	 * @author Jerry
	 */
	public Result deleteAttachmentFileByIds(List<String> ids);

	/**
	 * 通过事件编号获取附件对应集合
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result getAttachmentFileInfoByIncidentId(String id);

	/**
	 * 通过附件信息id 获取附件内容
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result findAttachmentFileContentByInfoId(String id);

	/**
	 * 删除与事件 相关的所有附件信息与内容
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result deleteAttachmentFileByIncidentId(String id);

	/**
	 * 根据附件编号下载附件。
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public byte[] downloadAttachById(String id);

	// ************ LED **************************

	/**
	 * 向 LED发送事件日志。
	 * 
	 * @param incidentId
	 * @param instutationId
	 * @param isStop
	 *            true:停止发送；false:发送.
	 * @return
	 * @author Jerry
	 */
	public Result pushIncidentToLed(String incidentId, String instutationId, boolean isStop);

	// ********************** Troops Resource *************************
	/**
	 * 新增应急队伍资源
	 * 
	 * @param resource
	 * @return
	 * @author Jerry
	 */
	public Result addTroopsResource(TroopsResource resource);

	/**
	 * 删除应急队伍资源
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result deleteTroopsResource(Integer id);

	/**
	 * 根据队伍编号查询资源
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public Result findTroopsResourceByTroopsId(String id);

	/**
	 * 更新应急队伍资源
	 * 
	 * @param resource
	 * @return
	 * @author Jerry
	 */
	public Result updateTroopsResource(TroopsResource resource);

	/**
	 * 
	 * 
	 * @param incidentNo
	 *            应急事件编号
	 * @param type
	 *            导出格式 "word" or "pdf"
	 * @return
	 * @author Jerry
	 */
	public String exportIncident(String incidentNo, String type);

}
