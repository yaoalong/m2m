package lab.mars.m2m.protocol.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by haixiao on 14/11/14.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlEnum(Integer.class)
public enum m2m_execStateType {
    @XmlEnumValue("1")INITIATED,
    @XmlEnumValue("2")STARTED,
    @XmlEnumValue("3")FINISHED,
    @XmlEnumValue("4")CANCELLING,
    @XmlEnumValue("5")CANCELLED,
    @XmlEnumValue("6")STATUS_NON_CANCELLABLE;

}
