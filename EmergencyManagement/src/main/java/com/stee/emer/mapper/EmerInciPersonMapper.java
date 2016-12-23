package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.Inci_Person;

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
 * <p>ClassName   : EmerInciPersonMapper </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月8日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface EmerInciPersonMapper {

	
	public int addInciPerson(Inci_Person inciPerson);
	
	public int deleteInciPerson(@Param("id")String id);
	
	public List<Inci_Person> getAllInciPerson();
	
	public List<Inci_Person> getAllInciPersonByIncidentId(@Param("incidentId")String incidentId);
	
	public Inci_Person findInciPersonById(@Param("id")String id);
	
	public int updateInciPerson(Inci_Person inciPerson);
	
}