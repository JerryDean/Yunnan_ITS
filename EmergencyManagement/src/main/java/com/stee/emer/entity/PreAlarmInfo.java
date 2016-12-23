package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

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
@Alias("PreAlarmInfo")
public class PreAlarmInfo implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 预警编号
	 */
	private String id;
	/*
	 * 预警内容
	 */
	private String content;
	/*
	 * 发布单位
	 */
	private String organization;
	/*
	 * 发布时间
	 */
	private Date releaseTime;
	/*
	 * 要求响应时间
	 */
	private Date responseTime;

	/**
	 * 预警标识(0:预警已解除, 1:预警未解除)
	 */
	private Integer flag;

	/**
	 * 预警事件名称
	 */
	private String name;

	/**
	 * 发送人
	 */
	private String sender;

	/**
	 * 预警类型
	 */
	private String type;

	/**
	 * 发布人联系方式
	 */
	private String contact;

	/**
	 * 预警事件附件
	 */
	private List<AttachmentFile> attachs;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<AttachmentFile> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<AttachmentFile> attachs) {
		this.attachs = attachs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	/**
	 * 该预警通知的的单位集合
	 */
	private List<PreAlarmNoticeOrganization> orgs;

	public List<PreAlarmNoticeOrganization> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<PreAlarmNoticeOrganization> orgs) {
		this.orgs = orgs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	@Override
	public String toString() {
		return "PreAlarmInfo [id=" + id + ", content=" + content + ", organization=" + organization + ", releaseTime="
				+ releaseTime + ", responseTime=" + responseTime + ", flag=" + flag + ", name=" + name + ", sender="
				+ sender + ", type=" + type + ", contact=" + contact + ", attachs=" + attachs + ", orgs=" + orgs + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
