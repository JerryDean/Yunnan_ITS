package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.ResourceStorage;
import com.stee.emer.mapper.EmerResourceStorageMapper;
import com.stee.emer.service.IEmerResourceStorage;
import com.stee.emer.util.Utils;

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
 * <p>PackageName : com.stee.emer.service.impl</p>
 * <p>ClassName   : EmerResourceStorageImpl </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月25日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Service
public class EmerResourceStorageImpl implements IEmerResourceStorage {

	@Autowired
	EmerResourceStorageMapper emerResourceStorageMapper;
	
	@Override
	public Result addResourceStorage(ResourceStorage resourceStorage) {
		
		Result result = new Result();
	
		if (resourceStorage != null) {

			int num = emerResourceStorageMapper.addResourceStorage(resourceStorage);
			String id = resourceStorage.getId();
			// System.out.println(incident);

			if (num >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(resourceStorage);

			} else {

				result.setStatusCode(Utils.FAIL);

			}
		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
		
	}

	@Override
	public Result deleteResourceStorage(List<String> list) {
		
		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (list.size() != 0) {

			for (String id : list) {

				int num = emerResourceStorageMapper.deleteResourceStorage(id);
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

		return result;
		
	}

	@Override
	public Result updateResourceStorage(ResourceStorage resourceStorage) {
		
		Result result = new Result();
		
		if (resourceStorage != null) {

			int num = emerResourceStorageMapper.updateResourceStorage(resourceStorage);

			if (num >= 1) {

				result.setId(resourceStorage.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(resourceStorage);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);
		}

		return result;
		
	}

	@Override
	public Result getResourceStorage() {
		
		Result result = new Result();

		List<ResourceStorage> list = emerResourceStorageMapper.getResourceStorage();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
		
	}

	@Override
	public Result findResourceStorageById(String id) {
		
		Result result = new Result();

		if (!"".equals(id) && id != null) {

			ResourceStorage resourceStorage = emerResourceStorageMapper.findResourceStorageById(id);


			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(resourceStorage);


		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

}
