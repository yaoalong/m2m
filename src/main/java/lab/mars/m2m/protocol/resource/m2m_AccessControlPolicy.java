package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.accessControlPolicy.m2m_setOfAcrs;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acp", propOrder = {
        "pv",
        "pvs",
        "ch"
})
@XmlRootElement(name = "acp", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_AccessControlPolicy extends m2m_regularResource {
    public m2m_setOfAcrs pv;
    public m2m_setOfAcrs pvs;
    public List<m2m_childResourceRef> ch;

}
