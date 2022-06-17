
package bgs.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bgs.client.generated package. 
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

    private final static QName _NegativeParameterException_QNAME = new QName("http://server.bgs/", "NegativeParameterException");
    private final static QName _SubscriptionNotFoundException_QNAME = new QName("http://server.bgs/", "SubscriptionNotFoundException");
    private final static QName _CreateSubscription_QNAME = new QName("http://server.bgs/", "createSubscription");
    private final static QName _CreateSubscriptionResponse_QNAME = new QName("http://server.bgs/", "createSubscriptionResponse");
    private final static QName _EditSubscription_QNAME = new QName("http://server.bgs/", "editSubscription");
    private final static QName _EditSubscriptionResponse_QNAME = new QName("http://server.bgs/", "editSubscriptionResponse");
    private final static QName _GetAllSubscriptions_QNAME = new QName("http://server.bgs/", "getAllSubscriptions");
    private final static QName _GetAllSubscriptionsResponse_QNAME = new QName("http://server.bgs/", "getAllSubscriptionsResponse");
    private final static QName _GetSubscriptionsBetterThan_QNAME = new QName("http://server.bgs/", "getSubscriptionsBetterThan");
    private final static QName _GetSubscriptionsBetterThanResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsBetterThanResponse");
    private final static QName _GetSubscriptionsById_QNAME = new QName("http://server.bgs/", "getSubscriptionsById");
    private final static QName _GetSubscriptionsByIdResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByIdResponse");
    private final static QName _GetSubscriptionsByName_QNAME = new QName("http://server.bgs/", "getSubscriptionsByName");
    private final static QName _GetSubscriptionsByNameResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByNameResponse");
    private final static QName _GetSubscriptionsByRateGe_QNAME = new QName("http://server.bgs/", "getSubscriptionsByRateGe");
    private final static QName _GetSubscriptionsByRateGeResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByRateGeResponse");
    private final static QName _GetSubscriptionsByRateLe_QNAME = new QName("http://server.bgs/", "getSubscriptionsByRateLe");
    private final static QName _GetSubscriptionsByRateLeResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByRateLeResponse");
    private final static QName _GetSubscriptionsByThroughputGe_QNAME = new QName("http://server.bgs/", "getSubscriptionsByThroughputGe");
    private final static QName _GetSubscriptionsByThroughputGeResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByThroughputGeResponse");
    private final static QName _GetSubscriptionsByThroughputLe_QNAME = new QName("http://server.bgs/", "getSubscriptionsByThroughputLe");
    private final static QName _GetSubscriptionsByThroughputLeResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByThroughputLeResponse");
    private final static QName _GetSubscriptionsByTv_QNAME = new QName("http://server.bgs/", "getSubscriptionsByTv");
    private final static QName _GetSubscriptionsByTvResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsByTvResponse");
    private final static QName _GetSubscriptionsWorseThan_QNAME = new QName("http://server.bgs/", "getSubscriptionsWorseThan");
    private final static QName _GetSubscriptionsWorseThanResponse_QNAME = new QName("http://server.bgs/", "getSubscriptionsWorseThanResponse");
    private final static QName _RemoveSubscription_QNAME = new QName("http://server.bgs/", "removeSubscription");
    private final static QName _RemoveSubscriptionResponse_QNAME = new QName("http://server.bgs/", "removeSubscriptionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bgs.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubscriptionServiceFault }
     * 
     */
    public SubscriptionServiceFault createSubscriptionServiceFault() {
        return new SubscriptionServiceFault();
    }

    /**
     * Create an instance of {@link CreateSubscription }
     * 
     */
    public CreateSubscription createCreateSubscription() {
        return new CreateSubscription();
    }

    /**
     * Create an instance of {@link CreateSubscriptionResponse }
     * 
     */
    public CreateSubscriptionResponse createCreateSubscriptionResponse() {
        return new CreateSubscriptionResponse();
    }

    /**
     * Create an instance of {@link EditSubscription }
     * 
     */
    public EditSubscription createEditSubscription() {
        return new EditSubscription();
    }

    /**
     * Create an instance of {@link EditSubscriptionResponse }
     * 
     */
    public EditSubscriptionResponse createEditSubscriptionResponse() {
        return new EditSubscriptionResponse();
    }

    /**
     * Create an instance of {@link GetAllSubscriptions }
     * 
     */
    public GetAllSubscriptions createGetAllSubscriptions() {
        return new GetAllSubscriptions();
    }

    /**
     * Create an instance of {@link GetAllSubscriptionsResponse }
     * 
     */
    public GetAllSubscriptionsResponse createGetAllSubscriptionsResponse() {
        return new GetAllSubscriptionsResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsBetterThan }
     * 
     */
    public GetSubscriptionsBetterThan createGetSubscriptionsBetterThan() {
        return new GetSubscriptionsBetterThan();
    }

    /**
     * Create an instance of {@link GetSubscriptionsBetterThanResponse }
     * 
     */
    public GetSubscriptionsBetterThanResponse createGetSubscriptionsBetterThanResponse() {
        return new GetSubscriptionsBetterThanResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsById }
     * 
     */
    public GetSubscriptionsById createGetSubscriptionsById() {
        return new GetSubscriptionsById();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByIdResponse }
     * 
     */
    public GetSubscriptionsByIdResponse createGetSubscriptionsByIdResponse() {
        return new GetSubscriptionsByIdResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByName }
     * 
     */
    public GetSubscriptionsByName createGetSubscriptionsByName() {
        return new GetSubscriptionsByName();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByNameResponse }
     * 
     */
    public GetSubscriptionsByNameResponse createGetSubscriptionsByNameResponse() {
        return new GetSubscriptionsByNameResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByRateGe }
     * 
     */
    public GetSubscriptionsByRateGe createGetSubscriptionsByRateGe() {
        return new GetSubscriptionsByRateGe();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByRateGeResponse }
     * 
     */
    public GetSubscriptionsByRateGeResponse createGetSubscriptionsByRateGeResponse() {
        return new GetSubscriptionsByRateGeResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByRateLe }
     * 
     */
    public GetSubscriptionsByRateLe createGetSubscriptionsByRateLe() {
        return new GetSubscriptionsByRateLe();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByRateLeResponse }
     * 
     */
    public GetSubscriptionsByRateLeResponse createGetSubscriptionsByRateLeResponse() {
        return new GetSubscriptionsByRateLeResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByThroughputGe }
     * 
     */
    public GetSubscriptionsByThroughputGe createGetSubscriptionsByThroughputGe() {
        return new GetSubscriptionsByThroughputGe();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByThroughputGeResponse }
     * 
     */
    public GetSubscriptionsByThroughputGeResponse createGetSubscriptionsByThroughputGeResponse() {
        return new GetSubscriptionsByThroughputGeResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByThroughputLe }
     * 
     */
    public GetSubscriptionsByThroughputLe createGetSubscriptionsByThroughputLe() {
        return new GetSubscriptionsByThroughputLe();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByThroughputLeResponse }
     * 
     */
    public GetSubscriptionsByThroughputLeResponse createGetSubscriptionsByThroughputLeResponse() {
        return new GetSubscriptionsByThroughputLeResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByTv }
     * 
     */
    public GetSubscriptionsByTv createGetSubscriptionsByTv() {
        return new GetSubscriptionsByTv();
    }

    /**
     * Create an instance of {@link GetSubscriptionsByTvResponse }
     * 
     */
    public GetSubscriptionsByTvResponse createGetSubscriptionsByTvResponse() {
        return new GetSubscriptionsByTvResponse();
    }

    /**
     * Create an instance of {@link GetSubscriptionsWorseThan }
     * 
     */
    public GetSubscriptionsWorseThan createGetSubscriptionsWorseThan() {
        return new GetSubscriptionsWorseThan();
    }

    /**
     * Create an instance of {@link GetSubscriptionsWorseThanResponse }
     * 
     */
    public GetSubscriptionsWorseThanResponse createGetSubscriptionsWorseThanResponse() {
        return new GetSubscriptionsWorseThanResponse();
    }

    /**
     * Create an instance of {@link RemoveSubscription }
     * 
     */
    public RemoveSubscription createRemoveSubscription() {
        return new RemoveSubscription();
    }

    /**
     * Create an instance of {@link RemoveSubscriptionResponse }
     * 
     */
    public RemoveSubscriptionResponse createRemoveSubscriptionResponse() {
        return new RemoveSubscriptionResponse();
    }

    /**
     * Create an instance of {@link Subscription }
     * 
     */
    public Subscription createSubscription() {
        return new Subscription();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriptionServiceFault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubscriptionServiceFault }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "NegativeParameterException")
    public JAXBElement<SubscriptionServiceFault> createNegativeParameterException(SubscriptionServiceFault value) {
        return new JAXBElement<SubscriptionServiceFault>(_NegativeParameterException_QNAME, SubscriptionServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriptionServiceFault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubscriptionServiceFault }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "SubscriptionNotFoundException")
    public JAXBElement<SubscriptionServiceFault> createSubscriptionNotFoundException(SubscriptionServiceFault value) {
        return new JAXBElement<SubscriptionServiceFault>(_SubscriptionNotFoundException_QNAME, SubscriptionServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSubscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateSubscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "createSubscription")
    public JAXBElement<CreateSubscription> createCreateSubscription(CreateSubscription value) {
        return new JAXBElement<CreateSubscription>(_CreateSubscription_QNAME, CreateSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSubscriptionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateSubscriptionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "createSubscriptionResponse")
    public JAXBElement<CreateSubscriptionResponse> createCreateSubscriptionResponse(CreateSubscriptionResponse value) {
        return new JAXBElement<CreateSubscriptionResponse>(_CreateSubscriptionResponse_QNAME, CreateSubscriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditSubscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditSubscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "editSubscription")
    public JAXBElement<EditSubscription> createEditSubscription(EditSubscription value) {
        return new JAXBElement<EditSubscription>(_EditSubscription_QNAME, EditSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditSubscriptionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EditSubscriptionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "editSubscriptionResponse")
    public JAXBElement<EditSubscriptionResponse> createEditSubscriptionResponse(EditSubscriptionResponse value) {
        return new JAXBElement<EditSubscriptionResponse>(_EditSubscriptionResponse_QNAME, EditSubscriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptions }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getAllSubscriptions")
    public JAXBElement<GetAllSubscriptions> createGetAllSubscriptions(GetAllSubscriptions value) {
        return new JAXBElement<GetAllSubscriptions>(_GetAllSubscriptions_QNAME, GetAllSubscriptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptionsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllSubscriptionsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getAllSubscriptionsResponse")
    public JAXBElement<GetAllSubscriptionsResponse> createGetAllSubscriptionsResponse(GetAllSubscriptionsResponse value) {
        return new JAXBElement<GetAllSubscriptionsResponse>(_GetAllSubscriptionsResponse_QNAME, GetAllSubscriptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsBetterThan }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsBetterThan }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsBetterThan")
    public JAXBElement<GetSubscriptionsBetterThan> createGetSubscriptionsBetterThan(GetSubscriptionsBetterThan value) {
        return new JAXBElement<GetSubscriptionsBetterThan>(_GetSubscriptionsBetterThan_QNAME, GetSubscriptionsBetterThan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsBetterThanResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsBetterThanResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsBetterThanResponse")
    public JAXBElement<GetSubscriptionsBetterThanResponse> createGetSubscriptionsBetterThanResponse(GetSubscriptionsBetterThanResponse value) {
        return new JAXBElement<GetSubscriptionsBetterThanResponse>(_GetSubscriptionsBetterThanResponse_QNAME, GetSubscriptionsBetterThanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsById }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsById")
    public JAXBElement<GetSubscriptionsById> createGetSubscriptionsById(GetSubscriptionsById value) {
        return new JAXBElement<GetSubscriptionsById>(_GetSubscriptionsById_QNAME, GetSubscriptionsById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByIdResponse")
    public JAXBElement<GetSubscriptionsByIdResponse> createGetSubscriptionsByIdResponse(GetSubscriptionsByIdResponse value) {
        return new JAXBElement<GetSubscriptionsByIdResponse>(_GetSubscriptionsByIdResponse_QNAME, GetSubscriptionsByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByName")
    public JAXBElement<GetSubscriptionsByName> createGetSubscriptionsByName(GetSubscriptionsByName value) {
        return new JAXBElement<GetSubscriptionsByName>(_GetSubscriptionsByName_QNAME, GetSubscriptionsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByNameResponse")
    public JAXBElement<GetSubscriptionsByNameResponse> createGetSubscriptionsByNameResponse(GetSubscriptionsByNameResponse value) {
        return new JAXBElement<GetSubscriptionsByNameResponse>(_GetSubscriptionsByNameResponse_QNAME, GetSubscriptionsByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateGe }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateGe }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByRateGe")
    public JAXBElement<GetSubscriptionsByRateGe> createGetSubscriptionsByRateGe(GetSubscriptionsByRateGe value) {
        return new JAXBElement<GetSubscriptionsByRateGe>(_GetSubscriptionsByRateGe_QNAME, GetSubscriptionsByRateGe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateGeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateGeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByRateGeResponse")
    public JAXBElement<GetSubscriptionsByRateGeResponse> createGetSubscriptionsByRateGeResponse(GetSubscriptionsByRateGeResponse value) {
        return new JAXBElement<GetSubscriptionsByRateGeResponse>(_GetSubscriptionsByRateGeResponse_QNAME, GetSubscriptionsByRateGeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateLe }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateLe }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByRateLe")
    public JAXBElement<GetSubscriptionsByRateLe> createGetSubscriptionsByRateLe(GetSubscriptionsByRateLe value) {
        return new JAXBElement<GetSubscriptionsByRateLe>(_GetSubscriptionsByRateLe_QNAME, GetSubscriptionsByRateLe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateLeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByRateLeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByRateLeResponse")
    public JAXBElement<GetSubscriptionsByRateLeResponse> createGetSubscriptionsByRateLeResponse(GetSubscriptionsByRateLeResponse value) {
        return new JAXBElement<GetSubscriptionsByRateLeResponse>(_GetSubscriptionsByRateLeResponse_QNAME, GetSubscriptionsByRateLeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputGe }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputGe }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByThroughputGe")
    public JAXBElement<GetSubscriptionsByThroughputGe> createGetSubscriptionsByThroughputGe(GetSubscriptionsByThroughputGe value) {
        return new JAXBElement<GetSubscriptionsByThroughputGe>(_GetSubscriptionsByThroughputGe_QNAME, GetSubscriptionsByThroughputGe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputGeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputGeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByThroughputGeResponse")
    public JAXBElement<GetSubscriptionsByThroughputGeResponse> createGetSubscriptionsByThroughputGeResponse(GetSubscriptionsByThroughputGeResponse value) {
        return new JAXBElement<GetSubscriptionsByThroughputGeResponse>(_GetSubscriptionsByThroughputGeResponse_QNAME, GetSubscriptionsByThroughputGeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputLe }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputLe }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByThroughputLe")
    public JAXBElement<GetSubscriptionsByThroughputLe> createGetSubscriptionsByThroughputLe(GetSubscriptionsByThroughputLe value) {
        return new JAXBElement<GetSubscriptionsByThroughputLe>(_GetSubscriptionsByThroughputLe_QNAME, GetSubscriptionsByThroughputLe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputLeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByThroughputLeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByThroughputLeResponse")
    public JAXBElement<GetSubscriptionsByThroughputLeResponse> createGetSubscriptionsByThroughputLeResponse(GetSubscriptionsByThroughputLeResponse value) {
        return new JAXBElement<GetSubscriptionsByThroughputLeResponse>(_GetSubscriptionsByThroughputLeResponse_QNAME, GetSubscriptionsByThroughputLeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByTv }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByTv }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByTv")
    public JAXBElement<GetSubscriptionsByTv> createGetSubscriptionsByTv(GetSubscriptionsByTv value) {
        return new JAXBElement<GetSubscriptionsByTv>(_GetSubscriptionsByTv_QNAME, GetSubscriptionsByTv.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByTvResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsByTvResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsByTvResponse")
    public JAXBElement<GetSubscriptionsByTvResponse> createGetSubscriptionsByTvResponse(GetSubscriptionsByTvResponse value) {
        return new JAXBElement<GetSubscriptionsByTvResponse>(_GetSubscriptionsByTvResponse_QNAME, GetSubscriptionsByTvResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsWorseThan }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsWorseThan }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsWorseThan")
    public JAXBElement<GetSubscriptionsWorseThan> createGetSubscriptionsWorseThan(GetSubscriptionsWorseThan value) {
        return new JAXBElement<GetSubscriptionsWorseThan>(_GetSubscriptionsWorseThan_QNAME, GetSubscriptionsWorseThan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsWorseThanResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubscriptionsWorseThanResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "getSubscriptionsWorseThanResponse")
    public JAXBElement<GetSubscriptionsWorseThanResponse> createGetSubscriptionsWorseThanResponse(GetSubscriptionsWorseThanResponse value) {
        return new JAXBElement<GetSubscriptionsWorseThanResponse>(_GetSubscriptionsWorseThanResponse_QNAME, GetSubscriptionsWorseThanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSubscription }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSubscription }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "removeSubscription")
    public JAXBElement<RemoveSubscription> createRemoveSubscription(RemoveSubscription value) {
        return new JAXBElement<RemoveSubscription>(_RemoveSubscription_QNAME, RemoveSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveSubscriptionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveSubscriptionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.bgs/", name = "removeSubscriptionResponse")
    public JAXBElement<RemoveSubscriptionResponse> createRemoveSubscriptionResponse(RemoveSubscriptionResponse value) {
        return new JAXBElement<RemoveSubscriptionResponse>(_RemoveSubscriptionResponse_QNAME, RemoveSubscriptionResponse.class, null, value);
    }

}
