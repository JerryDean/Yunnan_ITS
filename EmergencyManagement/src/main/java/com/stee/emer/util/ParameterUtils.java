package com.stee.emer.util;

import com.stee.dsms.properties.PropertyConfigurer;

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
public class ParameterUtils {
	public static String SMS_WEBSERVICE_URL = "";

	public static String CCS_URL = "";

	public static String WSDL_ERS_MGT = "";

	public static String USERNAME = "";

	public static String PASSWORD = "";

	public static String VMS_WEBSERVICE_URL = "";

	static {
		VMS_WEBSERVICE_URL = PropertyConfigurer.getContextProperty("WSDL_Vms_Mgt").toString();
		SMS_WEBSERVICE_URL = PropertyConfigurer.getContextProperty("WSDL_SMS").toString();
		CCS_URL = PropertyConfigurer.getContextProperty("CCM_operationhub_url").toString();
		WSDL_ERS_MGT = PropertyConfigurer.getContextProperty("ERS.project.url").toString();
		USERNAME = PropertyConfigurer.getContextProperty("ERS.ws.username").toString();
		PASSWORD = PropertyConfigurer.getContextProperty("ERS.ws.password").toString();
	}
}
