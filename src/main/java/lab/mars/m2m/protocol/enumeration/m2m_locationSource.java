package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_locationSource {
    @XmlEnumValue("1")Network_based,
    @XmlEnumValue("2")Device_based,
    @XmlEnumValue("3")Sharing_based;
}
