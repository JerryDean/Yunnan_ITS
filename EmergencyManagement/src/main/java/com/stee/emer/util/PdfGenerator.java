package com.stee.emer.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : CCS_ERS_Mgt
 * File Name    : PdfGenerator.java
 * Author       : Jerry
 * Created      : 2017年1月4日 下午4:03:21
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
public class PdfGenerator {
	public static byte[] generate(Map<String, String> map) throws IOException, DocumentException {
		URL classPath = PdfGenerator.class.getClassLoader().getResource("");
		PdfReader pdfReader = new PdfReader(classPath + "com/stee/emer/model/model.pdf");
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PdfStamper pdfStamper = new PdfStamper(pdfReader, os);
		AcroFields acroFields = pdfStamper.getAcroFields();
		BaseFont baseFont = BaseFont.createFont(classPath + "MSYH.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		ArrayList<BaseFont> list = new ArrayList<BaseFont>();
		list.add(baseFont);
		acroFields.setSubstitutionFonts(list);
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			acroFields.setField(next.getKey(), next.getValue());
		}

		pdfStamper.setFormFlattening(true);
		pdfStamper.close();

		// File file = new File("e:/temp.pdf");
		// FileOutputStream fileOutputStream = new FileOutputStream(file);
		// fileOutputStream.write(os.toByteArray());
		// fileOutputStream.flush();
		// fileOutputStream.close();
		return os.toByteArray();
	}

}
