package com.stee.emer.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;

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
public class ImageUtils {

	public static String getImgForm(String imgStr) {
		return imgStr.substring(imgStr.indexOf("/") + 1, imgStr.indexOf(";"));
	}

	public static String cutImgStr(String imgStr) {
		return imgStr.substring(imgStr.indexOf(",") + 1);
	}

	public static byte[] getImgBinary(String imgStr) {
		return Base64.decodeBase64(imgStr);
	}

	public static String getImgBase64Str(byte[] imgByte) {
		return Base64.encodeBase64String(imgByte);
	}

	public static String packageImageStr(String form, String imgStr) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("data:image/" + form + ";base64,");
		stringBuilder.append(imgStr);
		return stringBuilder.toString();
	}

	/**
	 * 压缩图片
	 * 
	 * @param imgByte
	 * @return
	 * @author Jerry
	 */
	public static byte[] compressImg(byte[] imgByte) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			GZIPOutputStream gos = new GZIPOutputStream(os);
			gos.write(imgByte);
			gos.finish();
			gos.flush();
			gos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] nByte = os.toByteArray();
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nByte;
	}

	/**
	 * 解压缩图片
	 * 
	 * @param imgByte
	 * @return
	 * @author Jerry
	 */
	public static byte[] uncompressImg(byte[] imgByte) {
		ByteArrayInputStream bis = new ByteArrayInputStream(imgByte);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPInputStream gis = null;
		try {
			gis = new GZIPInputStream(bis);
			int count;
			byte[] buf = new byte[1024];
			while ((count = gis.read(buf, 0, 1024)) != -1) {
				bos.write(buf, 0, count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] nByte = bos.toByteArray();
		try {
			bos.flush();
			bos.close();
			gis.close();
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nByte;
	}

}
