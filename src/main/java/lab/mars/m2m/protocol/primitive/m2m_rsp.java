package lab.mars.m2m.protocol.primitive;

import lab.mars.m2m.protocol.DateAdapter;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.common.m2m_eventCat;
import lab.mars.m2m.protocol.enumeration.m2m_responseStatusCodeType;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rsp", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "to",
        "fr",
        "rqi",
        "pc",
        "ot",
        "rset",
        "ec",
        "rsc"
})
@XmlRootElement(name = "rsp", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_rsp {
    @XmlSchemaType(name = "anyURI")
    public String to;
    /**from*/
    public m2m_ID fr;
	/**request identifier*/
    public m2m_ID rqi;
	/**primitive content*/
    public m2m_primitiveContentType pc;
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**Originating Timestamp*/
    public Date ot;
    @XmlJavaTypeAdapter(DateAdapter.class)
    /**Result Expiration Timestamp*/
    public Date rset;
	/**Event Category*/
    public m2m_eventCat ec;
	/**Response Status Code*/
    public m2m_responseStatusCodeType rsc;

    public m2m_rsp() {
    }

    public m2m_rsp(m2m_ID request_identifier, m2m_responseStatusCodeType responseStatusCode, m2m_primitiveContentType content) {
        this.rqi = request_identifier;
        this.pc = content;
        this.rsc = responseStatusCode;
    }
}
