package com.stee.emer.util;

import java.io.IOException;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
public class MessageSerializeUtils {

	public MessageSerializeUtils() {
		super();
	}

	@SuppressWarnings("static-access")
	public String SerializeMessage(Map<String, String> map) {
		InetAddress ia = null;
		String ip = "";
		try {
			ia = ia.getLocalHost();
			ip = ia.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		SerMessage sm = new SerMessage();
		Map<String, String> from = new LinkedHashMap<>();
		from.put("ip", ip);
		from.put("module", "ERS");
		sm.setFrom(from);
		Map<String, String> to = new LinkedHashMap<>();
		to.put("ip", "*");
		to.put("module", "CCM");
		sm.setTo(to);
		sm.setType("incidentAlert");
		List<Data> list = new ArrayList<>();
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			Data data = new Data();
			data.setOrganizationCode(entry.getKey());
			data.setCount(entry.getValue());
			list.add(data);
		}
		sm.setData(list);
		StringWriter sw = new StringWriter();
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(sw, sm);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	class SerMessage {
		Map<String, String> from = new HashMap<>();
		Map<String, String> to = new HashMap<>();
		String type = "";
		List<Data> data = new ArrayList<>();

		public SerMessage() {
			super();
		}

		public Map<String, String> getFrom() {
			return from;
		}

		public void setFrom(Map<String, String> from) {
			this.from = from;
		}

		public Map<String, String> getTo() {
			return to;
		}

		public void setTo(Map<String, String> to) {
			this.to = to;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<Data> getData() {
			return data;
		}

		public void setData(List<Data> data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "SerMessage [from=" + from + ", to=" + to + ", type=" + type + ", data=" + data + "]";
		}

	}

	class Data {
		private String organizationCode;
		private String count;

		public String getOrganizationCode() {
			return organizationCode;
		}

		public void setOrganizationCode(String organizationCode) {
			this.organizationCode = organizationCode;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return "Data [organizationCode=" + organizationCode + ", count=" + count + "]";
		}

	}

}
