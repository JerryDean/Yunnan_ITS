
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>deleteVmsGraphic complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="deleteVmsGraphic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="graphicId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteVmsGraphic", propOrder = {
    "graphicId"
})
public class DeleteVmsGraphic {

    protected int graphicId;

    /**
     * 获取graphicId属性的值。
     * 
     */
    public int getGraphicId() {
        return graphicId;
    }

    /**
     * 设置graphicId属性的值。
     * 
     */
    public void setGraphicId(int value) {
        this.graphicId = value;
    }

}
