package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
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
