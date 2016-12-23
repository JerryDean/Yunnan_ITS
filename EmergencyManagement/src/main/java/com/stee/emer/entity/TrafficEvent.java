package com.stee.emer.entity;

import java.io.Serializable;

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
public class TrafficEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 事件ID
	 */
	private String eventId;
	/**
	 * 路段ID
	 */
	private String roadId;
	/**
	 * 事件类型
	 */
	private String eventType;
	/**
	 * 事件子类型
	 */
	private String eventSubType;
	/**
	 * 事件标题
	 */
	private String title;
	/**
	 * 对外发布信息
	 */
	private String reportOut;
	/**
	 * 事件内部信息
	 */
	private String reportIn;
	/**
	 * 事件发生时间(yyyy-MM-dd hh24:mm:ss)
	 */
	private String occTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 事件更新时间
	 */
	private String updateTime;
	/**
	 * 事件来源
	 */
	private String InfoSource;
	/**
	 * 事发位置
	 */
	private String occPlace;
	/**
	 * 事件方向
	 */
	private String direction;
	/**
	 * 起始桩号
	 */
	private String startStake;
	/**
	 * 结束桩号
	 */
	private String endStake;
	/**
	 * 纬度
	 */
	private float latitude;
	/**
	 * 经度
	 */
	private float longitude;
	/**
	 * 起始站
	 */
	private String startNode;
	/**
	 * 结束站
	 */
	private String endNode;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventSubType() {
		return eventSubType;
	}

	public void setEventSubType(String eventSubType) {
		this.eventSubType = eventSubType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReportOut() {
		return reportOut;
	}

	public void setReportOut(String reportOut) {
		this.reportOut = reportOut;
	}

	public String getReportIn() {
		return reportIn;
	}

	public void setReportIn(String reportIn) {
		this.reportIn = reportIn;
	}

	public String getOccTime() {
		return occTime;
	}

	public void setOccTime(String occTime) {
		this.occTime = occTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getInfoSource() {
		return InfoSource;
	}

	public void setInfoSource(String infoSource) {
		InfoSource = infoSource;
	}

	public String getOccPlace() {
		return occPlace;
	}

	public void setOccPlace(String occPlace) {
		this.occPlace = occPlace;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStartStake() {
		return startStake;
	}

	public void setStartStake(String startStake) {
		this.startStake = startStake;
	}

	public String getEndStake() {
		return endStake;
	}

	public void setEndStake(String endStake) {
		this.endStake = endStake;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	public String getEndNode() {
		return endNode;
	}

	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}

	@Override
	public String toString() {
		return "TrafficEvent [eventId=" + eventId + ", roadId=" + roadId + ", eventType=" + eventType
				+ ", eventSubType=" + eventSubType + ", title=" + title + ", reportOut=" + reportOut + ", reportIn="
				+ reportIn + ", occTime=" + occTime + ", endTime=" + endTime + ", updateTime=" + updateTime
				+ ", InfoSource=" + InfoSource + ", occPlace=" + occPlace + ", direction=" + direction + ", startStake="
				+ startStake + ", endStake=" + endStake + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", startNode=" + startNode + ", endNode=" + endNode + "]";
	}

}
