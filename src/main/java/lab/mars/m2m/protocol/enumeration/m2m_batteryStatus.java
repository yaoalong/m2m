package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_batteryStatus {
    @XmlEnumValue("1")NORMAL,
    @XmlEnumValue("2")CHARGING,
    @XmlEnumValue("3")CHARGING_COMPLETE,
    @XmlEnumValue("4")DAMAGED,
    @XmlEnumValue("5")LOW_BATTERY,
    @XmlEnumValue("6")NOT_INSTALLED,
    @XmlEnumValue("7")UNKNOWN;
}
