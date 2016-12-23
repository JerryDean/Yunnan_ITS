package com.stee.emer.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.stee.dsms.properties.PropertyConfigurer;
import com.stee.emer.entity.Incident;
import com.stee.emer.mapper.EmerIncidentMapper;
import com.stee.emer.service.IEmerIncident;
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
 * @author Jerry
 * @version 1.0
 *
 */
public class DiscloseListenner implements MessageListener {

	@Autowired
	EmerIncidentMapper emerIncidentMapper;

	@Autowired
	IEmerIncident emerIncidentService;

	@Override
	public void onMessage(Message message) {
		String swit = PropertyConfigurer.getContextProperty("ERS.tip.flag").toString();
		if (swit.equals("0")) {
			return;
		} else {
			TextMessage tm = (TextMessage) message;
			try {
				String content = tm.getText();
				Utils.logger.info("TRAFFIC_USER_REPORT:" + content);
				JSONObject jsonObj = new JSONObject(content);
				emerIncidentService.saveUserReportInfo(jsonObj);
				JSONArray jsonArray = jsonObj.getJSONArray("data");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject obj = (JSONObject) jsonArray.get(i);
					String desc = "报料ID:" + obj.getString("reportId") + ",用户ID:" + obj.getString("userId") + ",报料类型:"
							+ obj.getString("eventType") + ",报料信息:" + obj.getString("content");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date submitTime = sdf.parse(obj.getString("occTime"));
					String address = obj.getString("occPlace");
					double latitude = obj.getDouble("latitude");
					double longitude = obj.getDouble("longitude");
					Incident incident = new Incident();
					Date date = new Date(System.currentTimeMillis());
					String dateStr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
					String[] dateArray = dateStr.split("-");
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < dateArray.length; j++) {
						sb.append(dateArray[j]);
					}
					incident.setId(GUIDUtils.getGUID());
					incident.setIncidentNo(sb.toString());
					incident.setAddress(address);
					incident.setIncidentDesc(desc);
					incident.setSubmitTime(submitTime);
					incident.setX(longitude);
					incident.setY(latitude);
					emerIncidentMapper.addIncident(incident);
					Utils.logger.info("Save user report success!" + incident);
				}
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

}
