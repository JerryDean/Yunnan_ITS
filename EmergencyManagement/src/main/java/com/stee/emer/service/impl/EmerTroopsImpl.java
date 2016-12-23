package com.stee.emer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Troops;
import com.stee.emer.entity.TroopsResource;
import com.stee.emer.mapper.EmerTroopsMapper;
import com.stee.emer.service.IEmerTroops;
import com.stee.emer.util.Utils;

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
@Service
public class EmerTroopsImpl implements IEmerTroops {
	@Autowired
	EmerTroopsMapper troopsMapper;

	@Override
	public Result addTroops(Troops team) {
		Result result = new Result();
		if (null == team) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			int num = troopsMapper.addTroops(team);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}

		return result;
	}

	@Override
	public Result updateTroops(Troops team) {
		Result result = new Result();
		if (null == team) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			int num = troopsMapper.updateTroops(team);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result deleteTroops(List<String> ids) {
		Result result = new Result();
		if (ids.isEmpty()) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			int num = 0;
			for (String id : ids) {
				num += troopsMapper.deleteTroops(id);
			}

			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result deleteTroopsByIncidentId(String id) {
		Result result = new Result();
		if (null == id || id.equals("")) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			int num = troopsMapper.deleteTroopsByIncidentId(id);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result getTroopsByIncidentId(String id) {
		Result result = new Result();
		if (null == id || id.equals("")) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			List<Troops> list = troopsMapper.getTroopsByIncidentId(id);
			if (null != list && !list.isEmpty()) {
				result.setData(list);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.objectId);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result findTroopsById(String id) {
		Result result = new Result();
		if (null == id || id.equals("")) {
			result.setStatusCode(Utils.PARA_EXCEPTION);
			return result;
		}
		try {
			Troops troops = troopsMapper.findTroopsById(id);
			if (null != troops) {
				result.setUniqueData(troops);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result getAllTroops() {
		Result result = new Result();
		try {
			List<Troops> list = troopsMapper.getAllTroops();
			if (!list.isEmpty()) {
				result.setData(list);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result addTroopsResource(TroopsResource resource) {
		Result result = new Result();
		try {
			if (null == resource.getType() || null == resource.getName() || null == resource.getTroopsId()) {
				result.setStatusCode(Utils.PARA_EXCEPTION);
				return result;
			}
			int maxId = troopsMapper.findMaxId();
			if (maxId != -1)
				resource.setId(++maxId);
			int num = troopsMapper.addTroopsResource(resource);
			if (num != -1) {
				result.setId(String.valueOf(resource.getId()));
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.FAIL);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result deleteTroopsResource(Integer id) {
		Result result = new Result();
		result.setId(String.valueOf(id));
		try {
			int num = troopsMapper.deleteTroopsResource(id);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result findTroopsResourceByTroopsId(String id) {
		Result result = new Result();
		try {
			List<TroopsResource> list = troopsMapper.findTroopsResourceByTroopsId(id);
			if (null != list && !list.isEmpty()) {
				result.setData(list);
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

	@Override
	public Result updateTroopsResource(TroopsResource resource) {
		Result result = new Result();
		try {
			int num = troopsMapper.updateTroopsResource(resource);
			if (num != -1) {
				result.setStatusCode(Utils.SUCCESS);
			} else {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			}
		} catch (Exception e) {
			result.setStatusCode(Utils.FAIL);
		}
		return result;
	}

}
