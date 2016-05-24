package lab.mars.m2m.protocol.accessControlPolicy;

import lab.mars.m2m.protocol.common.m2m_AnyURIList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlRule", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "accessControlOriginators",
        "accessControlOperations",
        "accessControlContexts"
})
public class m2m_accesControlRule {
//    @XmlElement(required = true)
    public m2m_AnyURIList accessControlOriginators;
//    @XmlElement(required = true)
    public m2m_accessControlOperationList accessControlOperations;
    public m2m_accessControlContexts accessControlContexts;

}
