package com.stee.emer.util;

import org.aspectj.lang.JoinPoint;

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
 * <p>PackageName : com.stee.emer.util</p>
 * <p>ClassName   : ParaAop </p>
 * <p>Description : This is a ...
 * ... class doing ... </p>
 * <p>Created On  :2016年2月25日</p>
 *
 * @author DengBW
 * @version 1.0
 *
 */
public class ParaAop {

	public void printPara(JoinPoint j) {
		
		Object [] obj = j.getArgs();
		
		if(obj.length == 0) {
			
			return;
			
		}
		
		for(Object o : obj) {
			
			Utils.logger.info(o.getClass().getName()+" : "+o);
			
		}
	}
	
}
