package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.resource.m2m_resource;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announcedSubordinateResource", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_announcedSubordinateResource extends m2m_resource {
    //    @XmlElement(required = true)
    @XmlElement
//    @XmlJavaTypeAdapter(DateAdapter.class)
    /**expirationTime*/
    public Date et;
    @XmlElement
    @XmlSchemaType(name = "anyURI")
    public List<String> link;
}
