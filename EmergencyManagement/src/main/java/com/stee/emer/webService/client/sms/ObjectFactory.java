
package com.stee.emer.webService.client.sms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.stee.emer.webService.client.sms package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInellKeyWord_QNAME = new QName("http://ws.sms.stee.com/", "getInellKeyWord");
    private final static QName _GetInellKeyWordGBK_QNAME = new QName("http://ws.sms.stee.com/", "getInellKeyWordGBK");
    private final static QName _GetInellKeyWordGBKResponse_QNAME = new QName("http://ws.sms.stee.com/", "getInellKeyWordGBKResponse");
    private final static QName _GetInellKeyWordResponse_QNAME = new QName("http://ws.sms.stee.com/", "getInellKeyWordResponse");
    private final static QName _GetSendedNumAndBla_QNAME = new QName("http://ws.sms.stee.com/", "getSendedNumAndBla");
    private final static QName _GetSendedNumAndBlaGBK_QNAME = new QName("http://ws.sms.stee.com/", "getSendedNumAndBlaGBK");
    private final static QName _GetSendedNumAndBlaGBKResponse_QNAME = new QName("http://ws.sms.stee.com/", "getSendedNumAndBlaGBKResponse");
    private final static QName _GetSendedNumAndBlaResponse_QNAME = new QName("http://ws.sms.stee.com/", "getSendedNumAndBlaResponse");
    private final static QName _SendListSmsGBK_QNAME = new QName("http://ws.sms.stee.com/", "sendListSmsGBK");
    private final static QName _SendListSmsGBKResponse_QNAME = new QName("http://ws.sms.stee.com/", "sendListSmsGBKResponse");
    private final static QName _SendListSmsUTF8_QNAME = new QName("http://ws.sms.stee.com/", "sendListSmsUTF8");
    private final static QName _SendListSmsUTF8Response_QNAME = new QName("http://ws.sms.stee.com/", "sendListSmsUTF8Response");
    private final static QName _SendSms_QNAME = new QName("http://ws.sms.stee.com/", "sendSms");
    private final static QName _SendSmsGBK_QNAME = new QName("http://ws.sms.stee.com/", "sendSmsGBK");
    private final static QName _SendSmsGBKResponse_QNAME = new QName("http://ws.sms.stee.com/", "sendSmsGBKResponse");
    private final static QName _SendSmsResponse_QNAME = new QName("http://ws.sms.stee.com/", "sendSmsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.stee.emer.webService.client.sms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInellKeyWord }
     * 
     */
    public GetInellKeyWord createGetInellKeyWord() {
        return new GetInellKeyWord();
    }

    /**
     * Create an instance of {@link GetInellKeyWordGBK }
     * 
     */
    public GetInellKeyWordGBK createGetInellKeyWordGBK() {
        return new GetInellKeyWordGBK();
    }

    /**
     * Create an instance of {@link GetInellKeyWordGBKResponse }
     * 
     */
    public GetInellKeyWordGBKResponse createGetInellKeyWordGBKResponse() {
        return new GetInellKeyWordGBKResponse();
    }

    /**
     * Create an instance of {@link GetInellKeyWordResponse }
     * 
     */
    public GetInellKeyWordResponse createGetInellKeyWordResponse() {
        return new GetInellKeyWordResponse();
    }

    /**
     * Create an instance of {@link GetSendedNumAndBla }
     * 
     */
    public GetSendedNumAndBla createGetSendedNumAndBla() {
        return new GetSendedNumAndBla();
    }

    /**
     * Create an instance of {@link GetSendedNumAndBlaGBK }
     * 
     */
    public GetSendedNumAndBlaGBK createGetSendedNumAndBlaGBK() {
        return new GetSendedNumAndBlaGBK();
    }

    /**
     * Create an instance of {@link GetSendedNumAndBlaGBKResponse }
     * 
     */
    public GetSendedNumAndBlaGBKResponse createGetSendedNumAndBlaGBKResponse() {
        return new GetSendedNumAndBlaGBKResponse();
    }

    /**
     * Create an instance of {@link GetSendedNumAndBlaResponse }
     * 
     */
    public GetSendedNumAndBlaResponse createGetSendedNumAndBlaResponse() {
        return new GetSendedNumAndBlaResponse();
    }

    /**
     * Create an instance of {@link SendListSmsGBK }
     * 
     */
    public SendListSmsGBK createSendListSmsGBK() {
        return new SendListSmsGBK();
    }

    /**
     * Create an instance of {@link SendListSmsGBKResponse }
     * 
     */
    public SendListSmsGBKResponse createSendListSmsGBKResponse() {
        return new SendListSmsGBKResponse();
    }

    /**
     * Create an instance of {@link SendListSmsUTF8 }
     * 
     */
    public SendListSmsUTF8 createSendListSmsUTF8() {
        return new SendListSmsUTF8();
    }

    /**
     * Create an instance of {@link SendListSmsUTF8Response }
     * 
     */
    public SendListSmsUTF8Response createSendListSmsUTF8Response() {
        return new SendListSmsUTF8Response();
    }

    /**
     * Create an instance of {@link SendSms }
     * 
     */
    public SendSms createSendSms() {
        return new SendSms();
    }

    /**
     * Create an instance of {@link SendSmsGBK }
     * 
     */
    public SendSmsGBK createSendSmsGBK() {
        return new SendSmsGBK();
    }

    /**
     * Create an instance of {@link SendSmsGBKResponse }
     * 
     */
    public SendSmsGBKResponse createSendSmsGBKResponse() {
        return new SendSmsGBKResponse();
    }

    /**
     * Create an instance of {@link SendSmsResponse }
     * 
     */
    public SendSmsResponse createSendSmsResponse() {
        return new SendSmsResponse();
    }

    /**
     * Create an instance of {@link ResultInfo }
     * 
     */
    public ResultInfo createResultInfo() {
        return new ResultInfo();
    }

    /**
     * Create an instance of {@link SendedAndBlaInfo }
     * 
     */
    public SendedAndBlaInfo createSendedAndBlaInfo() {
        return new SendedAndBlaInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInellKeyWord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getInellKeyWord")
    public JAXBElement<GetInellKeyWord> createGetInellKeyWord(GetInellKeyWord value) {
        return new JAXBElement<GetInellKeyWord>(_GetInellKeyWord_QNAME, GetInellKeyWord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInellKeyWordGBK }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getInellKeyWordGBK")
    public JAXBElement<GetInellKeyWordGBK> createGetInellKeyWordGBK(GetInellKeyWordGBK value) {
        return new JAXBElement<GetInellKeyWordGBK>(_GetInellKeyWordGBK_QNAME, GetInellKeyWordGBK.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInellKeyWordGBKResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getInellKeyWordGBKResponse")
    public JAXBElement<GetInellKeyWordGBKResponse> createGetInellKeyWordGBKResponse(GetInellKeyWordGBKResponse value) {
        return new JAXBElement<GetInellKeyWordGBKResponse>(_GetInellKeyWordGBKResponse_QNAME, GetInellKeyWordGBKResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInellKeyWordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getInellKeyWordResponse")
    public JAXBElement<GetInellKeyWordResponse> createGetInellKeyWordResponse(GetInellKeyWordResponse value) {
        return new JAXBElement<GetInellKeyWordResponse>(_GetInellKeyWordResponse_QNAME, GetInellKeyWordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSendedNumAndBla }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getSendedNumAndBla")
    public JAXBElement<GetSendedNumAndBla> createGetSendedNumAndBla(GetSendedNumAndBla value) {
        return new JAXBElement<GetSendedNumAndBla>(_GetSendedNumAndBla_QNAME, GetSendedNumAndBla.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSendedNumAndBlaGBK }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getSendedNumAndBlaGBK")
    public JAXBElement<GetSendedNumAndBlaGBK> createGetSendedNumAndBlaGBK(GetSendedNumAndBlaGBK value) {
        return new JAXBElement<GetSendedNumAndBlaGBK>(_GetSendedNumAndBlaGBK_QNAME, GetSendedNumAndBlaGBK.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSendedNumAndBlaGBKResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getSendedNumAndBlaGBKResponse")
    public JAXBElement<GetSendedNumAndBlaGBKResponse> createGetSendedNumAndBlaGBKResponse(GetSendedNumAndBlaGBKResponse value) {
        return new JAXBElement<GetSendedNumAndBlaGBKResponse>(_GetSendedNumAndBlaGBKResponse_QNAME, GetSendedNumAndBlaGBKResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSendedNumAndBlaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "getSendedNumAndBlaResponse")
    public JAXBElement<GetSendedNumAndBlaResponse> createGetSendedNumAndBlaResponse(GetSendedNumAndBlaResponse value) {
        return new JAXBElement<GetSendedNumAndBlaResponse>(_GetSendedNumAndBlaResponse_QNAME, GetSendedNumAndBlaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendListSmsGBK }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendListSmsGBK")
    public JAXBElement<SendListSmsGBK> createSendListSmsGBK(SendListSmsGBK value) {
        return new JAXBElement<SendListSmsGBK>(_SendListSmsGBK_QNAME, SendListSmsGBK.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendListSmsGBKResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendListSmsGBKResponse")
    public JAXBElement<SendListSmsGBKResponse> createSendListSmsGBKResponse(SendListSmsGBKResponse value) {
        return new JAXBElement<SendListSmsGBKResponse>(_SendListSmsGBKResponse_QNAME, SendListSmsGBKResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendListSmsUTF8 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendListSmsUTF8")
    public JAXBElement<SendListSmsUTF8> createSendListSmsUTF8(SendListSmsUTF8 value) {
        return new JAXBElement<SendListSmsUTF8>(_SendListSmsUTF8_QNAME, SendListSmsUTF8 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendListSmsUTF8Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendListSmsUTF8Response")
    public JAXBElement<SendListSmsUTF8Response> createSendListSmsUTF8Response(SendListSmsUTF8Response value) {
        return new JAXBElement<SendListSmsUTF8Response>(_SendListSmsUTF8Response_QNAME, SendListSmsUTF8Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSms }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendSms")
    public JAXBElement<SendSms> createSendSms(SendSms value) {
        return new JAXBElement<SendSms>(_SendSms_QNAME, SendSms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSmsGBK }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendSmsGBK")
    public JAXBElement<SendSmsGBK> createSendSmsGBK(SendSmsGBK value) {
        return new JAXBElement<SendSmsGBK>(_SendSmsGBK_QNAME, SendSmsGBK.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSmsGBKResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendSmsGBKResponse")
    public JAXBElement<SendSmsGBKResponse> createSendSmsGBKResponse(SendSmsGBKResponse value) {
        return new JAXBElement<SendSmsGBKResponse>(_SendSmsGBKResponse_QNAME, SendSmsGBKResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendSmsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sms.stee.com/", name = "sendSmsResponse")
    public JAXBElement<SendSmsResponse> createSendSmsResponse(SendSmsResponse value) {
        return new JAXBElement<SendSmsResponse>(_SendSmsResponse_QNAME, SendSmsResponse.class, null, value);
    }

}
