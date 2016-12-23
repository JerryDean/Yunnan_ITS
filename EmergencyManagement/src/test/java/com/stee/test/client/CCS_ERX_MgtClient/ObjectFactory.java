
package com.stee.test.client.CCS_ERX_MgtClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.stee.test.client.CCS_ERX_MgtClient package. 
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

    private final static QName _AddProposal_QNAME = new QName("http://webService.emer.stee.com/", "addProposal");
    private final static QName _AddResourceResponse_QNAME = new QName("http://webService.emer.stee.com/", "addResourceResponse");
    private final static QName _UpdateResourceResponse_QNAME = new QName("http://webService.emer.stee.com/", "updateResourceResponse");
    private final static QName _DeleteResourceResponse_QNAME = new QName("http://webService.emer.stee.com/", "deleteResourceResponse");
    private final static QName _GetAllProposalResponse_QNAME = new QName("http://webService.emer.stee.com/", "getAllProposalResponse");
    private final static QName _AddIncidentResponse_QNAME = new QName("http://webService.emer.stee.com/", "addIncidentResponse");
    private final static QName _DeleteResource_QNAME = new QName("http://webService.emer.stee.com/", "deleteResource");
    private final static QName _UpdateResource_QNAME = new QName("http://webService.emer.stee.com/", "updateResource");
    private final static QName _UpdateProposalResponse_QNAME = new QName("http://webService.emer.stee.com/", "updateProposalResponse");
    private final static QName _GetAllProposal_QNAME = new QName("http://webService.emer.stee.com/", "getAllProposal");
    private final static QName _FindResourceById_QNAME = new QName("http://webService.emer.stee.com/", "findResourceById");
    private final static QName _GetAllResourceResponse_QNAME = new QName("http://webService.emer.stee.com/", "getAllResourceResponse");
    private final static QName _FindProposalById_QNAME = new QName("http://webService.emer.stee.com/", "findProposalById");
    private final static QName _UpdateIncident_QNAME = new QName("http://webService.emer.stee.com/", "updateIncident");
    private final static QName _UpdateIncidentResponse_QNAME = new QName("http://webService.emer.stee.com/", "updateIncidentResponse");
    private final static QName _FindIncidentById_QNAME = new QName("http://webService.emer.stee.com/", "findIncidentById");
    private final static QName _GetAllIncidentResponse_QNAME = new QName("http://webService.emer.stee.com/", "getAllIncidentResponse");
    private final static QName _FindProposalByIdResponse_QNAME = new QName("http://webService.emer.stee.com/", "findProposalByIdResponse");
    private final static QName _FindResourceByIdResponse_QNAME = new QName("http://webService.emer.stee.com/", "findResourceByIdResponse");
    private final static QName _AddResource_QNAME = new QName("http://webService.emer.stee.com/", "addResource");
    private final static QName _DeleteIncident_QNAME = new QName("http://webService.emer.stee.com/", "deleteIncident");
    private final static QName _FindIncidentByIdResponse_QNAME = new QName("http://webService.emer.stee.com/", "findIncidentByIdResponse");
    private final static QName _GetAllResource_QNAME = new QName("http://webService.emer.stee.com/", "getAllResource");
    private final static QName _AddProposalResponse_QNAME = new QName("http://webService.emer.stee.com/", "addProposalResponse");
    private final static QName _DeleteIncidentResponse_QNAME = new QName("http://webService.emer.stee.com/", "deleteIncidentResponse");
    private final static QName _AddIncident_QNAME = new QName("http://webService.emer.stee.com/", "addIncident");
    private final static QName _GetAllIncident_QNAME = new QName("http://webService.emer.stee.com/", "getAllIncident");
    private final static QName _UpdateProposal_QNAME = new QName("http://webService.emer.stee.com/", "updateProposal");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.stee.test.client.CCS_ERX_MgtClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateResource }
     * 
     */
    public UpdateResource createUpdateResource() {
        return new UpdateResource();
    }

    /**
     * Create an instance of {@link DeleteResource }
     * 
     */
    public DeleteResource createDeleteResource() {
        return new DeleteResource();
    }

    /**
     * Create an instance of {@link AddIncidentResponse }
     * 
     */
    public AddIncidentResponse createAddIncidentResponse() {
        return new AddIncidentResponse();
    }

    /**
     * Create an instance of {@link GetAllProposalResponse }
     * 
     */
    public GetAllProposalResponse createGetAllProposalResponse() {
        return new GetAllProposalResponse();
    }

    /**
     * Create an instance of {@link DeleteResourceResponse }
     * 
     */
    public DeleteResourceResponse createDeleteResourceResponse() {
        return new DeleteResourceResponse();
    }

    /**
     * Create an instance of {@link UpdateResourceResponse }
     * 
     */
    public UpdateResourceResponse createUpdateResourceResponse() {
        return new UpdateResourceResponse();
    }

    /**
     * Create an instance of {@link AddResourceResponse }
     * 
     */
    public AddResourceResponse createAddResourceResponse() {
        return new AddResourceResponse();
    }

    /**
     * Create an instance of {@link AddProposal }
     * 
     */
    public AddProposal createAddProposal() {
        return new AddProposal();
    }

    /**
     * Create an instance of {@link UpdateProposal }
     * 
     */
    public UpdateProposal createUpdateProposal() {
        return new UpdateProposal();
    }

    /**
     * Create an instance of {@link GetAllIncident }
     * 
     */
    public GetAllIncident createGetAllIncident() {
        return new GetAllIncident();
    }

    /**
     * Create an instance of {@link DeleteIncidentResponse }
     * 
     */
    public DeleteIncidentResponse createDeleteIncidentResponse() {
        return new DeleteIncidentResponse();
    }

    /**
     * Create an instance of {@link AddProposalResponse }
     * 
     */
    public AddProposalResponse createAddProposalResponse() {
        return new AddProposalResponse();
    }

    /**
     * Create an instance of {@link AddIncident }
     * 
     */
    public AddIncident createAddIncident() {
        return new AddIncident();
    }

    /**
     * Create an instance of {@link FindIncidentByIdResponse }
     * 
     */
    public FindIncidentByIdResponse createFindIncidentByIdResponse() {
        return new FindIncidentByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllResource }
     * 
     */
    public GetAllResource createGetAllResource() {
        return new GetAllResource();
    }

    /**
     * Create an instance of {@link DeleteIncident }
     * 
     */
    public DeleteIncident createDeleteIncident() {
        return new DeleteIncident();
    }

    /**
     * Create an instance of {@link AddResource }
     * 
     */
    public AddResource createAddResource() {
        return new AddResource();
    }

    /**
     * Create an instance of {@link FindProposalByIdResponse }
     * 
     */
    public FindProposalByIdResponse createFindProposalByIdResponse() {
        return new FindProposalByIdResponse();
    }

    /**
     * Create an instance of {@link FindResourceByIdResponse }
     * 
     */
    public FindResourceByIdResponse createFindResourceByIdResponse() {
        return new FindResourceByIdResponse();
    }

    /**
     * Create an instance of {@link FindIncidentById }
     * 
     */
    public FindIncidentById createFindIncidentById() {
        return new FindIncidentById();
    }

    /**
     * Create an instance of {@link GetAllIncidentResponse }
     * 
     */
    public GetAllIncidentResponse createGetAllIncidentResponse() {
        return new GetAllIncidentResponse();
    }

    /**
     * Create an instance of {@link UpdateIncidentResponse }
     * 
     */
    public UpdateIncidentResponse createUpdateIncidentResponse() {
        return new UpdateIncidentResponse();
    }

    /**
     * Create an instance of {@link UpdateIncident }
     * 
     */
    public UpdateIncident createUpdateIncident() {
        return new UpdateIncident();
    }

    /**
     * Create an instance of {@link FindProposalById }
     * 
     */
    public FindProposalById createFindProposalById() {
        return new FindProposalById();
    }

    /**
     * Create an instance of {@link GetAllResourceResponse }
     * 
     */
    public GetAllResourceResponse createGetAllResourceResponse() {
        return new GetAllResourceResponse();
    }

    /**
     * Create an instance of {@link FindResourceById }
     * 
     */
    public FindResourceById createFindResourceById() {
        return new FindResourceById();
    }

    /**
     * Create an instance of {@link GetAllProposal }
     * 
     */
    public GetAllProposal createGetAllProposal() {
        return new GetAllProposal();
    }

    /**
     * Create an instance of {@link UpdateProposalResponse }
     * 
     */
    public UpdateProposalResponse createUpdateProposalResponse() {
        return new UpdateProposalResponse();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link Resource }
     * 
     */
    public Resource createResource() {
        return new Resource();
    }

    /**
     * Create an instance of {@link Proposal }
     * 
     */
    public Proposal createProposal() {
        return new Proposal();
    }

    /**
     * Create an instance of {@link Incident }
     * 
     */
    public Incident createIncident() {
        return new Incident();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProposal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "addProposal")
    public JAXBElement<AddProposal> createAddProposal(AddProposal value) {
        return new JAXBElement<AddProposal>(_AddProposal_QNAME, AddProposal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "addResourceResponse")
    public JAXBElement<AddResourceResponse> createAddResourceResponse(AddResourceResponse value) {
        return new JAXBElement<AddResourceResponse>(_AddResourceResponse_QNAME, AddResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "updateResourceResponse")
    public JAXBElement<UpdateResourceResponse> createUpdateResourceResponse(UpdateResourceResponse value) {
        return new JAXBElement<UpdateResourceResponse>(_UpdateResourceResponse_QNAME, UpdateResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "deleteResourceResponse")
    public JAXBElement<DeleteResourceResponse> createDeleteResourceResponse(DeleteResourceResponse value) {
        return new JAXBElement<DeleteResourceResponse>(_DeleteResourceResponse_QNAME, DeleteResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProposalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "getAllProposalResponse")
    public JAXBElement<GetAllProposalResponse> createGetAllProposalResponse(GetAllProposalResponse value) {
        return new JAXBElement<GetAllProposalResponse>(_GetAllProposalResponse_QNAME, GetAllProposalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIncidentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "addIncidentResponse")
    public JAXBElement<AddIncidentResponse> createAddIncidentResponse(AddIncidentResponse value) {
        return new JAXBElement<AddIncidentResponse>(_AddIncidentResponse_QNAME, AddIncidentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "deleteResource")
    public JAXBElement<DeleteResource> createDeleteResource(DeleteResource value) {
        return new JAXBElement<DeleteResource>(_DeleteResource_QNAME, DeleteResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "updateResource")
    public JAXBElement<UpdateResource> createUpdateResource(UpdateResource value) {
        return new JAXBElement<UpdateResource>(_UpdateResource_QNAME, UpdateResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProposalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "updateProposalResponse")
    public JAXBElement<UpdateProposalResponse> createUpdateProposalResponse(UpdateProposalResponse value) {
        return new JAXBElement<UpdateProposalResponse>(_UpdateProposalResponse_QNAME, UpdateProposalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProposal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "getAllProposal")
    public JAXBElement<GetAllProposal> createGetAllProposal(GetAllProposal value) {
        return new JAXBElement<GetAllProposal>(_GetAllProposal_QNAME, GetAllProposal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResourceById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "findResourceById")
    public JAXBElement<FindResourceById> createFindResourceById(FindResourceById value) {
        return new JAXBElement<FindResourceById>(_FindResourceById_QNAME, FindResourceById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "getAllResourceResponse")
    public JAXBElement<GetAllResourceResponse> createGetAllResourceResponse(GetAllResourceResponse value) {
        return new JAXBElement<GetAllResourceResponse>(_GetAllResourceResponse_QNAME, GetAllResourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProposalById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "findProposalById")
    public JAXBElement<FindProposalById> createFindProposalById(FindProposalById value) {
        return new JAXBElement<FindProposalById>(_FindProposalById_QNAME, FindProposalById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateIncident }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "updateIncident")
    public JAXBElement<UpdateIncident> createUpdateIncident(UpdateIncident value) {
        return new JAXBElement<UpdateIncident>(_UpdateIncident_QNAME, UpdateIncident.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateIncidentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "updateIncidentResponse")
    public JAXBElement<UpdateIncidentResponse> createUpdateIncidentResponse(UpdateIncidentResponse value) {
        return new JAXBElement<UpdateIncidentResponse>(_UpdateIncidentResponse_QNAME, UpdateIncidentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindIncidentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "findIncidentById")
    public JAXBElement<FindIncidentById> createFindIncidentById(FindIncidentById value) {
        return new JAXBElement<FindIncidentById>(_FindIncidentById_QNAME, FindIncidentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllIncidentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "getAllIncidentResponse")
    public JAXBElement<GetAllIncidentResponse> createGetAllIncidentResponse(GetAllIncidentResponse value) {
        return new JAXBElement<GetAllIncidentResponse>(_GetAllIncidentResponse_QNAME, GetAllIncidentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProposalByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "findProposalByIdResponse")
    public JAXBElement<FindProposalByIdResponse> createFindProposalByIdResponse(FindProposalByIdResponse value) {
        return new JAXBElement<FindProposalByIdResponse>(_FindProposalByIdResponse_QNAME, FindProposalByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResourceByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "findResourceByIdResponse")
    public JAXBElement<FindResourceByIdResponse> createFindResourceByIdResponse(FindResourceByIdResponse value) {
        return new JAXBElement<FindResourceByIdResponse>(_FindResourceByIdResponse_QNAME, FindResourceByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "addResource")
    public JAXBElement<AddResource> createAddResource(AddResource value) {
        return new JAXBElement<AddResource>(_AddResource_QNAME, AddResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteIncident }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "deleteIncident")
    public JAXBElement<DeleteIncident> createDeleteIncident(DeleteIncident value) {
        return new JAXBElement<DeleteIncident>(_DeleteIncident_QNAME, DeleteIncident.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindIncidentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "findIncidentByIdResponse")
    public JAXBElement<FindIncidentByIdResponse> createFindIncidentByIdResponse(FindIncidentByIdResponse value) {
        return new JAXBElement<FindIncidentByIdResponse>(_FindIncidentByIdResponse_QNAME, FindIncidentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "getAllResource")
    public JAXBElement<GetAllResource> createGetAllResource(GetAllResource value) {
        return new JAXBElement<GetAllResource>(_GetAllResource_QNAME, GetAllResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProposalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "addProposalResponse")
    public JAXBElement<AddProposalResponse> createAddProposalResponse(AddProposalResponse value) {
        return new JAXBElement<AddProposalResponse>(_AddProposalResponse_QNAME, AddProposalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteIncidentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "deleteIncidentResponse")
    public JAXBElement<DeleteIncidentResponse> createDeleteIncidentResponse(DeleteIncidentResponse value) {
        return new JAXBElement<DeleteIncidentResponse>(_DeleteIncidentResponse_QNAME, DeleteIncidentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIncident }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "addIncident")
    public JAXBElement<AddIncident> createAddIncident(AddIncident value) {
        return new JAXBElement<AddIncident>(_AddIncident_QNAME, AddIncident.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllIncident }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "getAllIncident")
    public JAXBElement<GetAllIncident> createGetAllIncident(GetAllIncident value) {
        return new JAXBElement<GetAllIncident>(_GetAllIncident_QNAME, GetAllIncident.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProposal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.emer.stee.com/", name = "updateProposal")
    public JAXBElement<UpdateProposal> createUpdateProposal(UpdateProposal value) {
        return new JAXBElement<UpdateProposal>(_UpdateProposal_QNAME, UpdateProposal.class, null, value);
    }

}
