package com.stee.emer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stee.emer.entity.Resource;

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
 * PackageName : com.stee.emer.mapper
 * </p>
 * <p>
 * ClassName : EmerResourceMapper
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
public interface EmerResourceMapper {

	public int addResource(Resource resource);

	public int updateResource(Resource resource);

	public int deleteResource(@Param("id") String id);

	public List<Resource> findResourceById(@Param("id") String id);

	public List<Resource> getAllResource();

	public List<Resource> findResourceByTAndL(@Param("type") Integer type, @Param("location") String location);

}
