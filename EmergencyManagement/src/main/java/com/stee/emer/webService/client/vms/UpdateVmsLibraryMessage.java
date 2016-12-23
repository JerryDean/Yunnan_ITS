
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateVmsLibraryMessage complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateVmsLibraryMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="msg" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsLibraryMessage" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateVmsLibraryMessage", propOrder = {
    "msg"
})
public class UpdateVmsLibraryMessage {

    protected VmsLibraryMessage msg;

    /**
     * 获取msg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsLibraryMessage }
     *     
     */
    public VmsLibraryMessage getMsg() {
        return msg;
    }

    /**
     * 设置msg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsLibraryMessage }
     *     
     */
    public void setMsg(VmsLibraryMessage value) {
        this.msg = value;
    }

}
