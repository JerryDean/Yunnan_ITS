package com.stee.emer.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

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
public class PublicIP {
	/**
	 * 得到本机的外网ip，出现异常时返回本地IP
	 * 
	 * @return
	 */
	public static String getPublicIP() {
		String ip = null;

		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		org.jsoup.nodes.Document doc = null;
		Connection con = null;

		// 连接 http://1212.ip138.com/ic.asp
		con = Jsoup.connect("http://1212.ip138.com/ic.asp").timeout(10000);

		try {
			doc = con.get();

			// 获得包含本机ip的文本串：您的IP是：[xxx.xxx.xxx.xxx] 来自：YY
			org.jsoup.select.Elements els = doc.body().select("center");
			for (org.jsoup.nodes.Element el : els) {
				ip = el.text();
			}

			// 从文本串过滤出ip，用正则表达式将非数字和.替换成空串""
			ip = ip.replaceAll("[^0-9.]", "");
		} catch (IOException e) {
			e.printStackTrace();
			return ip;
		}

		return "http://" + ip + "/CCS_ERS_Mgt";
	}

	public static void main(String[] args) {
		System.out.println(getPublicIP());
	}
}
