package com.stee.emer.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
 * ClassName : Proposal
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
@Alias("Proposal")
public class Proposal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1155709429370407068L;

	// 预案编号
	private String id;

	// 预案名称
	private String name;

	// 预案描述
	private String description;

	// 事件类型
	private Integer type;

	// 事件子类型
	private Integer subtype;

	// 事件等级
	private Integer incidentLevel;

	// 预案生成时间
	private Date generate;

	// 预案最近修改时间
	private Date lastUpdate;

	// 预案内容
	private String content;
	//预案状态
	private String state;
	
	// 预案任务的映射
	private List<ProposalRelation> propMapping= new ArrayList<ProposalRelation>();
	
	public void setPropMapping(List<ProposalRelation> propMapping) {
		this.propMapping = propMapping;
	}
	public List<ProposalRelation> getPropMapping() {
		return propMapping;
	}
	public Proposal() {
		super();
	}

	public Proposal(String id, String name, String description, Integer type, Integer subtype, Integer incidentLevel,
			Date generate, Date lastUpdate, String content,String state) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.subtype = subtype;
		this.incidentLevel = incidentLevel;
		this.generate = generate;
		this.lastUpdate = lastUpdate;
		this.content = content;
		this.state=state;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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

	public Date getGenerate() {
		return generate;
	}

	public void setGenerate(Date generate) {
		this.generate = generate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "Proposal [id=" + id + ", name=" + name + ", description="
				+ description + ", type=" + type + ", subtype=" + subtype
				+ ", incidentLevel=" + incidentLevel + ", generate=" + generate
				+ ", lastUpdate=" + lastUpdate + ", content=" + content
				+ ", state=" + state + ", propMapping=" + propMapping + "]";
	}
	

	
}
