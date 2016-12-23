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
 * Project Name : CCS_ERS_Mgt
 * <p>
 * PackageName : com.stee.emer.entity
 * </p>
 * <p>
 * ClassName : Inci_Resource
 * </p>
 * <p>
 * Description : This is a ... ... class doing ...
 * </p>
 * <p>
 * Created On :2016年3月7日
 * </p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Alias("Inci_Resource")
public class Inci_Resource implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 745953170809277005L;

	// 编号
	private String id;

	// 事件Id
	private String incidentId;

	// 物资名称
	private String name;

	// 物资类型
	private String type;

	// 物资库编号
	private String storageId;

	// 规格
	private String specification;

	// 数量
	private Integer count;

	// 单位
	private String unit;

	// 更新时间
	private Date updateTime;

	// 备注
	private String remark;

	// 联系人
	private String contact;

	// 联系电话
	private String phone;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人
	 */
	private String createBy;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 单价
	 */
	private Double price;

	/**
	 * 审核状态(0-未通过，1-审核通过)
	 */
	private Integer status;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Inci_Resource [id=" + id + ", incidentId=" + incidentId + ", name=" + name + ", type=" + type
				+ ", storageId=" + storageId + ", specification=" + specification + ", count=" + count + ", unit="
				+ unit + ", updateTime=" + updateTime + ", remark=" + remark + ", contact=" + contact + ", phone="
				+ phone + ", createTime=" + createTime + ", createBy=" + createBy + ", updateBy=" + updateBy
				+ ", price=" + price + ", status=" + status + "]";
	}

}
