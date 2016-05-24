package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.*;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlPolicyID", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_accessControlPolicyID {
    @XmlValue
    @XmlSchemaType(name = "anyURI")
    public String value;

    public m2m_accessControlPolicyID() {
    }

    public m2m_accessControlPolicyID(String value) {
        this.value = value;
    }
}
