package com.stee.emer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.IncidentLog;
import com.stee.emer.mapper.EmerLedMapper;
import com.stee.emer.service.IEmerLed;
import com.stee.emer.util.ParameterUtils;
import com.stee.emer.util.Utils;
import com.stee.emer.webService.AWebServiceClient;
import com.stee.emer.webService.IEmerCallBack;
import com.stee.emer.webService.client.sms.WsForSMS;
import com.stee.emer.webService.client.vms.IWebServiceForHub;

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
@Service
public class EmerLed extends AWebServiceClient implements IEmerLed {

	@Autowired
	EmerLedMapper ledMapper;

	@Override
	public Result pushIncidentToLed(String incidentId, String instutationId, boolean isStop) {
		Result result = new Result();
		Integer flag = isStop == true ? 1 : 0;
		if (isStop) {
			int num = ledMapper.updateSwitch(instutationId, incidentId, flag);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
				return result;
			}
		} else {
			try {
				int num = ledMapper.updateLedInfo(instutationId, incidentId, flag);
				List<IncidentLog> list = ledMapper.getLogsByIncidentId(incidentId);
				if (num != -1 && !list.isEmpty()) {
					result.setData(list);
					result.setStatusCode(Utils.SUCCESS);
				} else {
					result.setStatusCode(Utils.OBJECT_NOT_EXIST);
				}
			} catch (Exception e) {
				result.setStatusCode(Utils.FAIL);
			}
		}
		return result;
	}

	@Override
	public String updateVmsCurrentMessage(final String jsonMessage) {
		final Result result = new Result();
		super.getLEDClient(ParameterUtils.VMS_WEBSERVICE_URL, new IEmerCallBack() {

			@Override
			public void call(IWebServiceForHub port) {
				String response = port.updateVmsCurrentMessage(jsonMessage, null, null);
				result.setUniqueData(response);
			}

			@Override
			public void call(WsForSMS port) {

			}
		});
		return result.getUniqueObject().toString();
	}

}
