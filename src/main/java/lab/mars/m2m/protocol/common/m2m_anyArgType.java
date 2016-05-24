package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anyArgType", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_anyArgType {
    //    @XmlElement(required = true)
    @XmlElement
    public String name;
    //    @XmlElement(required = true)
    @XmlElement
    public String type;
    //    @XmlElement(required = true)
    @XmlElement
    public Object value;
}
