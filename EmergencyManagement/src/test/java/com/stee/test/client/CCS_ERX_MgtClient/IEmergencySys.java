package com.stee.test.client.CCS_ERX_MgtClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2016-01-12T15:20:16.617+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebService(targetNamespace = "http://webService.emer.stee.com/", name = "IEmergencySys")
@XmlSeeAlso({ObjectFactory.class})
public interface IEmergencySys {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllIncident", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.GetAllIncident")
    @WebMethod
    @ResponseWrapper(localName = "getAllIncidentResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.GetAllIncidentResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result getAllIncident();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addResource", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.AddResource")
    @WebMethod
    @ResponseWrapper(localName = "addResourceResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.AddResourceResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result addResource(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Resource arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findIncidentById", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.FindIncidentById")
    @WebMethod
    @ResponseWrapper(localName = "findIncidentByIdResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.FindIncidentByIdResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result findIncidentById(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addIncident", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.AddIncident")
    @WebMethod
    @ResponseWrapper(localName = "addIncidentResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.AddIncidentResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result addIncident(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Incident arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteResource", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.DeleteResource")
    @WebMethod
    @ResponseWrapper(localName = "deleteResourceResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.DeleteResourceResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result deleteResource(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Resource arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findResourceById", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.FindResourceById")
    @WebMethod
    @ResponseWrapper(localName = "findResourceByIdResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.FindResourceByIdResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result findResourceById(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addProposal", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.AddProposal")
    @WebMethod
    @ResponseWrapper(localName = "addProposalResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.AddProposalResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result addProposal(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Proposal arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllResource", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.GetAllResource")
    @WebMethod
    @ResponseWrapper(localName = "getAllResourceResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.GetAllResourceResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result getAllResource();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findProposalById", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.FindProposalById")
    @WebMethod
    @ResponseWrapper(localName = "findProposalByIdResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.FindProposalByIdResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result findProposalById(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteIncident", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.DeleteIncident")
    @WebMethod
    @ResponseWrapper(localName = "deleteIncidentResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.DeleteIncidentResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result deleteIncident(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Incident arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "updateResource", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.UpdateResource")
    @WebMethod
    @ResponseWrapper(localName = "updateResourceResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.UpdateResourceResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result updateResource(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Resource arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "updateProposal", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.UpdateProposal")
    @WebMethod
    @ResponseWrapper(localName = "updateProposalResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.UpdateProposalResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result updateProposal(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Proposal arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getAllProposal", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.GetAllProposal")
    @WebMethod
    @ResponseWrapper(localName = "getAllProposalResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.GetAllProposalResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result getAllProposal();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "updateIncident", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.UpdateIncident")
    @WebMethod
    @ResponseWrapper(localName = "updateIncidentResponse", targetNamespace = "http://webService.emer.stee.com/", className = "com.stee.test.client.CCS_ERX_MgtClient.UpdateIncidentResponse")
    public com.stee.test.client.CCS_ERX_MgtClient.Result updateIncident(
        @WebParam(name = "arg0", targetNamespace = "")
        com.stee.test.client.CCS_ERX_MgtClient.Incident arg0
    );
}
