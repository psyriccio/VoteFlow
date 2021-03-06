//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.02 at 10:27:18 PM MSK 
//


package psyriccio.voteflow.api.jaxb.votes.impl;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import psyriccio.voteflow.api.jaxb.votes.Result;
import psyriccio.voteflow.api.jaxb.votes.Vote;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the psyriccio.voteflow.api.jaxb.votes.impl package. 
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

    private final static QName _Subject_QNAME = new QName("", "subject");
    private final static QName _PageSize_QNAME = new QName("", "pageSize");
    private final static QName _AbsentCount_QNAME = new QName("", "absentCount");
    private final static QName _TotalCount_QNAME = new QName("", "totalCount");
    private final static QName _AgainstCount_QNAME = new QName("", "againstCount");
    private final static QName _VoteDate_QNAME = new QName("", "voteDate");
    private final static QName _Page_QNAME = new QName("", "page");
    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _VoteCount_QNAME = new QName("", "voteCount");
    private final static QName _Wording_QNAME = new QName("", "wording");
    private final static QName _ResultType_QNAME = new QName("", "resultType");
    private final static QName _ForCount_QNAME = new QName("", "forCount");
    private final static QName _AbstainCount_QNAME = new QName("", "abstainCount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: psyriccio.voteflow.api.jaxb.votes.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Vote }
     * 
     */
    public VoteImpl createVote() {
        return new VoteImpl();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public ResultImpl createResult() {
        return new ResultImpl();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subject")
    public JAXBElement<String> createSubject(String value) {
        return new JAXBElement<String>(_Subject_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pageSize")
    public JAXBElement<BigInteger> createPageSize(BigInteger value) {
        return new JAXBElement<BigInteger>(_PageSize_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "absentCount")
    public JAXBElement<BigInteger> createAbsentCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_AbsentCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "totalCount")
    public JAXBElement<BigInteger> createTotalCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_TotalCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "againstCount")
    public JAXBElement<BigInteger> createAgainstCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_AgainstCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteDate")
    public JAXBElement<String> createVoteDate(String value) {
        return new JAXBElement<String>(_VoteDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "page")
    public JAXBElement<BigInteger> createPage(BigInteger value) {
        return new JAXBElement<BigInteger>(_Page_QNAME, BigInteger.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "voteCount")
    public JAXBElement<BigInteger> createVoteCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_VoteCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "wording")
    public JAXBElement<String> createWording(String value) {
        return new JAXBElement<String>(_Wording_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "resultType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createResultType(String value) {
        return new JAXBElement<String>(_ResultType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "forCount")
    public JAXBElement<BigInteger> createForCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_ForCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "abstainCount")
    public JAXBElement<BigInteger> createAbstainCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_AbstainCount_QNAME, BigInteger.class, null, value);
    }

}
