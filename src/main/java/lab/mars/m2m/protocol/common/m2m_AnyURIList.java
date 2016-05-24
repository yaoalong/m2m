package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnyURIList", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "reference"
})
public class m2m_AnyURIList {
    @XmlSchemaType(name = "anyURI")
    public List<String> reference;
}
