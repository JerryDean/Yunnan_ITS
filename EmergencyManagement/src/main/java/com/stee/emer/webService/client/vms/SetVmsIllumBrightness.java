
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>setVmsIllumBrightness complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="setVmsIllumBrightness"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="brightness" type="{http://server.ws.CCS_VMS_Mgt.stee.com/}vmsIllumBrightness" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setVmsIllumBrightness", propOrder = {
    "brightness"
})
public class SetVmsIllumBrightness {

    protected VmsIllumBrightness brightness;

    /**
     * 获取brightness属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VmsIllumBrightness }
     *     
     */
    public VmsIllumBrightness getBrightness() {
        return brightness;
    }

    /**
     * 设置brightness属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VmsIllumBrightness }
     *     
     */
    public void setBrightness(VmsIllumBrightness value) {
        this.brightness = value;
    }

}
