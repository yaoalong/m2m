package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlEnum(Integer.class)
public enum m2m_pendingRequestsType {
    @XmlEnumValue("1")OK,
    @XmlEnumValue("2")Fail,
    @XmlEnumValue("3")denied;
}
