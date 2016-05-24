package lab.mars.m2m.protocol.accessControlPolicy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlIpAddresses", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "accessControlIpAddress"
})
public class m2m_accessControlIpAddresses {
    @XmlSchemaType(name = "anyURI")
    public List<String> accessControlIpAddress;
}
