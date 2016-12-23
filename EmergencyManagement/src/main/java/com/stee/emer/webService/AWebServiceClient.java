package com.stee.emer.webService;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.stee.emer.webService.client.sms.WsForSMSImpl;
import com.stee.emer.webService.client.vms.WebServiceForHub;

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
public abstract class AWebServiceClient {
	private static final QName SERVICE_NAME = new QName("http://impl.ws.sms.stee.com/", "ws_ForSMSImpl");

	private static final QName LED_SERVICE_NAME = new QName("http://impl.server.ws.CCS_VMS_Mgt.stee.com/",
			"WebServiceForHub");

	public void getSMSClient(String uri, IEmerCallBack call) {
		if (null == uri || uri.equals("")) {
			return;
		}
		try {
			URL url = new URL(uri);
			WsForSMSImpl ws = new WsForSMSImpl(url, SERVICE_NAME);
			call.call(ws.getWsForSMSImplPort());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	};

	public void getLEDClient(String uri, IEmerCallBack call) {
		if (null == uri || uri.equals("")) {
			return;
		}
		try {
			URL url = new URL(uri);
			WebServiceForHub ws = new WebServiceForHub(url, LED_SERVICE_NAME);
			call.call(ws.getWebServiceForHubImplPort());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
