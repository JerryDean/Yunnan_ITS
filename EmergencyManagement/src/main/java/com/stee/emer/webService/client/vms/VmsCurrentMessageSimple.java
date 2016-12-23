
package com.stee.emer.webService.client.vms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsCurrentMessageSimple complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsCurrentMessageSimple"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="currGraphics" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsMessageGraphic" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="currTexts" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsMessageText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="eqtId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsCurrentMessageSimple", propOrder = {
    "currGraphics",
    "currTexts",
    "eqtId",
    "templateId"
})
public class VmsCurrentMessageSimple {

    @XmlElement(nillable = true)
    protected List<VmsMessageGraphic> currGraphics;
    @XmlElement(nillable = true)
    protected List<VmsMessageText> currTexts;
    protected String eqtId;
    protected String templateId;

    /**
     * Gets the value of the currGraphics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currGraphics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrGraphics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsMessageGraphic }
     * 
     * 
     */
    public List<VmsMessageGraphic> getCurrGraphics() {
        if (currGraphics == null) {
            currGraphics = new ArrayList<VmsMessageGraphic>();
        }
        return this.currGraphics;
    }

    /**
     * Gets the value of the currTexts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currTexts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrTexts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsMessageText }
     * 
     * 
     */
    public List<VmsMessageText> getCurrTexts() {
        if (currTexts == null) {
            currTexts = new ArrayList<VmsMessageText>();
        }
        return this.currTexts;
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
     * 获取templateId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * 设置templateId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateId(String value) {
        this.templateId = value;
    }

}
