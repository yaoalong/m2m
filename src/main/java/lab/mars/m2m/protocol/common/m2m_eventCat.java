package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.enumeration.m2m_eventCatType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventCat", propOrder = {
        "ect",
        "ecn"
})
public class m2m_eventCat {
    public m2m_eventCatType ect;
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer ecn;
}
