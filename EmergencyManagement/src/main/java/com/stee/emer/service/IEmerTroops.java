package com.stee.emer.service;

import java.util.List;

import com.stee.dsms.model.Result;
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
public interface IEmerTroops {

	Result addTroops(Troops team);

	Result updateTroops(Troops team);

	Result deleteTroops(List<String> ids);

	Result deleteTroopsByIncidentId(String id);

	Result getTroopsByIncidentId(String id);

	Result findTroopsById(String id);

	Result getAllTroops();

	Result addTroopsResource(TroopsResource resource);

	Result deleteTroopsResource(Integer id);

	Result findTroopsResourceByTroopsId(String id);

	Result updateTroopsResource(TroopsResource resource);

}
