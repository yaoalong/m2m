package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_cmdType {
    @XmlEnumValue("1")RESET,
    @XmlEnumValue("2")REBOOT,
    @XmlEnumValue("3")UPLOAD,
    @XmlEnumValue("4")DOWNLOAD,
    @XmlEnumValue("5")SOFTWAREINSTALL,
    @XmlEnumValue("6")SOFTWAREUNINSTALL;
}
