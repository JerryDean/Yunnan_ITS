package com.stee.emer.entity;

import java.io.Serializable;
import java.util.Date;

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
@Alias("TroopsResource")
public class TroopsResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 资源编号
	 */
	private Integer id;

	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 资源类型
	 */
	private Integer type;

	/**
	 * 资源数量
	 */
	private String count;

	/**
	 * 资源单位
	 */
	private String unit;

	/**
	 * 资源备注
	 */
	private String remark;

	/**
	 * 单价
	 */
	private Double unitPrice;

	/**
	 * 总价
	 */
	private Double totalPrice;

	/**
	 * 创建人
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新人
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 应急队伍编号
	 */
	private String troopsId;

	public String getTroopsId() {
		return troopsId;
	}

	public void setTroopsId(String troopsId) {
		this.troopsId = troopsId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "TroopsResource [id=" + id + ", name=" + name + ", type=" + type + ", count=" + count + ", unit=" + unit
				+ ", remark=" + remark + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", createBy="
				+ createBy + ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate
				+ ", troopsId=" + troopsId + "]";
	}

}
