package lab.mars.m2m.protocol.primitive;

import lab.mars.m2m.protocol.common.m2m_AnyURIList;
import lab.mars.m2m.protocol.common.m2m_aggregatedResponse;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.enumeration.m2m_responseStatusCodeType;
import lab.mars.m2m.protocol.informal.PartialRetrieve;
import lab.mars.m2m.protocol.resource.*;

import javax.xml.bind.annotation.*;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pc", namespace = "http://www.onem2m.org/xml/protocols")
@XmlRootElement(name = "pc", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_primitiveContentType {
    @XmlElements({
            @XmlElement(name = "acp", type = m2m_AccessControlPolicy.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "cnt", type = m2m_Container.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "cin", type = m2m_ContentInstance.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "ae", type = m2m_AE.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "grp", type=m2m_Group.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "csb", type = m2m_CSEBase.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "sub", type = m2m_Subscription.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "result", type = m2m_responseStatusCodeType.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "child", type = m2m_childResourceRef.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "string", type = String.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "PartialRetrieve", type = PartialRetrieve.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "AnyURIList", type = m2m_AnyURIList.class, namespace = "http://www.onem2m.org/xml/protocols"),
            @XmlElement(name = "agr", type = m2m_aggregatedResponse.class, namespace = "http://www.onem2m.org/xml/protocols")
    })
    public Object value;

    public m2m_primitiveContentType() {}

    public m2m_primitiveContentType(Object value) {
        this.value = value;
    }
}
