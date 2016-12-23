
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsCurrentStatus complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsCurrentStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="controlMode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="eqtId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstPageGraphicId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="firstPageLine1Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstPageLine2Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="illumLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="illumMode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="illumNumLevels" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsCurrentStatus", propOrder = {
    "controlMode",
    "eqtId",
    "firstPageGraphicId",
    "firstPageLine1Text",
    "firstPageLine2Text",
    "illumLevel",
    "illumMode",
    "illumNumLevels"
})
public class VmsCurrentStatus {

    protected Integer controlMode;
    protected String eqtId;
    protected Integer firstPageGraphicId;
    protected String firstPageLine1Text;
    protected String firstPageLine2Text;
    protected Integer illumLevel;
    protected Integer illumMode;
    protected Integer illumNumLevels;

    /**
     * 获取controlMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getControlMode() {
        return controlMode;
    }

    /**
     * 设置controlMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setControlMode(Integer value) {
        this.controlMode = value;
    }

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
     * 获取firstPageGraphicId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFirstPageGraphicId() {
        return firstPageGraphicId;
    }

    /**
     * 设置firstPageGraphicId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFirstPageGraphicId(Integer value) {
        this.firstPageGraphicId = value;
    }

    /**
     * 获取firstPageLine1Text属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstPageLine1Text() {
        return firstPageLine1Text;
    }

    /**
     * 设置firstPageLine1Text属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstPageLine1Text(String value) {
        this.firstPageLine1Text = value;
    }

    /**
     * 获取firstPageLine2Text属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstPageLine2Text() {
        return firstPageLine2Text;
    }

    /**
     * 设置firstPageLine2Text属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstPageLine2Text(String value) {
        this.firstPageLine2Text = value;
    }

    /**
     * 获取illumLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIllumLevel() {
        return illumLevel;
    }

    /**
     * 设置illumLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIllumLevel(Integer value) {
        this.illumLevel = value;
    }

    /**
     * 获取illumMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIllumMode() {
        return illumMode;
    }

    /**
     * 设置illumMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIllumMode(Integer value) {
        this.illumMode = value;
    }

    /**
     * 获取illumNumLevels属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIllumNumLevels() {
        return illumNumLevels;
    }

    /**
     * 设置illumNumLevels属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIllumNumLevels(Integer value) {
        this.illumNumLevels = value;
    }

}
