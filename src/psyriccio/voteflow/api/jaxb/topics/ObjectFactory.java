//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.02 at 10:27:12 PM MSK 
//


package psyriccio.voteflow.api.jaxb.topics;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import psyriccio.voteflow.api.jaxb.topics.impl.ResultImpl;
import psyriccio.voteflow.api.jaxb.topics.impl.TopicImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the psyriccio.voteflow.api.jaxb.topics package. 
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

    private final static Void _useJAXBProperties = null;
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Id_QNAME = new QName("", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: psyriccio.voteflow.api.jaxb.topics
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Topic }
     * 
     */
    public Topic createTopic() {
        return new TopicImpl();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new ResultImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id")
    public JAXBElement<BigInteger> createId(BigInteger value) {
        return new JAXBElement<BigInteger>(_Id_QNAME, BigInteger.class, null, value);
    }

}
