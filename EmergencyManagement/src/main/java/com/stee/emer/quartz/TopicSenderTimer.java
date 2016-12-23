package com.stee.emer.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.stee.emer.service.IEmerIncident;
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
public class TopicSenderTimer {
	@Autowired
	@Qualifier("topicSender")
	private com.stee.dsms.jms.Sender sender;

	@Autowired
	private IEmerIncident emerIncident;

	public void init() {
		String message = emerIncident.findIncidentByState();
		try {
			sender.send("its", message);
			Utils.logger.info("Send to topic 'its' success: " + message);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
