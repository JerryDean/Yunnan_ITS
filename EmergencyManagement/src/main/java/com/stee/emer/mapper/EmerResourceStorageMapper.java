package com.stee.emer.mapper;

import java.util.List;

import com.stee.emer.entity.ResourceStorage;

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
 * <p>ClassName   : EmerResourceStorageMapper </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月25日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public interface EmerResourceStorageMapper {

	public int addResourceStorage(ResourceStorage resourceStorage);
	
	public int deleteResourceStorage(String id);
	
	public int updateResourceStorage(ResourceStorage resourceStorage);
	
	public List<ResourceStorage> getResourceStorage();
	
	public ResourceStorage findResourceStorageById(String id);
}
