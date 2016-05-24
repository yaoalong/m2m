package lab.mars.m2m.protocol.accessControlPolicy;

import lab.mars.m2m.protocol.enumeration.m2m_accessControlOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlOperationList", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "accessControlOperation"
})
public class m2m_accessControlOperationList {
//    @XmlElement(required = true)
    public List<m2m_accessControlOperation> accessControlOperation;
}
