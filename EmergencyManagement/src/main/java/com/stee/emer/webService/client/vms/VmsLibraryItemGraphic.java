
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsLibraryItemGraphic complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsLibraryItemGraphic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="graphicId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="graphicSeq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="pageSeq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsLibraryItemGraphic", propOrder = {
    "graphicId",
    "graphicSeq",
    "pageSeq"
})
public class VmsLibraryItemGraphic {

    protected Integer graphicId;
    protected Integer graphicSeq;
    protected Integer pageSeq;

    /**
     * 获取graphicId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicId() {
        return graphicId;
    }

    /**
     * 设置graphicId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicId(Integer value) {
        this.graphicId = value;
    }

    /**
     * 获取graphicSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicSeq() {
        return graphicSeq;
    }

    /**
     * 设置graphicSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicSeq(Integer value) {
        this.graphicSeq = value;
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

}
