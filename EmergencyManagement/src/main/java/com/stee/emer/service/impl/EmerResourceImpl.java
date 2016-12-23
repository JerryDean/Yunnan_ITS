package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Resource;
import com.stee.emer.mapper.EmerResourceMapper;
import com.stee.emer.service.IEmerResource;
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
 * Project Name : CCS_ERS_Mgt
 * <p>
 * PackageName : com.stee.emer.service.impl
 * </p>
 * <p>
 * ClassName : EmerResourceImpl
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
@Service
public class EmerResourceImpl implements IEmerResource {

	@Autowired
	EmerResourceMapper emerResourceMapper;

	@Override
	public Result addResource(Resource resource) {

		Result result = new Result();

		if (resource != null) {

			int num = emerResourceMapper.addResource(resource);
			String id = resource.getId();

			if (num >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(resource);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result updateResource(Resource resource) {

		Result result = new Result();

		if (resource != null) {

			int num = emerResourceMapper.updateResource(resource);

			if (num >= 1) {

				result.setId(resource.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(resource);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}
		return result;
	}

	@Override
	public Result findResourceById(String id) {

		Result result = new Result();

		if (id != null && !"".equals(id)) {

			List<Resource> resource = emerResourceMapper.findResourceById(id);

			result.setId(id);
			result.setData(resource);
			if (null == resource || resource.isEmpty()) {
				result.setStatusCode(Utils.OBJECT_NOT_EXIST);
			} else {
				result.setStatusCode(Utils.SUCCESS);
			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result getAllResource() {

		Result result = new Result();

		List<Resource> list = emerResourceMapper.getAllResource();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result deleteResource(List<String> list) {

		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (list.size() != 0) {

			for (String id : list) {

				int num = emerResourceMapper.deleteResource(id);
				if (num >= 1) {

					reList.add(id + "::" + Utils.SUCCESS);
					ids.add(id);

				} else {

					reList.add(id + "::" + Utils.FAIL);
					result.setStatusCode(Utils.FAIL);

				}

			}

			Utils.logger.info(reList);
			result.setData(ids);

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		// if (resource != null) {
		//
		// int num = emerResourceMapper.deleteResource(resource);
		//
		// if (num >= 1) {
		//
		// result.setId(resource.getId());
		// result.setStatusCode(Utils.SUCCESS);
		// result.setUniqueData(resource);
		//
		// } else {
		//
		// result.setStatusCode(Utils.FAIL);
		//
		// }
		//
		// } else {
		//
		// result.setStatusCode(Utils.PARA_EXCEPTION);
		//
		// }

		return result;
	}

	@Override
	public Result findResourceByTAndL(Integer type, String location) {

		Result result = new Result();

		if (type == null || "".equals(type)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;

		}

		if (location == null || "".equals(location)) {

			result.setStatusCode(Utils.PARA_EXCEPTION);
			result.setId(null);
			return result;

		}

		List<Resource> list = emerResourceMapper.findResourceByTAndL(type, location);
		result.setData(list);
		result.setStatusCode(Utils.SUCCESS);

		return result;

	}

}
