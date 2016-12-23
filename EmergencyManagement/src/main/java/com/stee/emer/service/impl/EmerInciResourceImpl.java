package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Resource;
import com.stee.emer.mapper.EmerInciResourceMapper;
import com.stee.emer.service.IEmerInciResource;
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
 * <p>ClassName   : EmerInciResourceImpl </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月7日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Service
public class EmerInciResourceImpl implements IEmerInciResource {

	@Autowired
	EmerInciResourceMapper emerInciResourceMapper;
	
	@Override
	public Result addInciResource(Inci_Resource inciResource) {

		Result result = new Result();
		
		if (inciResource != null) {

			int num = emerInciResourceMapper.addInciResource(inciResource);
			String id = inciResource.getId();

			if (num >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(inciResource);

			} else {

				result.setStatusCode(Utils.FAIL);

			}
		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
		
	}

	@Override
	public Result deleteInciResource(List<String> id) {

		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (id.size() != 0) {

			for (String idnum : id) {

				int num = emerInciResourceMapper.deleteInciResource(idnum);
				if (num >= 1) {

					reList.add(idnum + "::" + Utils.SUCCESS);
					ids.add(idnum);

				} else {

					reList.add(idnum + "::" + Utils.FAIL);
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
	public Result findInciResourceById(String id) {

		Result result = new Result();

		if (!"".equals(id) && id != null) {

			Inci_Resource inciResource = emerInciResourceMapper.findInciResourceById(id);

			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(inciResource);


		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result getAllByIncidentId(String incidentId) {

		Result result = new Result();

		List<Inci_Resource> list = emerInciResourceMapper.getAllByIncidentId(incidentId);

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciResource() {

		Result result = new Result();

		List<Inci_Resource> list = emerInciResourceMapper.getAllInciResource();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result updateInciResource(Inci_Resource inciResource) {

		Result result = new Result();
		
		if (inciResource != null) {

			int num = emerInciResourceMapper.updateInciResource(inciResource);

			if (num >= 1) {

				result.setId(inciResource.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(inciResource);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);
		}

		return result;
	}

}
