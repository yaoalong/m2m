package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class m2m_resource
{/**resource ty*/
public Integer ty;
    /**resourceID*/
    public String ri;
    /**parentID*/
    public String pi;
    @XmlElement(defaultValue  = "2014-06-09T23:15:04")
//	@XmlJavaTypeAdapter(DateAdapter.class)
    /**creationTime*/
    public Date ct;
    @XmlElement(defaultValue  = "2014-06-09T23:15:04")
//	@XmlJavaTypeAdapter(DateAdapter.class)
    /**lastModifiedTime*/
    public Date lt;
    @XmlList
    /**label*/
    public List<String> lbl;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    /**nm*/
    public String nm;
}
