
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getVmsTemplateByIdResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getVmsTemplateByIdResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsTemplate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getVmsTemplateByIdResponse", propOrder = {
    "_return"
})
public class GetVmsTemplateByIdResponse {

    @XmlElement(name = "return")
    protected VmsTemplate _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsTemplate }
     *     
     */
    public VmsTemplate getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsTemplate }
     *     
     */
    public void setReturn(VmsTemplate value) {
        this._return = value;
    }

}
