package com.stee.emer.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/** Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or licence agreement with ST Electronics Info-comm Systems PTE. LTD.
 *
 * Project Name : CCS_ERS_Mgt
 * <p>PackageName : com.stee.emer.entity</p>
 * <p>ClassName   : Inci_Person </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月8日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Alias("Inci_Person")
public class Inci_Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5255646345325848828L;

	//编号
	private String id;
	
	//事件Id
    private String incidentId;        
    
    //姓名
    private String name;             
    
    //所在单位
    private String unit;             
    
    //职务
    private String duty;              
    
    //联系电话
    private String phone;            
    
    //其他
    private String other;

	public Inci_Person() {
		super();
	}

	public Inci_Person(String id, String incidentId, String name, String unit, String duty, String phone,
			String other) {
		super();
		this.id = id;
		this.incidentId = incidentId;
		this.name = name;
		this.unit = unit;
		this.duty = duty;
		this.phone = phone;
		this.other = other;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "Inci_Person [id=" + id + ", incidentId=" + incidentId + ", name=" + name + ", unit=" + unit + ", duty="
				+ duty + ", phone=" + phone + ", other=" + other + "]";
	}     
    
    
}
