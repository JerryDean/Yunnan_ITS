package com.stee.emer.util;

import org.apache.log4j.Logger;

import com.stee.emer.entity.Incident;

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
 * PackageName : com.stee.emer.util
 * </p>
 * <p>
 * ClassName : Utils
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
public class Utils {

	/**
	 * 操作成功
	 */
	public final static String SUCCESS = "000000";

	/**
	 * 操作失败
	 */
	public final static String FAIL = "999999";

	/**
	 * 传入参数异常
	 */
	public final static String PARA_EXCEPTION = "900101";

	/**
	 * 对象不存在
	 */
	public final static String OBJECT_NOT_EXIST = "900102";

	public final static String USER_ALREADY_EXITS = "900006";

	/**
	 * 全局日志变量
	 */
	public final static Logger logger = Logger.getLogger("CCS_ERS_MGT");

	/**
	 * OperationHub .op_log. objectId
	 */
	public static String objectId = "";

	public static String incidentStatus = "";

	private static Incident incident;

	public static Incident getIncident() {
		return incident;
	}

	public static void setIncident(Incident incident) {
		Utils.incident = incident;
	}

}
