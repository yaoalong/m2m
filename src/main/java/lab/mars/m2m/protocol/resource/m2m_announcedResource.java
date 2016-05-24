package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announcedResource", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_announcedResource extends m2m_regularResource {
    //    @XmlElement(required = true)
    @XmlElement
    @XmlSchemaType(name = "anyURI")
    public List<String> link;
}
