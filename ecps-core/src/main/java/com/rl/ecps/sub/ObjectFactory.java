
package com.rl.ecps.sub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rl.ecps.sub package. 
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

    private final static QName _PubliclishService_QNAME = new QName("http://service.ws.ecps.rl.com/", "publiclishService");
    private final static QName _PubliclishServiceResponse_QNAME = new QName("http://service.ws.ecps.rl.com/", "publiclishServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rl.ecps.sub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PubliclishService }
     * 
     */
    public PubliclishService createPubliclishService() {
        return new PubliclishService();
    }

    /**
     * Create an instance of {@link PubliclishServiceResponse }
     * 
     */
    public PubliclishServiceResponse createPubliclishServiceResponse() {
        return new PubliclishServiceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PubliclishService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecps.rl.com/", name = "publiclishService")
    public JAXBElement<PubliclishService> createPubliclishService(PubliclishService value) {
        return new JAXBElement<PubliclishService>(_PubliclishService_QNAME, PubliclishService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PubliclishServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.ws.ecps.rl.com/", name = "publiclishServiceResponse")
    public JAXBElement<PubliclishServiceResponse> createPubliclishServiceResponse(PubliclishServiceResponse value) {
        return new JAXBElement<PubliclishServiceResponse>(_PubliclishServiceResponse_QNAME, PubliclishServiceResponse.class, null, value);
    }

}
