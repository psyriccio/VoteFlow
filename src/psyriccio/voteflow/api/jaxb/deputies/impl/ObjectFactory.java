//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.02 at 10:27:15 PM MSK 
//


package psyriccio.voteflow.api.jaxb.deputies.impl;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import psyriccio.voteflow.api.jaxb.deputies.Deputy;
import psyriccio.voteflow.api.jaxb.deputies.Faction;
import psyriccio.voteflow.api.jaxb.deputies.Result;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the psyriccio.voteflow.api.jaxb.deputies.impl package. 
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

    private final static QName _IsCurrent_QNAME = new QName("", "isCurrent");
    private final static QName _EndDate_QNAME = new QName("", "endDate");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _Position_QNAME = new QName("", "position");
    private final static QName _StartDate_QNAME = new QName("", "startDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: psyriccio.voteflow.api.jaxb.deputies.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public ResultImpl createResult() {
        return new ResultImpl();
    }

    /**
     * Create an instance of {@link Deputy }
     * 
     */
    public DeputyImpl createDeputy() {
        return new DeputyImpl();
    }

    /**
     * Create an instance of {@link Faction }
     * 
     */
    public FactionImpl createFaction() {
        return new FactionImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "isCurrent")
    public JAXBElement<Boolean> createIsCurrent(Boolean value) {
        return new JAXBElement<Boolean>(_IsCurrent_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "endDate")
    public JAXBElement<XMLGregorianCalendar> createEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_EndDate_QNAME, XMLGregorianCalendar.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "position")
    public JAXBElement<String> createPosition(String value) {
        return new JAXBElement<String>(_Position_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "startDate")
    public JAXBElement<XMLGregorianCalendar> createStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_StartDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

}
