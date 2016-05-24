package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 */
@XmlEnum(Integer.class)
public enum m2m_countryCode {
    @XmlEnumValue("91")India,
    @XmlEnumValue("1")USA;
}
