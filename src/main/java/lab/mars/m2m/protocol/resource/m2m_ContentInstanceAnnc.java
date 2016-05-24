package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cinA", propOrder = {
        "link",
        "st",
        "cnf",
        "cs",
        "or",
        "con",
})
@XmlRootElement(name = "cinA", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_ContentInstanceAnnc extends m2m_announceableResource {
    @XmlSchemaType(name = "anyURI")
    protected String link;
//    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected Integer st;
    public String cnf;
//    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer cs;
    @XmlSchemaType(name = "anyURI")
    public String or;
//    @XmlElement(required = true)
    public byte[] con;
}
