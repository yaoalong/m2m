package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public enum m2m_operation
{
    @XmlEnumValue("1")Create,
    @XmlEnumValue("2")Retrieve,
    @XmlEnumValue("3")Update,
    @XmlEnumValue("4")Delete,
    @XmlEnumValue("5")Notify

}
