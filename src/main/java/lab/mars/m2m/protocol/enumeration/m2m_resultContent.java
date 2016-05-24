package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_resultContent {
    @XmlEnumValue("0")Nothing,
    @XmlEnumValue("1")Attributes,
    @XmlEnumValue("2")childResources,
    @XmlEnumValue("3")attribute_childResources,
    @XmlEnumValue("4")originalResources;

    //FIX refactor this, too verbose!
    public static m2m_resultContent parse(String rc) {
        switch (rc) {
            case "0":
                return m2m_resultContent.Nothing;
            case "1":
                return m2m_resultContent.Attributes;
            case "2":
                return m2m_resultContent.childResources;
            case "3":
                return m2m_resultContent.attribute_childResources;
            case "4":
                return m2m_resultContent.originalResources;
            default:
                return null;
        }
    }
}
