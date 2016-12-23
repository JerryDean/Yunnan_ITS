
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsIllumBrightness complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsIllumBrightness"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eqtId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="illumLevel" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="illumMode" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsIllumBrightness", propOrder = {
    "eqtId",
    "illumLevel",
    "illumMode"
})
public class VmsIllumBrightness {

    protected String eqtId;
    protected int illumLevel;
    protected int illumMode;

    /**
     * 获取eqtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqtId() {
        return eqtId;
    }

    /**
     * 设置eqtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqtId(String value) {
        this.eqtId = value;
    }

    /**
     * 获取illumLevel属性的值。
     * 
     */
    public int getIllumLevel() {
        return illumLevel;
    }

    /**
     * 设置illumLevel属性的值。
     * 
     */
    public void setIllumLevel(int value) {
        this.illumLevel = value;
    }

    /**
     * 获取illumMode属性的值。
     * 
     */
    public int getIllumMode() {
        return illumMode;
    }

    /**
     * 设置illumMode属性的值。
     * 
     */
    public void setIllumMode(int value) {
        this.illumMode = value;
    }

}