package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 */
@XmlEnum(Integer.class)
public enum m2m_accessControlOperation {
    @XmlEnumValue("1")Create,
    @XmlEnumValue("2")Retrieve,
    @XmlEnumValue("3")Update,
    @XmlEnumValue("4")Delete,
    @XmlEnumValue("5")Notify,
    @XmlEnumValue("6")Discover;
}
