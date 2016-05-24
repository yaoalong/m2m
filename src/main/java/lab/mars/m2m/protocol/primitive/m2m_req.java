package lab.mars.m2m.protocol.primitive;

import lab.mars.m2m.protocol.DateAdapter;
import lab.mars.m2m.protocol.DurationAdapter;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.common.m2m_eventCat;
import lab.mars.m2m.protocol.common.m2m_filterCriteria;
import lab.mars.m2m.protocol.enumeration.m2m_discResType;
import lab.mars.m2m.protocol.enumeration.m2m_operation;
import lab.mars.m2m.protocol.enumeration.m2m_responseType;
import lab.mars.m2m.protocol.enumeration.m2m_resultContent;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Duration;
import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType
@XmlRootElement(name = "req", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_req {
    /**operation*/
    public m2m_operation op;
    @XmlSchemaType(name = "anyURI")
    public String to;
	/**from*/
    public m2m_ID fr;
	/**request identifier*/
    public m2m_ID rqi;
	/**resource ty*/
    public Integer ty;
	/**nm*/
    public String rn;
	/**primitive content*/
    public m2m_primitiveContentType pc;
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**Originating Timestamp*/
    public Date ot;
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**Request Expiration Timestamp*/
    public Date rqet;
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**Result Expiration Timestamp*/
    public Date rset;
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**Operation Execution Time*/
    public Date oet;
	/**Response Type*/
    public m2m_responseType rt;
    @XmlJavaTypeAdapter(DurationAdapter.class)
    /**Result Persistence*/
    public Duration rp;
	/**Result Content*/
    public m2m_resultContent rcn;
	/**Event Category*/
    public m2m_eventCat ec;
	/**Delivery Aggregation*/
    public m2m_ID da;
    /**Group Request Identifier*/
    public String gid;
	/**Filter Criteria*/
    public m2m_filterCriteria fc;
	/**Discovery Result Type*/
    public m2m_discResType drt;
    @XmlElement
    public String rol;

}
