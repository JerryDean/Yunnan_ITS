package com.stee.emer.util;

import java.util.UUID;

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
 * ClassName : GUIDUtils
 * </p>
 * <p>
 * Description : This is a GUIDUtils class for get GUID ...
 * </p>
 * <p>
 * Created On :2016-03-30
 * </p>
 *
 * @author lcw
 * @version 1.0
 *
 */
public class GUIDUtils {
	public static String getGUID() {

		String guid = null;
		// 产生 5 个 GUID
		for (int i = 0; i < 5; i++) {
			// 创建 GUID 对象
			UUID uuid = UUID.randomUUID();
			// 得到对象产生的ID
			String a = uuid.toString();
			// 转换为大写
			a = a.toUpperCase();
			// 替换 -
			guid = a.replaceAll("-", "");

		}
		return guid;
	}

}
