
package com.stee.emer.webService.client.vms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vmsTemplateGraphic complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vmsTemplateGraphic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flashFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="graphicAreaH" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="graphicAreaSeq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="graphicAreaW" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="graphicAreaX" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="graphicAreaY" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vmsTemplateGraphic", propOrder = {
    "flashFlag",
    "graphicAreaH",
    "graphicAreaSeq",
    "graphicAreaW",
    "graphicAreaX",
    "graphicAreaY"
})
public class VmsTemplateGraphic {

    protected String flashFlag;
    protected Integer graphicAreaH;
    protected Integer graphicAreaSeq;
    protected Integer graphicAreaW;
    protected Integer graphicAreaX;
    protected Integer graphicAreaY;

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
     * 获取graphicAreaH属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicAreaH() {
        return graphicAreaH;
    }

    /**
     * 设置graphicAreaH属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicAreaH(Integer value) {
        this.graphicAreaH = value;
    }

    /**
     * 获取graphicAreaSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicAreaSeq() {
        return graphicAreaSeq;
    }

    /**
     * 设置graphicAreaSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicAreaSeq(Integer value) {
        this.graphicAreaSeq = value;
    }

    /**
     * 获取graphicAreaW属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicAreaW() {
        return graphicAreaW;
    }

    /**
     * 设置graphicAreaW属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicAreaW(Integer value) {
        this.graphicAreaW = value;
    }

    /**
     * 获取graphicAreaX属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicAreaX() {
        return graphicAreaX;
    }

    /**
     * 设置graphicAreaX属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicAreaX(Integer value) {
        this.graphicAreaX = value;
    }

    /**
     * 获取graphicAreaY属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGraphicAreaY() {
        return graphicAreaY;
    }

    /**
     * 设置graphicAreaY属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGraphicAreaY(Integer value) {
        this.graphicAreaY = value;
    }

}
