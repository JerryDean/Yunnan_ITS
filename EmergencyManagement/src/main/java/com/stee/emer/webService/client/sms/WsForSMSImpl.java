package com.stee.emer.webService.client.sms;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.6
 * 2016-05-19T18:52:46.844+08:00
 * Generated source version: 3.0.6
 * 
 */
@WebServiceClient(name = "ws_ForSMSImpl", 
                  wsdlLocation = "http://192.168.0.182:8080/CCS_SMS_MGT/sms?wsdl",
                  targetNamespace = "http://impl.ws.sms.stee.com/") 
public class WsForSMSImpl extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.ws.sms.stee.com/", "ws_ForSMSImpl");
    public final static QName WsForSMSImplPort = new QName("http://impl.ws.sms.stee.com/", "Ws_ForSMSImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.0.182:8080/CCS_SMS_MGT/sms?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WsForSMSImpl.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://192.168.0.182:8080/CCS_SMS_MGT/sms?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WsForSMSImpl(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WsForSMSImpl(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsForSMSImpl() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsForSMSImpl(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsForSMSImpl(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WsForSMSImpl(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns WsForSMS
     */
    @WebEndpoint(name = "Ws_ForSMSImplPort")
    public WsForSMS getWsForSMSImplPort() {
        return super.getPort(WsForSMSImplPort, WsForSMS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsForSMS
     */
    @WebEndpoint(name = "Ws_ForSMSImplPort")
    public WsForSMS getWsForSMSImplPort(WebServiceFeature... features) {
        return super.getPort(WsForSMSImplPort, WsForSMS.class, features);
    }

}
