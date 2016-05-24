package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_mgmtDefinition {
    @XmlEnumValue("1001")firmware,
    @XmlEnumValue("1002")software,
    @XmlEnumValue("1003")memory,
    @XmlEnumValue("1004")areaNwkInfo,
    @XmlEnumValue("1005")areaNwkDeviceInfo,
    @XmlEnumValue("1006")battery,
    @XmlEnumValue("1007")deviceInfo,
    @XmlEnumValue("1008")deviceCapability,
    @XmlEnumValue("1009")reboot,
    @XmlEnumValue("1010")eventLog,
    @XmlEnumValue("1011")cmdhPolicy,
    @XmlEnumValue("1012")activeCmdhPolicy,
    @XmlEnumValue("1013")cmdhDefaults,
    @XmlEnumValue("1014")cmdhDefEcValue,
    @XmlEnumValue("1015")cmdhEcDefParamValues,
    @XmlEnumValue("1016")cmdhLimits,
    @XmlEnumValue("1017")cmdhNetworkAccessRules,
    @XmlEnumValue("1018")cmdhNwAccessRules,
    @XmlEnumValue("1019")cmdhBuffer,
    @XmlEnumValue("0")Unspecified;
}
