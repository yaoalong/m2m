package lab.mars.m2m.model;

import lab.mars.m2m.protocol.enumeration.m2m_responseStatusCodeType;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class m2m_rsp {
    @XmlSchemaType(name = "anyURI")
    public String to;
    /**from*/
    public m2m_ID fr;
    /**request identifier*/
    public m2m_ID rqi;
    /**primitive content*/
    public m2m_primitiveContentType pc;
    /**Originating Timestamp*/
    public Date ot;
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
