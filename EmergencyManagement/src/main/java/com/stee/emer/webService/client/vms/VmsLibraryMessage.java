
package com.stee.emer.webService.client.vms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsLibraryMessage complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsLibraryMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="category" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsCategory" minOccurs="0"/&gt;
 *         &lt;element name="graphics" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsLibraryItemGraphic" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="msgDisplayId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="msgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="template" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsTemplate" minOccurs="0"/&gt;
 *         &lt;element name="texts" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsLibraryItemText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsLibraryMessage", propOrder = {
    "category",
    "graphics",
    "msgDisplayId",
    "msgId",
    "template",
    "texts"
})
public class VmsLibraryMessage {

    protected VmsCategory category;
    @XmlElement(nillable = true)
    protected List<VmsLibraryItemGraphic> graphics;
    protected int msgDisplayId;
    protected String msgId;
    protected VmsTemplate template;
    @XmlElement(nillable = true)
    protected List<VmsLibraryItemText> texts;

    /**
     * 获取category属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsCategory }
     *     
     */
    public VmsCategory getCategory() {
        return category;
    }

    /**
     * 设置category属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsCategory }
     *     
     */
    public void setCategory(VmsCategory value) {
        this.category = value;
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
     * {@link VmsLibraryItemGraphic }
     * 
     * 
     */
    public List<VmsLibraryItemGraphic> getGraphics() {
        if (graphics == null) {
            graphics = new ArrayList<VmsLibraryItemGraphic>();
        }
        return this.graphics;
    }

    /**
     * 获取msgDisplayId属性的值。
     * 
     */
    public int getMsgDisplayId() {
        return msgDisplayId;
    }

    /**
     * 设置msgDisplayId属性的值。
     * 
     */
    public void setMsgDisplayId(int value) {
        this.msgDisplayId = value;
    }

    /**
     * 获取msgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置msgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
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
     * {@link VmsLibraryItemText }
     * 
     * 
     */
    public List<VmsLibraryItemText> getTexts() {
        if (texts == null) {
            texts = new ArrayList<VmsLibraryItemText>();
        }
        return this.texts;
    }

}
