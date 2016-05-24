package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class m2m_nhURI {
    @XmlValue
    @XmlSchemaType(name = "anyURI")
    public String value;

    public m2m_nhURI() {
    }

    public m2m_nhURI(String value) {
        this.value = value;
    }
}
