/*    */ package com.stee.emer.util;
/*    */ 
/*    */ import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
/*    */ 
/*    */ public class ConvertToXMLGregorian
/*    */ {
/*    */   public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date)
/*    */   {
/* 34 */     GregorianCalendar cal = new GregorianCalendar();
/* 35 */     cal.setTime(date);
/* 36 */     XMLGregorianCalendar gc = null;
/*    */     try {
/* 38 */       gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
/*    */     } catch (DatatypeConfigurationException e) {
	e.printStackTrace();
/* 40 */      // ConfigUtil.log.info("There are some error for convert java.util.Date to XMLGregorianCalendar", e);
/*    */     }
/* 42 */     return gc;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\classes\
 * Qualified Name:     com.stee.trafficDataManagement.util.ConvertToXMLGregorian
 * JD-Core Version:    0.6.0
 */