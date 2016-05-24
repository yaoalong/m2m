package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "attribute", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "name",
        "value"
})
public class m2m_attribute {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    public String name;
    public Object value;

    public m2m_attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public m2m_attribute() {}

}
