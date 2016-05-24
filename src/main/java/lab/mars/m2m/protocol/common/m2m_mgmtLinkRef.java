package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.enumeration.m2m_mgmtDefinition;

import javax.xml.bind.annotation.*;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mgmtLinkRef", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_mgmtLinkRef {
    @XmlValue
    @XmlSchemaType(name = "anyURI")
    public String value;
//    @XmlAttribute(nm = "nm", required = true)
    @XmlAttribute(name = "rn")
    public String name;
//    @XmlAttribute(nm = "ty", required = true)
    @XmlAttribute(name = "ty")
    public m2m_mgmtDefinition type;
}
