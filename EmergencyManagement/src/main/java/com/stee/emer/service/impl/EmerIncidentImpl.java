package com.stee.emer.service.impl;

import java.io.File;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;
import com.stee.dsms.model.Result;
import com.stee.emer.entity.AdministratorOffice;
import com.stee.emer.entity.Inci_Handle;
import com.stee.emer.entity.Inci_Proposal;
import com.stee.emer.entity.Inci_Resource;
import com.stee.emer.entity.Incident;
import com.stee.emer.entity.PTISJsonTemplate;
import com.stee.emer.entity.QueryBean;
import com.stee.emer.entity.ReportInfo;
import com.stee.emer.entity.TrafficEvent;
import com.stee.emer.mapper.EmerInciHandleMapper;
import com.stee.emer.mapper.EmerInciProposalMapper;
import com.stee.emer.mapper.EmerInciResourceMapper;
import com.stee.emer.mapper.EmerIncidentMapper;
import com.stee.emer.service.IEmerIncident;
import com.stee.emer.util.GUIDUtils;
import com.stee.emer.util.JMSSender;
import com.stee.emer.util.MessageSerializeUtils;
import com.stee.emer.util.ParameterUtils;
import com.stee.emer.util.Utils;
import com.stee.emer.util.WordGenerator;

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
 * ClassName : EmerIncidentImpl
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
public class EmerIncidentImpl implements IEmerIncident {

	@Autowired
	EmerIncidentMapper emerIncidentMapper;

	@Autowired
	EmerInciHandleMapper handleMapper;

	@Autowired
	EmerInciProposalMapper proposalMapper;

	@Autowired
	EmerInciResourceMapper resourceMapper;

	@Autowired
	@Qualifier("outterTopicSender")
	private JMSSender sender;

	@Override
	public Result addIncident(Incident incident) {

		Result result = new Result();
		/*
		 * 如果incident为null则不执行逻辑； incident不为空执行插入逻辑， 插入成功则返回Result（SUCCESS）
		 * 失败则返回Result（FAIL）
		 */
		if (incident != null) {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateStr = sdf.format(date);
			String[] dateArray = dateStr.split("-");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < dateArray.length; i++) {
				sb.append(dateArray[i]);
			}
			if (null == incident.getIncidentNo() || incident.getIncidentNo().equals(""))
				incident.setIncidentNo(sb.toString());
			if (null == incident.getState()) {
				incident.setState(0); // 默认状态——未确认。
			}
			String guid = GUIDUtils.getGUID();
			incident.setId(guid);
			Utils.setIncident(incident);
			int num = emerIncidentMapper.addIncident(incident);
			String id = incident.getId();

			if (num >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(incident);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

			if (incident.getState() != 0) {
				TrafficEvent event = reserveTypeOfIncident(incident);
				if (null != event) {
					PTISJsonTemplate<TrafficEvent> info = new PTISJsonTemplate<>();
					info.setStatus("ok");
					info.setError("");
					info.setData(Arrays.asList(event));
					StringWriter sw = new StringWriter();
					ObjectMapper om = new ObjectMapper();
					try {
						om.writeValue(sw, info);
					} catch (Exception e) {
						e.getStackTrace();
					}
					String status = sender.sendJMSMessage(sw.toString(), "TRAFFIC_EVENT");
					Utils.logger.info(status);
				}
			}
		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result updateIncident(Incident incident) {

		Result result = new Result();
		/*
		 * 如果incident为null则不执行逻辑； incident不为空执行插入逻辑， 插入成功则返回Result（SUCCESS）
		 * 失败则返回Result（FAIL）
		 */
		if (null != incident && null != incident.getId()) {

			int num = emerIncidentMapper.updateIncident(incident);

			if (num >= 1) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = sdf.format(new Date());
				try {
					incident.setUpdateTime(sdf.parse(dateStr));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				if (null != incident.getState() && incident.getState() != 0) {
					TrafficEvent event = reserveTypeOfIncident(incident);
					if (null != event) {
						PTISJsonTemplate<TrafficEvent> info = new PTISJsonTemplate<>();
						info.setStatus("ok");
						info.setError("");
						info.setData(Arrays.asList(event));
						StringWriter sw = new StringWriter();
						ObjectMapper om = new ObjectMapper();
						try {
							om.writeValue(sw, info);
						} catch (Exception e) {
							e.getStackTrace();
						}
						String status = sender.sendJMSMessage(sw.toString(), "TRAFFIC_EVENT");
						Utils.logger.info(status);
					}
				}

				result.setId(incident.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(incident);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {
			result.setUniqueData("事件不能为空，且事件主键id不能为空!");
			result.setStatusCode(Utils.PARA_EXCEPTION);
		}

		return result;
	}

	@Override
	public Result deleteIncident(List<String> list) {

		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (list.size() != 0) {

			for (String id : list) {

				int num = emerIncidentMapper.deleteIncident(id);
				if (num >= 1) {

					reList.add(id + "::" + Utils.SUCCESS);
					ids.add(id);

				} else {

					reList.add(id + "::" + Utils.FAIL);
					result.setStatusCode(Utils.FAIL);

				}

			}
			Utils.logger.info(reList);
			result.setData(ids);

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		// if(incident != null) {
		//
		// int num = emerIncidentMapper.deleteIncident(incident);
		//
		// if(num >= 1) {
		//
		// result.setId(incident.getId());
		// result.setStatusCode(Utils.SUCCESS);
		// result.setUniqueData(incident);
		//
		// }else{
		//
		// result.setStatusCode(Utils.FAIL);
		//
		// }
		//
		// }else{
		//
		// result.setStatusCode(Utils.PARA_EXCEPTION);
		//
		// }

		return result;
	}

	@Override
	public Result findIncidentById(String id) {

		Result result = new Result();

		if (!"".equals(id) && id != null) {

			Incident incident = emerIncidentMapper.findIncidentById(id);

			// if(incident != null) {

			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(incident);

			// }else{
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
	public Result getAllIncident() {

		Result result = new Result();

		List<Incident> list = emerIncidentMapper.getAllIncident();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	// 此方法暂不用
	@Override
	public Result findIncidentByTime(String id, Date time1, Date time2) {

		Result result = new Result();

		if (time1 == null || "".equals(time1)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;

		}

		if (time2 == null || "".equals(time2)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;

		}

		List<Incident> list = emerIncidentMapper.findIncidentByTime(id, time1, time2);
		result.setData(list);
		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

	@Override
	public Result findHistIncidentByTime(Date startTime, Date endTime) {
		Result result = new Result();

		if (startTime == null || "".equals(startTime)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;

		}

		if (endTime == null || "".equals(endTime)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;

		}

		List<Incident> list = emerIncidentMapper.findHistIncidentByTime(startTime, endTime);
		result.setData(list);
		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

	@Override
	public String findIncidentByState() {
		Map<String, String> map = new HashMap<>();
		List<AdministratorOffice> aoList = emerIncidentMapper.getAoList();
		for (AdministratorOffice ado : aoList) {
			String orgId = ado.getValue();
			List<Incident> list = emerIncidentMapper.getIncidentByAo(orgId);
			map.put(orgId, String.valueOf(list.size()));
		}
		List<Incident> list = emerIncidentMapper.getAllIncident();
		map.put("53000010000", String.valueOf(list.size()));
		MessageSerializeUtils ms = new MessageSerializeUtils();
		String message = ms.SerializeMessage(map);
		return message;
	}

	@Override
	public Result sendIncidentToPTIS(List<String> ids) {
		Result result = new Result();
		List<Incident> incidentList = new ArrayList<>();
		if (null != ids && !ids.isEmpty()) {
			for (String id : ids) {
				Incident incident = emerIncidentMapper.findIncidentById(id);
				if (null != incident) {
					incidentList.add(incident);
				}
			}
		}
		if (null != incidentList && !incidentList.isEmpty()) {
			List<TrafficEvent> list = new ArrayList<>();
			for (Incident i : incidentList) {
				if (i.getState() != 0) {
					TrafficEvent event = reserveTypeOfIncident(i);
					list.add(event);
				}
			}
			if (null != list && !list.isEmpty()) {
				PTISJsonTemplate<TrafficEvent> info = new PTISJsonTemplate<>();
				info.setStatus("ok");
				info.setError("");
				info.setData(list);
				StringWriter sw = new StringWriter();
				ObjectMapper om = new ObjectMapper();
				try {
					om.writeValue(sw, info);
				} catch (Exception e) {
					e.getStackTrace();
				}
				String status = sender.sendJMSMessage(sw.toString(), "TRAFFIC_EVENT");
				Utils.logger.info(status);
			}
		}
		result.setStatusCode(Utils.SUCCESS);
		return result;
	}

	public static String getJsonString(boolean method, String category, String value) {
		RestTemplate template = new RestTemplate();
		String message = template.getForObject(ParameterUtils.CCS_URL + "restFul/findDictionary?category=" + category,
				String.class);
		JSONObject jsonObj = new JSONObject(message);
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObj1 = jsonArray.getJSONObject(i);
			if (method) {
				if (jsonObj1.getString("value").equals(value)) {
					return jsonObj1.getString("name");
				}
			} else {
				if (jsonObj1.getString("name").equals(value)) {
					return jsonObj1.getString("value");
				}
			}

		}
		return "";
	}

	public TrafficEvent reserveTypeOfIncident(Incident incident) {
		if (null == incident)
			return null;
		TrafficEvent event = new TrafficEvent();
		event.setEventId(incident.getIncidentNo());
		if (null != incident.getRoad()) {
			try {
				event.setRoadId(incident.getSection());
			} catch (Exception e) {
				// try {
				// String roadId = getJsonString(false, "Section",
				// incident.getRoad());
				// event.setRoadId(roadId);
				// } catch (Exception e2) {
				// }

			}
		}

		if (null != incident.getType()) {
			String eventType = "";
			try {
				eventType = getJsonString(true, "IncidentType", incident.getType());
				event.setEventType(eventType);
			} catch (Exception e) {
				event.setEventType(incident.getType());
			}

			if (null != incident.getSubtype()) {
				try {
					String eventSubType = getJsonString(true, eventType, String.valueOf(incident.getSubtype()));
					event.setEventSubType(eventSubType);
				} catch (Exception e) {
					event.setEventSubType(String.valueOf(incident.getSubtype()));
				}

			}
		}
		event.setTitle(incident.getIncidentName());
		event.setReportOut(incident.getIncidentDesc() + "\n续报：\n" + getFurthurReportByIncidentId(incident.getId()));
		event.setReportIn("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (null != incident.getStartTime()) {
			Date startDate = incident.getStartTime();
			String startTime = sdf.format(startDate);
			event.setOccTime(startTime);
		}
		if (null != incident.getEndTime()) {
			Date endDate = incident.getEndTime();
			String endTime = sdf.format(endDate);
			event.setEndTime(endTime);
		}
		Date updateDate = incident.getUpdateTime();
		Date submitDate = incident.getSubmitTime();
		if (null == updateDate && null != submitDate) {
			event.setUpdateTime(sdf.format(submitDate));
		} else if (null != updateDate) {
			event.setUpdateTime(sdf.format(updateDate));
		}
		event.setInfoSource(incident.getSource());
		event.setOccPlace(incident.getAddress());
		String direction = "";
		switch (incident.getOrientation() == null ? 0 : incident.getOrientation()) {
		case 1:
			direction = "上行";
			break;
		case 2:
			direction = "下行";
			break;
		case 3:
			direction = "双向";
			break;
		default:
			direction = String.valueOf(incident.getOrientation());
		}
		event.setDirection(direction);
		event.setStartStake(incident.getPoint());
		event.setEndStake(incident.getPoint());
		try {
			event.setLatitude((float) incident.getY());
			event.setLongitude((float) incident.getX());
		} catch (Exception e) {
			e.getStackTrace();
		}
		event.setStartNode(incident.getIntervalStart());
		event.setEndNode(incident.getIntervalEnd());

		return event;
	}

	@Override
	public Result getIncidentByQueryBean(QueryBean query) {
		Result result = new Result();
		if (null == query) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		String administrativeOffice = query.getAdministrativeOffice();
		Date endTime = query.getEndTime();
		Date startTime = query.getStartTime();
		String section = query.getSection();
		String type = query.getType();

		List<Incident> list = emerIncidentMapper.getIncidentByQueryBean(startTime, endTime, section, type,
				administrativeOffice);
		result.setData(list);
		if (null != list && !list.isEmpty()) {
			result.setStatusCode(Utils.SUCCESS);
		} else {
			result.setStatusCode(Utils.OBJECT_NOT_EXIST);
		}
		return result;
	}

	@Override
	public void saveUserReportInfo(JSONObject jsonObj) {
		if (null == jsonObj)
			return;
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = (JSONObject) jsonArray.get(i);

			ReportInfo info = new ReportInfo();
			info.setReportId(GUIDUtils.getGUID());
			info.setUserId(obj.getString("userId"));
			info.setContent(obj.getString("content"));
			try {
				try {
					info.setOccTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(obj.getString("occTime")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			info.setOccPlace(obj.getString("occPlace"));
			info.setEventType(obj.getString("eventType"));
			info.setLatitude(obj.getDouble("latitude"));
			info.setLongitude(obj.getDouble("longitude"));
			int num = emerIncidentMapper.saveUserReportInfo(info);
			if (num != -1) {

			}
		}
	}

	/**
	 * 根据事件编号 获取续报内容
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	public String getFurthurReportByIncidentId(String id) {
		List<Inci_Handle> list = handleMapper.getAllInciHandleByIncidentId(id);
		StringBuilder stringBuilder = new StringBuilder();
		for (Inci_Handle inci_Handle : list) {
			if (inci_Handle.getStatus() == 0) {
				continue;
			}
			String report = inci_Handle.getDescription();
			if (null != report && !report.equals("")) {
				stringBuilder.append(report + "\r");
			}
		}
		return stringBuilder.toString();
	}

	@Override
	public Incident getIncidentForOperationHub(String incidentId) {
		return emerIncidentMapper.findIncidentById(incidentId);
	}

	@Override
	public String exportIncident(String incidentNo, String type) {
		if (null == incidentNo || incidentNo.equals("")) {
			return null;
		}
		// TODO
		Incident incident = emerIncidentMapper.findByIncidentNo(incidentNo);
		if (null == incident) {
			return null;
		} else {
			Map<String, String> map = Maps.newHashMap();
			map.put("code", incidentNo);
			String type2 = incident.getType();
			Integer subtype = incident.getSubtype();
			if (null != type2 && !type2.equals("")) {
				String typeName = emerIncidentMapper.findName("IncidentType", type2);
				if (null != subtype && null != typeName && !typeName.equals("")) {
					String subValue = emerIncidentMapper.findName(typeName, String.valueOf(subtype));
					if (null != subValue && !subValue.equals("")) {
						map.put("subtype", subValue);
					} else {
						map.put("subtype", "");
					}
					map.put("type", typeName);
				} else {
					map.put("subtype", "");
					map.put("type", "");
				}
			} else {
				map.put("subtype", "");
				map.put("type", "");
			}
			Integer incidentLevel = incident.getIncidentLevel();
			if (null != incidentLevel) {
				String level = emerIncidentMapper.findName("IncidentLevel", String.valueOf(incidentLevel));
				if (null != level && !level.equals("")) {
					map.put("level", level);
				} else {
					map.put("level", "");
				}
			} else {
				map.put("level", "");
			}
			String administrativeOffice = incident.getAdministrativeOffice();
			if (null != administrativeOffice && !administrativeOffice.equals("")) {
				String officeName = emerIncidentMapper.findName("AdministrativeOffice", administrativeOffice);
				if (null != officeName && !officeName.equals("")) {
					map.put("office", officeName);
				} else {
					map.put("office", "");
				}
			} else {
				map.put("office", "");
			}
			String road = incident.getRoad();
			if (null != road && !road.equals("")) {
				map.put("road", road);
			} else {
				map.put("road", "");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startTime = incident.getStartTime();
			if (null != startTime) {
				map.put("occur", sdf.format(startTime));
			} else {
				map.put("occur", "");
			}
			double x = incident.getX();
			if (x != 0) {
				map.put("longitude", String.valueOf(x));
			} else {
				map.put("longitude", "");
			}
			Date submitTime = incident.getSubmitTime();
			if (null != submitTime) {
				map.put("report", sdf.format(submitTime));
			} else {
				map.put("report", "");
			}
			double y = incident.getY();
			if (y != 0) {
				map.put("latitude", String.valueOf(y));
			} else {
				map.put("latitude", "");
			}
			Date endTime = incident.getEndTime();
			if (null != endTime) {
				map.put("finish", sdf.format(endTime));
			} else {
				map.put("finish", "");
			}
			String address = incident.getAddress();
			if (null != address && !address.equals("")) {
				map.put("location", address);
			} else {
				map.put("location", "");
			}
			Integer orientation = incident.getOrientation();
			if (null != orientation) {
				String direction = emerIncidentMapper.findName("Orientation", String.valueOf(orientation));
				if (null != direction && !direction.equals("")) {
					map.put("direction", direction);
				} else {
					map.put("direction", "");
				}
			} else {
				map.put("direction", "");
			}
			String point = incident.getPoint();
			if (null != point && !point.equals("")) {
				map.put("mileage", point);
			} else {
				map.put("mileage", "");
			}
			String intervalStart = incident.getIntervalStart();
			if (null != intervalStart && !intervalStart.equals("")) {
				String road2 = incident.getSection();
				if (null != road2 && !road2.equals("")) {
					String startInterval = emerIncidentMapper.findByDesc("收费站", intervalStart);
					// String startInterval = emerIncidentMapper.findName(road2,
					// intervalStart);
					if (null != startInterval && !startInterval.equals("")) {
						map.put("start", startInterval);
					} else {
						// String findName = emerIncidentMapper.findName(null,
						// intervalStart);
						// if (null != findName && !findName.equals("")) {
						// map.put("start", findName);
						// } else {
						// map.put("start", "");
						// }
						map.put("start", "");
					}
				} else {
					map.put("start", "");
				}
			} else {
				map.put("start", "");
			}
			String intervalEnd = incident.getIntervalEnd();
			if (null != intervalEnd && !intervalEnd.equals("")) {
				String road2 = incident.getSection();
				if (null != road2 && !road2.equals("")) {
					String endInterval = emerIncidentMapper.findByDesc("收费站", intervalEnd);
					if (null != endInterval && !endInterval.equals("")) {
						map.put("end", endInterval);
					} else {
						// String findName = emerIncidentMapper.findName(null,
						// intervalEnd);
						// if (null != findName && !findName.equals("")) {
						// map.put("end", findName);
						// } else {
						// map.put("end", "");
						// }
						map.put("end", "");
					}
				} else {
					map.put("end", "");
				}
			} else {
				map.put("end", "");
			}
			String section = incident.getSection();
			if (null != section && !section.equals("")) {
				String sectionName = emerIncidentMapper.findName("Section", section);
				if (null != sectionName && !sectionName.equals("")) {
					map.put("section", sectionName);
				} else {
					map.put("section", "");
				}
			} else {
				map.put("section", "");
			}
			String effectedLane = incident.getEffectedLane();
			if (null != effectedLane && !effectedLane.equals("")) {
				map.put("lane", effectedLane);
			} else {
				map.put("lane", "");
			}
			String incidentDesc = incident.getIncidentDesc();
			if (null != incidentDesc && !incidentDesc.equals("")) {
				map.put("detail", incidentDesc);
			} else {
				map.put("detail", "");
			}
			String other = incident.getOther();
			if (null != other && !other.equals("")) {
				map.put("other", other);
			} else {
				map.put("other", "");
			}
			String id = incident.getId();
			StringBuilder stringBuilder = new StringBuilder();
			List<Inci_Proposal> allInciProposalByIncidentId = proposalMapper.getAllInciProposalByIncidentId(id);
			if (null != allInciProposalByIncidentId && !allInciProposalByIncidentId.isEmpty()) {
				for (int i = 0; i < allInciProposalByIncidentId.size(); i++) {
					Inci_Proposal inci_Proposal = allInciProposalByIncidentId.get(i);
					String content = inci_Proposal.getContent();
					if (null != content && !content.equals("")) {
						stringBuilder.append((i + 1) + "、" + content);
						stringBuilder.append(" </w:t></w:r></w:p><w:p><w:pPr></w:pPr>");
						stringBuilder.append("<w:r><w:rPr>");
						stringBuilder.append(" </w:rPr><w:t>  ");
					}
				}
				if (stringBuilder.length() != 0) {
					map.put("approach", stringBuilder.toString());
				} else {
					map.put("approach", "");
				}
			} else {
				map.put("approach", "");
			}
			List<Inci_Resource> allByIncidentId = resourceMapper.getAllByIncidentId(id);
			if (null != allByIncidentId && !allByIncidentId.isEmpty()) {
				StringBuilder resourceBuilder = new StringBuilder();
				for (int i = 0; i < allByIncidentId.size(); i++) {
					try {
						Inci_Resource inci_Resource = allByIncidentId.get(i);
						resourceBuilder
								.append((i + 1) + "、" + inci_Resource.getName() + "    数量：" + inci_Resource.getCount());
						// 换行三个为一个整体
						resourceBuilder.append(" </w:t></w:r></w:p><w:p><w:pPr></w:pPr>");
						resourceBuilder.append("<w:r><w:rPr>");
						resourceBuilder.append(" </w:rPr><w:t>  ");
					} catch (Exception e) {
					}
				}
				if (resourceBuilder.length() != 0) {
					map.put("resource", resourceBuilder.toString());
				} else {
					map.put("resource", "");
				}
			} else {
				map.put("resource", "");
			}
			List<Inci_Handle> allInciHandleByIncidentId = handleMapper.getAllInciHandleByIncidentId(id);
			if (null != allInciHandleByIncidentId && !allInciHandleByIncidentId.isEmpty()) {
				StringBuilder handleBuilder = new StringBuilder();
				for (int i = 0; i < allInciHandleByIncidentId.size(); i++) {
					Inci_Handle inci_Handle = allInciHandleByIncidentId.get(i);
					if (null != inci_Handle.getDescription() && !inci_Handle.getDescription().equals("")) {
						handleBuilder.append((i + 1) + "、" + inci_Handle.getDescription());
						handleBuilder.append(" </w:t></w:r></w:p><w:p><w:pPr></w:pPr>");
						handleBuilder.append("<w:r><w:rPr>");
						handleBuilder.append(" </w:rPr><w:t>  ");
					}
				}
				if (handleBuilder.length() != 0) {
					map.put("resubmit", handleBuilder.toString());
				} else {
					map.put("resubmit", "");
				}
			} else {
				map.put("resubmit", "");
			}
			String spotFinalReport = incident.getSpotFinalReport();
			if (null != spotFinalReport && !spotFinalReport.equals("")) {
				map.put("summarize", spotFinalReport);
			} else {
				map.put("summarize", "");
			}
			String centreFinalReport = incident.getCentreFinalReport();
			if (null != centreFinalReport && !centreFinalReport.equals("")) {
				map.put("summarizeOfCentre", centreFinalReport);
			} else {
				map.put("summarizeOfCentre", "");
			}
			File file = WordGenerator.createDoc(map, "model", incidentNo);
			String encode = WordGenerator.encode(WordGenerator.getBytes(file));
			file.delete();
			if (null != type && type.equals("word")) {
				return encode;
			} else if (null != type && type.equals("pdf")) {
				return null;
			}
			return null;
		}
	}

}
