
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>updateVmsGraphic complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="updateVmsGraphic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="graphic" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsGraphic" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateVmsGraphic", propOrder = {
    "graphic"
})
public class UpdateVmsGraphic {

    protected VmsGraphic graphic;

    /**
     * 获取graphic属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsGraphic }
     *     
     */
    public VmsGraphic getGraphic() {
        return graphic;
    }

    /**
     * 设置graphic属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsGraphic }
     *     
     */
    public void setGraphic(VmsGraphic value) {
        this.graphic = value;
    }

}
