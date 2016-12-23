
package com.stee.emer.webService.client.vms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsTemplatePage complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsTemplatePage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flashFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pageOffTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="pageOnTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="pageSeq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="templateGraphics" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsTemplateGraphic" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="templateTexts" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsTemplateText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsTemplatePage", propOrder = {
    "flashFlag",
    "pageOffTime",
    "pageOnTime",
    "pageSeq",
    "templateGraphics",
    "templateTexts"
})
public class VmsTemplatePage {

    protected String flashFlag;
    protected Integer pageOffTime;
    protected Integer pageOnTime;
    protected Integer pageSeq;
    @XmlElement(nillable = true)
    protected List<VmsTemplateGraphic> templateGraphics;
    @XmlElement(nillable = true)
    protected List<VmsTemplateText> templateTexts;

    /**
     * 获取flashFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlashFlag() {
        return flashFlag;
    }

    /**
     * 设置flashFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlashFlag(String value) {
        this.flashFlag = value;
    }

    /**
     * 获取pageOffTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageOffTime() {
        return pageOffTime;
    }

    /**
     * 设置pageOffTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageOffTime(Integer value) {
        this.pageOffTime = value;
    }

    /**
     * 获取pageOnTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageOnTime() {
        return pageOnTime;
    }

    /**
     * 设置pageOnTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageOnTime(Integer value) {
        this.pageOnTime = value;
    }

    /**
     * 获取pageSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageSeq() {
        return pageSeq;
    }

    /**
     * 设置pageSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageSeq(Integer value) {
        this.pageSeq = value;
    }

    /**
     * Gets the value of the templateGraphics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templateGraphics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplateGraphics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsTemplateGraphic }
     * 
     * 
     */
    public List<VmsTemplateGraphic> getTemplateGraphics() {
        if (templateGraphics == null) {
            templateGraphics = new ArrayList<VmsTemplateGraphic>();
        }
        return this.templateGraphics;
    }

    /**
     * Gets the value of the templateTexts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templateTexts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplateTexts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsTemplateText }
     * 
     * 
     */
    public List<VmsTemplateText> getTemplateTexts() {
        if (templateTexts == null) {
            templateTexts = new ArrayList<VmsTemplateText>();
        }
        return this.templateTexts;
    }

}
