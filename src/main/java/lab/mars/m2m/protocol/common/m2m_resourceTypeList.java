package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.enumeration.m2m_resourceType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/12/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resourceTypeList", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "ty"
})
public class m2m_resourceTypeList {
    public List<m2m_resourceType> ty;
}
