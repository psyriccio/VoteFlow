//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.02 at 12:38:05 PM MSK 
//


package psyriccio.voteflow.api.jaxb.periods.impl;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import psyriccio.voteflow.api.jaxb.BaseObj;
import psyriccio.voteflow.api.jaxb.periods.Session;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "name",
    "startDate",
    "endDate"
})
@XmlRootElement(name = "session")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class SessionImpl
    extends BaseObj
    implements Session
{

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger id;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String name;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String startDate;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String endDate;

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getId() {
        return id;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setId(BigInteger value) {
        this.id = value;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getName() {
        return name;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(String value) {
        this.name = value;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getStartDate() {
        return startDate;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setStartDate(String value) {
        this.startDate = value;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getEndDate() {
        return endDate;
    }

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2016-10-02T12:38:05+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setEndDate(String value) {
        this.endDate = value;
    }

}
