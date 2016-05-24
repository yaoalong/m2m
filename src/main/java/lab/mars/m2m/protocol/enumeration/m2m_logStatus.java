package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_logStatus {
    @XmlEnumValue("1")Started,
    @XmlEnumValue("2")Stopped,
    @XmlEnumValue("3")Unknown,
    @XmlEnumValue("4")NotPresent,
    @XmlEnumValue("5")Error;
}
