package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
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
