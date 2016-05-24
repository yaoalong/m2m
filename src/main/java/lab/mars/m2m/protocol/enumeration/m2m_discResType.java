package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_discResType {
    @XmlEnumValue("1")hierarchical,
    @XmlEnumValue("2")Non_hierarchical,
    @XmlEnumValue("3")cseID_resourceID;

    //FIX refactor this, too verbose!
    public static m2m_discResType parse(String drt) {
        switch (drt) {
            case "1":
                return m2m_discResType.hierarchical;
            case "2":
                return m2m_discResType.Non_hierarchical;
            case "3":
                return m2m_discResType.cseID_resourceID;
            default:
                return null;
        }
    }
}
