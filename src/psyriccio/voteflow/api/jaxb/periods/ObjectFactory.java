//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.02 at 12:38:05 PM MSK 
//


package psyriccio.voteflow.api.jaxb.periods;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import psyriccio.voteflow.api.jaxb.periods.impl.PeriodImpl;
import psyriccio.voteflow.api.jaxb.periods.impl.ResultImpl;
import psyriccio.voteflow.api.jaxb.periods.impl.SessionImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the psyriccio.voteflow.api.jaxb.periods package. 
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
    private final static QName _EndDate_QNAME = new QName("", "endDate");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _StartDate_QNAME = new QName("", "startDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: psyriccio.voteflow.api.jaxb.periods
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new ResultImpl();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new PeriodImpl();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new SessionImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "endDate")
    public JAXBElement<String> createEndDate(String value) {
        return new JAXBElement<String>(_EndDate_QNAME, String.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "startDate")
    public JAXBElement<String> createStartDate(String value) {
        return new JAXBElement<String>(_StartDate_QNAME, String.class, null, value);
    }

}
