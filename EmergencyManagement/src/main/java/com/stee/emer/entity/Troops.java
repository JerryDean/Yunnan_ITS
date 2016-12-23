package com.stee.emer.entity;

import org.apache.ibatis.type.Alias;

@Alias("Troops")
public class Troops {
	private String id;
	/**
	 * 应急队伍名称
	 */
	private String name;
	/**
	 * 人员编制
	 */
	private Integer headCount;
	/**
	 * 指挥官
	 */
	private String commander;
	/**
	 * 指挥官联系电话
	 */
	private String commanderPhone;
	/**
	 * 联络人
	 */
	private String liaisonMan;
	/**
	 * 联络人联系电话
	 */
	private String liaisonPhone;
	/**
	 * 应急事件编号
	 */
	private String incidentId;

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeadCount() {
		return headCount;
	}

	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	public String getCommander() {
		return commander;
	}

	public void setCommander(String commander) {
		this.commander = commander;
	}

	public String getCommanderPhone() {
		return commanderPhone;
	}

	public void setCommanderPhone(String commanderPhone) {
		this.commanderPhone = commanderPhone;
	}

	public String getLiaisonMan() {
		return liaisonMan;
	}

	public void setLiaisonMan(String liaisonMan) {
		this.liaisonMan = liaisonMan;
	}

	public String getLiaisonPhone() {
		return liaisonPhone;
	}

	public void setLiaisonPhone(String liaisonPhone) {
		this.liaisonPhone = liaisonPhone;
	}

	@Override
	public String toString() {
		return "Troops [id=" + id + ", name=" + name + ", headCount=" + headCount + ", commander=" + commander
				+ ", commanderPhone=" + commanderPhone + ", liaisonMan=" + liaisonMan + ", liaisonPhone=" + liaisonPhone
				+ ", incidentId=" + incidentId + "]";
	}

}
