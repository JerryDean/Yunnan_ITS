package com.stee.emer.entity;

import java.io.Serializable;

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
@Alias("CmsEvent")
public class CmsEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 呼叫中心自动生成的受理编号
	 */
	private String id;
	/**
	 * 事主姓名
	 */
	private String callerName;
	/**
	 * 事主身份证号
	 */
	private String callerICNo;
	/**
	 * 性别代码 （M-Male. F-Female. U-Unknown）
	 */
	private String callerGenderCode;
	/**
	 * 事主来电电话号码
	 */
	private String callerPhoneNo;
	/**
	 * 事主联系电话号码
	 */
	private String callerContactPhoneNo;
	/**
	 * 事主车牌号
	 */
	private String callerVehiclePlateNo;
	/**
	 * 道路名称
	 */
	private String roadName;
	/**
	 * 道路桩号
	 */
	private String roadStakeNo;
	/**
	 * 位置经度
	 */
	private double locationLongitude;
	/**
	 * 位置纬度
	 */
	private double locationLatidude;
	/**
	 * 道路行驶方向
	 */
	private String roadDirection;
	/**
	 * 事件位置描述
	 */
	private String location;
	/**
	 * 事件描述
	 */
	private String eventDescription;
	/**
	 * 通话开始时间 格式YYYYMMDDHHNNSSzzz
	 */
	private String callStartTime;
	/**
	 * 通话结束时间 格式YYYYMMDDHHNNSSzzz
	 */
	private String callEndTime;
	/**
	 * 通话的唯一识别码GUID.
	 */
	private String connectionID;
	/**
	 * 通话录音播放的URL连接
	 */
	private String recordingUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getCallerICNo() {
		return callerICNo;
	}

	public void setCallerICNo(String callerICNo) {
		this.callerICNo = callerICNo;
	}

	public String getCallerGenderCode() {
		return callerGenderCode;
	}

	public void setCallerGenderCode(String callerGenderCode) {
		this.callerGenderCode = callerGenderCode;
	}

	public String getCallerPhoneNo() {
		return callerPhoneNo;
	}

	public void setCallerPhoneNo(String callerPhoneNo) {
		this.callerPhoneNo = callerPhoneNo;
	}

	public String getCallerContactPhoneNo() {
		return callerContactPhoneNo;
	}

	public void setCallerContactPhoneNo(String callerContactPhoneNo) {
		this.callerContactPhoneNo = callerContactPhoneNo;
	}

	public String getCallerVehiclePlateNo() {
		return callerVehiclePlateNo;
	}

	public void setCallerVehiclePlateNo(String callerVehiclePlateNo) {
		this.callerVehiclePlateNo = callerVehiclePlateNo;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getRoadStakeNo() {
		return roadStakeNo;
	}

	public void setRoadStakeNo(String roadStakeNo) {
		this.roadStakeNo = roadStakeNo;
	}

	public double getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(double locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public double getLocationLatidude() {
		return locationLatidude;
	}

	public void setLocationLatidude(double locationLatidude) {
		this.locationLatidude = locationLatidude;
	}

	public String getRoadDirection() {
		return roadDirection;
	}

	public void setRoadDirection(String roadDirection) {
		this.roadDirection = roadDirection;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getCallStartTime() {
		return callStartTime;
	}

	public void setCallStartTime(String callStartTime) {
		this.callStartTime = callStartTime;
	}

	public String getCallEndTime() {
		return callEndTime;
	}

	public void setCallEndTime(String callEndTime) {
		this.callEndTime = callEndTime;
	}

	public String getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(String connectionID) {
		this.connectionID = connectionID;
	}

	public String getRecordingUrl() {
		return recordingUrl;
	}

	public void setRecordingUrl(String recordingUrl) {
		this.recordingUrl = recordingUrl;
	}

	@Override
	public String toString() {
		return "CmsEvent [id=" + id + ", callerName=" + callerName + ", callerICNo=" + callerICNo
				+ ", callerGenderCode=" + callerGenderCode + ", callerPhoneNo=" + callerPhoneNo
				+ ", callerContactPhoneNo=" + callerContactPhoneNo + ", callerVehiclePlateNo=" + callerVehiclePlateNo
				+ ", roadName=" + roadName + ", roadStakeNo=" + roadStakeNo + ", locationLongitude=" + locationLongitude
				+ ", locationLatidude=" + locationLatidude + ", roadDirection=" + roadDirection + ", location="
				+ location + ", eventDescription=" + eventDescription + ", callStartTime=" + callStartTime
				+ ", callEndTime=" + callEndTime + ", connectionID=" + connectionID + ", recordingUrl=" + recordingUrl
				+ "]";
	}

}
