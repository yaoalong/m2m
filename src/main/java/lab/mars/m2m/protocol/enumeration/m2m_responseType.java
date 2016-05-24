package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_responseType {
    @XmlEnumValue("1")nonBlockingRequestSynch,
    @XmlEnumValue("2")nonBlockingRequestAsynch,
    @XmlEnumValue("3")blockingRequest;

    //FIX refactor this, too verbose!
    public static m2m_responseType parse(String rt) {
        switch (rt) {
            case "1":
                return m2m_responseType.nonBlockingRequestSynch;
            case "2":
                return m2m_responseType.nonBlockingRequestAsynch;
            case "3":
                return m2m_responseType.blockingRequest;
            default:
                return null;
        }
    }
}
