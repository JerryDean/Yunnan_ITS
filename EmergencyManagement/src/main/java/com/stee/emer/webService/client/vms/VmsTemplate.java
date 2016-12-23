
package com.stee.emer.webService.client.vms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsTemplate complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsTemplate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deviceHeight" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deviceMaxMsgLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deviceMaxPages" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deviceType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="deviceWidth" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="templateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="templateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="templatePages" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsTemplatePage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsTemplate", propOrder = {
    "deviceHeight",
    "deviceMaxMsgLength",
    "deviceMaxPages",
    "deviceType",
    "deviceWidth",
    "templateId",
    "templateName",
    "templatePages"
})
public class VmsTemplate {

    protected int deviceHeight;
    protected int deviceMaxMsgLength;
    protected int deviceMaxPages;
    protected Integer deviceType;
    protected int deviceWidth;
    protected String templateId;
    protected String templateName;
    @XmlElement(nillable = true)
    protected List<VmsTemplatePage> templatePages;

    /**
     * 获取deviceHeight属性的值。
     * 
     */
    public int getDeviceHeight() {
        return deviceHeight;
    }

    /**
     * 设置deviceHeight属性的值。
     * 
     */
    public void setDeviceHeight(int value) {
        this.deviceHeight = value;
    }

    /**
     * 获取deviceMaxMsgLength属性的值。
     * 
     */
    public int getDeviceMaxMsgLength() {
        return deviceMaxMsgLength;
    }

    /**
     * 设置deviceMaxMsgLength属性的值。
     * 
     */
    public void setDeviceMaxMsgLength(int value) {
        this.deviceMaxMsgLength = value;
    }

    /**
     * 获取deviceMaxPages属性的值。
     * 
     */
    public int getDeviceMaxPages() {
        return deviceMaxPages;
    }

    /**
     * 设置deviceMaxPages属性的值。
     * 
     */
    public void setDeviceMaxPages(int value) {
        this.deviceMaxPages = value;
    }

    /**
     * 获取deviceType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * 设置deviceType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeviceType(Integer value) {
        this.deviceType = value;
    }

    /**
     * 获取deviceWidth属性的值。
     * 
     */
    public int getDeviceWidth() {
        return deviceWidth;
    }

    /**
     * 设置deviceWidth属性的值。
     * 
     */
    public void setDeviceWidth(int value) {
        this.deviceWidth = value;
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

    /**
     * 获取templateName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置templateName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

    /**
     * Gets the value of the templatePages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templatePages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplatePages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsTemplatePage }
     * 
     * 
     */
    public List<VmsTemplatePage> getTemplatePages() {
        if (templatePages == null) {
            templatePages = new ArrayList<VmsTemplatePage>();
        }
        return this.templatePages;
    }

}
