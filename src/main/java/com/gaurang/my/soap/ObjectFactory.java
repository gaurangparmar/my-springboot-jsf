
package com.gaurang.my.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gaurang.my.soap package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gaurang.my.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMyDetailsRequest }
     * 
     */
    public GetMyDetailsRequest createGetMyDetailsRequest() {
        return new GetMyDetailsRequest();
    }

    /**
     * Create an instance of {@link GetMyDetailsResponse }
     * 
     */
    public GetMyDetailsResponse createGetMyDetailsResponse() {
        return new GetMyDetailsResponse();
    }

    /**
     * Create an instance of {@link MyDetails }
     * 
     */
    public MyDetails createMyDetails() {
        return new MyDetails();
    }

}
