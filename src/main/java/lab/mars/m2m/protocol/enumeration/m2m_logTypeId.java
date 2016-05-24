package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_logTypeId {
    @XmlEnumValue("1")system,
    @XmlEnumValue("2") security,
    @XmlEnumValue("3") event,
    @XmlEnumValue("4")trace,
    @XmlEnumValue("5")panic;
}
