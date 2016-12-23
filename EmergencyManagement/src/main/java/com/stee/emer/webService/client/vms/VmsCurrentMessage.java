
package com.stee.emer.webService.client.vms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsCurrentMessage complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsCurrentMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eqtId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="graphics" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsMessageGraphic" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="msgContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="template" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsTemplate" minOccurs="0"/&gt;
 *         &lt;element name="texts" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsMessageText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsCurrentMessage", propOrder = {
    "eqtId",
    "graphics",
    "msgContent",
    "template",
    "texts"
})
public class VmsCurrentMessage {

    protected String eqtId;
    @XmlElement(nillable = true)
    protected List<VmsMessageGraphic> graphics;
    protected String msgContent;
    protected VmsTemplate template;
    @XmlElement(nillable = true)
    protected List<VmsMessageText> texts;

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
     * Gets the value of the graphics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the graphics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGraphics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsMessageGraphic }
     * 
     * 
     */
    public List<VmsMessageGraphic> getGraphics() {
        if (graphics == null) {
            graphics = new ArrayList<VmsMessageGraphic>();
        }
        return this.graphics;
    }

    /**
     * 获取msgContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * 设置msgContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgContent(String value) {
        this.msgContent = value;
    }

    /**
     * 获取template属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsTemplate }
     *     
     */
    public VmsTemplate getTemplate() {
        return template;
    }

    /**
     * 设置template属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsTemplate }
     *     
     */
    public void setTemplate(VmsTemplate value) {
        this.template = value;
    }

    /**
     * Gets the value of the texts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the texts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTexts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmsMessageText }
     * 
     * 
     */
    public List<VmsMessageText> getTexts() {
        if (texts == null) {
            texts = new ArrayList<VmsMessageText>();
        }
        return this.texts;
    }

}
