package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.enumeration.m2m_operation;

import javax.xml.bind.annotation.XmlSchemaType;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
public class m2m_request {
//    @XmlElement(required = true)
    public m2m_operation operation;
//    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    public String to;
//    @XmlElement(required = true)
    public m2m_ID from;
//    @XmlElement(required = true)
    public m2m_requestID requestIdentifier;

    public m2m_content content;

    public m2m_metaInformation metaInformation;
}
