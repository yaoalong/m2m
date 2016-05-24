package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Duration;
import java.util.Date;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
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
    public String nm;
    /**primitive content*/
    public m2m_primitiveContentType pc;
    /**Originating Timestamp*/
    public Date ot;
    /**Request Expiration Timestamp*/
    public Date rqet;
    /**Result Expiration Timestamp*/
    public Date rset;
    /**Operation Execution Time*/
    public Date oet;
    /**Response Type*/
    public m2m_responseType rt;
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
