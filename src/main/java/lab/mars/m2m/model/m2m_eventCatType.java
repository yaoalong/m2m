package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public enum m2m_eventCatType {
    @XmlEnumValue("1")Default,
    @XmlEnumValue("2")immediate,
    @XmlEnumValue("3")bestEffort,
    @XmlEnumValue("4")Latest;
}
