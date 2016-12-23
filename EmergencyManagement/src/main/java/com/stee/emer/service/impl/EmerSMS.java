package com.stee.emer.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.service.IEmerSMS;
import com.stee.emer.util.ConvertToXMLGregorian;
import com.stee.emer.util.ParameterUtils;
import com.stee.emer.util.Utils;
import com.stee.emer.webService.AWebServiceClient;
import com.stee.emer.webService.IEmerCallBack;
import com.stee.emer.webService.client.sms.ResultInfo;
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
public class EmerSMS extends AWebServiceClient implements IEmerSMS {

	@Override
	public Result sendSMSMessageInstantly(final String number, final String content) {
		final Result result = new Result();
		try {
			super.getSMSClient(ParameterUtils.SMS_WEBSERVICE_URL, new IEmerCallBack() {
				@Override
				public void call(WsForSMS port) {
					ResultInfo info = port.sendListSmsUTF8(number, content, null, null);
					StringWriter sw = new StringWriter();
					ObjectMapper om = new ObjectMapper();
					try {
						om.writeValue(sw, info);
					} catch (JsonGenerationException e) {
						e.printStackTrace();
					} catch (JsonMappingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					result.setUniqueData(sw.toString());
					Utils.logger.info("Send sms message status:" + info.getStatusCode());
				}

				@Override
				public void call(IWebServiceForHub port) {

				}
			});
			result.setStatusCode(Utils.SUCCESS);
		} catch (Exception e) {
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result sendSMSMessageInterval(final String number, final String content, final Date date) {
		final Result result = new Result();
		try {
			super.getSMSClient(ParameterUtils.SMS_WEBSERVICE_URL, new IEmerCallBack() {

				@Override
				public void call(WsForSMS port) {
					ResultInfo info = port.sendListSmsUTF8(number, content,
							ConvertToXMLGregorian.convertToXMLGregorianCalendar(date), null);
					StringWriter sw = new StringWriter();
					ObjectMapper om = new ObjectMapper();
					try {
						om.writeValue(sw, info);
					} catch (JsonGenerationException e) {
						e.printStackTrace();
					} catch (JsonMappingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					result.setUniqueData(sw.toString());
					Utils.logger.info("Send sms message status:" + info.getStatusCode());
				}

				@Override
				public void call(IWebServiceForHub port) {

				}
			});
			result.setStatusCode(Utils.SUCCESS);
		} catch (Exception e) {
			result.setId(null);
			result.setUniqueData(e.getMessage());
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

}
