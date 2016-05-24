package lab.mars.m2m.protocol.accessControlPolicy;

import lab.mars.m2m.protocol.enumeration.m2m_countryCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlLocationRegion", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "latitude",
        "longitude",
        "radius",
        "countryCode"
})
public class m2m_accessControlLocationRegion {
    public Float latitude;
    public Float longitude;
    public Float radius;
    public m2m_countryCode countryCode;
}
