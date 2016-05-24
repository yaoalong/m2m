package lab.mars.m2m.protocol.accessControlPolicy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlLocationRegions", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "accessControlLocationRegion"
})
public class m2m_accessControlLocationRegions {
    public List<m2m_accessControlLocationRegion> accessControlLocationRegion;
}
