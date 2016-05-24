package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.DateAdapter;
import lab.mars.m2m.protocol.common.m2m_AnyURIList;
import lab.mars.m2m.protocol.resource.m2m_resource;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announceableSubordinateResource", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_announceableSubordinateResource extends m2m_resource {
    //    @XmlElement(required = true)
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**expirationTime*/
    public Date et;
    @XmlElement
    /**announceTo*/
    public m2m_AnyURIList at;
    @XmlList
    /**announcedAttribute*/
    public List<String> aa;
}
