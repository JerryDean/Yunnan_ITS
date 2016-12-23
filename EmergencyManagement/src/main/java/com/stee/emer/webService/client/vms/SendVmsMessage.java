
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sendVmsMessage complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sendVmsMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="msg" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsCurrentMessageSimple" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendVmsMessage", propOrder = {
    "msg"
})
public class SendVmsMessage {

    protected VmsCurrentMessageSimple msg;

    /**
     * 获取msg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsCurrentMessageSimple }
     *     
     */
    public VmsCurrentMessageSimple getMsg() {
        return msg;
    }

    /**
     * 设置msg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsCurrentMessageSimple }
     *     
     */
    public void setMsg(VmsCurrentMessageSimple value) {
        this.msg = value;
    }

}
