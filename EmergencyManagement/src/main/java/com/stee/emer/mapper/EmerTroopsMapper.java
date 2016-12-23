package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.Troops;
import com.stee.emer.entity.TroopsResource;

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
public interface EmerTroopsMapper {

	int addTroops(Troops team);

	int updateTroops(Troops team);

	int deleteTroops(@Param("id") String id);

	int deleteTroopsByIncidentId(@Param("id") String id);

	List<Troops> getTroopsByIncidentId(@Param("id") String id);

	Troops findTroopsById(@Param("id") String id);

	List<Troops> getAllTroops();

	int addTroopsResource(TroopsResource resource);

	int findMaxId();

	int deleteTroopsResource(@Param("id") Integer id);

	List<TroopsResource> findTroopsResourceByTroopsId(@Param("id") String id);

	int updateTroopsResource(TroopsResource resource);

}
