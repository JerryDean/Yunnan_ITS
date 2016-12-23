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
 * Project Name : CCS_ERS_Mgt
 * <p>
 * PackageName : com.stee.emer.entity
 * </p>
 * <p>
 * ClassName : Incident
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
@Alias("Incident")
public class Incident implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1049333157423371341L;

	// GUID
	private String id;

	// 事件类型
	private String type;

	// 事件子类型
	private Integer subtype;

	// 事件等级
	private Integer incidentLevel;

	// 信息来源
	private String source;

	// 发生时间
	private Date startTime;

	// 报送时间
	private Date submitTime;

	// 结束时间
	private Date endTime;

	// 道路名称
	private String road;

	// 具体位置
	private String address;

	// 桩号
	private String point;

	// 经度
	private double x;

	// 纬度
	private double y;

	// 方向
	private Integer orientation;

	// 影响车道
	private String effectedLane;

	// 事故情况描述
	private String incidentDesc;

	// 拥堵状况描述
	private String trafficJam;

	// 伤亡状况描述
	private String injuried;

	// 其它信息
	private String other;

	// 事件状态
	private Integer state;

	// 事件名称
	private String incidentName;
	// 事件执行状态（1通话中2资源调配中3消防员处理中）
	private Integer executeStatus;
	// 道路类型 （1高速路2隧道3匝道4其它）
	private String roadType;
	// 相关车辆数
	private Integer vehicleNum;
	// 受伤人数
	private Integer InjuredNum;
	// 死亡人数
	private Integer deathNum;
	// 是否拥堵 （1是 2不是)
	private String isCongestion;
	// 拥堵开始时间
	private Date congestionStart;
	// 拥堵结束时间
	private Date congestionEnd;
	// 是否为模拟事件(1是2不是）
	private String isSimulate;
	// 地理信息
	private String geographicInformation;
	// 管理处
	private String administrativeOffice;
	// 路段
	private String section;
	// 区间起始站
	private String intervalStart;
	// 区间结束站
	private String intervalEnd;

	/**
	 * 事件更新时间
	 */
	private Date updateTime;

	/**
	 * 现场总结报道
	 */
	private String spotFinalReport;

	/**
	 * 中心总结报道
	 */
	private String centreFinalReport;

	/**
	 * 事件编号
	 */
	private String incidentNo;

	/**
	 * 日志摘要
	 */
	private String logInfo;

	/**
	 * 事故车型集合
	 */
	private List<String> carModule;

	/**
	 * 事故车型
	 */
	private String carModuleStr;

	/**
	 * 事故原因
	 */
	private String accidentReason;

	/**
	 * 事故形态
	 */
	private String accidentForm;

	/**
	 * 交通中断（0:交通中断，1:未中断）
	 */
	private Integer trafficStop;

	public List<String> getCarModule() {
		return carModule;
	}

	public void setCarModule(List<String> carModule) {
		this.carModule = carModule;
	}

	public String getCarModuleStr() {
		return carModuleStr;
	}

	public void setCarModuleStr(String carModuleStr) {
		this.carModuleStr = carModuleStr;
	}

	public Integer getTrafficStop() {
		return trafficStop;
	}

	public void setTrafficStop(Integer trafficStop) {
		this.trafficStop = trafficStop;
	}

	public String getAccidentReason() {
		return accidentReason;
	}

	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}

	public String getAccidentForm() {
		return accidentForm;
	}

	public void setAccidentForm(String accidentForm) {
		this.accidentForm = accidentForm;
	}

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public String getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(String incidentNo) {
		this.incidentNo = incidentNo;
	}

	public String getSpotFinalReport() {
		return spotFinalReport;
	}

	public void setSpotFinalReport(String spotFinalReport) {
		this.spotFinalReport = spotFinalReport;
	}

	public String getCentreFinalReport() {
		return centreFinalReport;
	}

	public void setCentreFinalReport(String centreFinalReport) {
		this.centreFinalReport = centreFinalReport;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getGeographicInformation() {
		return geographicInformation;
	}

	public void setGeographicInformation(String geographicInformation) {
		this.geographicInformation = geographicInformation;
	}

	public String getAdministrativeOffice() {
		return administrativeOffice;
	}

	public void setAdministrativeOffice(String administrativeOffice) {
		this.administrativeOffice = administrativeOffice;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getIntervalStart() {
		return intervalStart;
	}

	public void setIntervalStart(String intervalStart) {
		this.intervalStart = intervalStart;
	}

	public String getIntervalEnd() {
		return intervalEnd;
	}

	public void setIntervalEnd(String intervalEnd) {
		this.intervalEnd = intervalEnd;
	}

	public Incident() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSubtype() {
		return subtype;
	}

	public void setSubtype(Integer subtype) {
		this.subtype = subtype;
	}

	public Integer getIncidentLevel() {
		return incidentLevel;
	}

	public void setIncidentLevel(Integer incidentLevel) {
		this.incidentLevel = incidentLevel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Integer getOrientation() {
		return orientation;
	}

	public void setOrientation(Integer orientation) {
		this.orientation = orientation;
	}

	public String getEffectedLane() {
		return effectedLane;
	}

	public void setEffectedLane(String effectedLane) {
		this.effectedLane = effectedLane;
	}

	public String getIncidentDesc() {
		return incidentDesc;
	}

	public void setIncidentDesc(String incidentDesc) {
		this.incidentDesc = incidentDesc;
	}

	public String getTrafficJam() {
		return trafficJam;
	}

	public void setTrafficJam(String trafficJam) {
		this.trafficJam = trafficJam;
	}

	public String getInjuried() {
		return injuried;
	}

	public void setInjuried(String injuried) {
		this.injuried = injuried;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIncidentName() {
		return incidentName;
	}

	public void setIncidentName(String incidentName) {
		this.incidentName = incidentName;
	}

	public Integer getExecuteStatus() {
		return executeStatus;
	}

	public void setExecuteStatus(Integer executeStatus) {
		this.executeStatus = executeStatus;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public Integer getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(Integer vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public Integer getInjuredNum() {
		return InjuredNum;
	}

	public void setInjuredNum(Integer injuredNum) {
		InjuredNum = injuredNum;
	}

	public Integer getDeathNum() {
		return deathNum;
	}

	public void setDeathNum(Integer deathNum) {
		this.deathNum = deathNum;
	}

	public String getIsCongestion() {
		return isCongestion;
	}

	public void setIsCongestion(String isCongestion) {
		this.isCongestion = isCongestion;
	}

	public Date getCongestionStart() {
		return congestionStart;
	}

	public void setCongestionStart(Date congestionStart) {
		this.congestionStart = congestionStart;
	}

	public Date getCongestionEnd() {
		return congestionEnd;
	}

	public void setCongestionEnd(Date congestionEnd) {
		this.congestionEnd = congestionEnd;
	}

	public String getIsSimulate() {
		return isSimulate;
	}

	public void setIsSimulate(String isSimulate) {
		this.isSimulate = isSimulate;
	}

}