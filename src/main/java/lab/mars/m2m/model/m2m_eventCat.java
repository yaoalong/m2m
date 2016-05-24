package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlSchemaType;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class m2m_eventCat {
    public m2m_eventCatType ect;
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer ecn;
}
