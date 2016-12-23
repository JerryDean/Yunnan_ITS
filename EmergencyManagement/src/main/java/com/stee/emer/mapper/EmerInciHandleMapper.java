package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.Inci_Handle;

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
 * <p>PackageName : com.stee.emer.mapper</p>
 * <p>ClassName   : EmerInciHandleMapper </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月7日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface EmerInciHandleMapper {

	public int addInciHandle(Inci_Handle inciHandle);
	
	public int deleteInciHandle(@Param("id")String id);
	
	public List<Inci_Handle> getAllInciHandleByIncidentId(@Param("incidentId")String incidentId);
	
	public List<Inci_Handle> getAllInciHandle();
	
	public Inci_Handle findInciHandleById(@Param("id")String id);
	
	public int updateInciHandle(Inci_Handle inciHandle);
}
