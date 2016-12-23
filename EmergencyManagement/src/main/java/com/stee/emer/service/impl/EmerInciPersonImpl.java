package com.stee.emer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stee.dsms.model.Result;
import com.stee.emer.entity.Inci_Person;
import com.stee.emer.mapper.EmerInciPersonMapper;
import com.stee.emer.service.IEmerInciPerson;
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
 * <p>ClassName   : EmerInciPersonImpl </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年3月8日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
@Service
public class EmerInciPersonImpl implements IEmerInciPerson {

	@Autowired
	EmerInciPersonMapper emerInciPersonMapper;
	
	@Override
	public Result addInciPerson(Inci_Person inciPerson) {
		
		Result result = new Result();
		
		if (inciPerson != null) {

			int num = emerInciPersonMapper.addInciPerson(inciPerson);
			String id = inciPerson.getId();

			if (num >= 1 && id != null && !"".equals(id)) {

				result.setId(id);
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(inciPerson);

			} else {

				result.setStatusCode(Utils.FAIL);

			}
		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result deleteInciPerson(List<String> id) {

		Result result = new Result();

		List<String> reList = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();

		result.setStatusCode(Utils.SUCCESS);

		if (id.size() != 0) {

			for (String idnum : id) {

				int num = emerInciPersonMapper.deleteInciPerson(idnum);
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
	public Result getAllInciPerson() {

		Result result = new Result();

		List<Inci_Person> list = emerInciPersonMapper.getAllInciPerson();

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result getAllInciPersonByIncidentId(String incidentId) {

		Result result = new Result();

		List<Inci_Person> list = emerInciPersonMapper.getAllInciPersonByIncidentId(incidentId);

		if (list != null) {

			result.setStatusCode(Utils.SUCCESS);
			result.setData(list);

		} else {

			result.setStatusCode(Utils.FAIL);

		}

		return result;
	}

	@Override
	public Result findInciPersonById(String id) {

		Result result = new Result();

		if (!"".equals(id) && id != null) {

			Inci_Person inciPerson = emerInciPersonMapper.findInciPersonById(id);

			result.setId(id);
			result.setStatusCode(Utils.SUCCESS);
			result.setUniqueData(inciPerson);


		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);

		}

		return result;
	}

	@Override
	public Result updateInciPerson(Inci_Person inciPerson) {

		Result result = new Result();
		
		if (inciPerson != null) {

			int num = emerInciPersonMapper.updateInciPerson(inciPerson);

			if (num >= 1) {

				result.setId(inciPerson.getId());
				result.setStatusCode(Utils.SUCCESS);
				result.setUniqueData(inciPerson);

			} else {

				result.setStatusCode(Utils.FAIL);

			}

		} else {

			result.setStatusCode(Utils.PARA_EXCEPTION);
		}

		return result;
	}

}
