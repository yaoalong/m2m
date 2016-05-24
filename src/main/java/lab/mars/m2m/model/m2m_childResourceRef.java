package lab.mars.m2m.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class m2m_childResourceRef {
    @XmlValue
    @XmlSchemaType(name = "anyURI")
    public String v;
    @XmlAttribute
    public String nm;
    @XmlAttribute
    public Integer ty;

    public m2m_childResourceRef() {
    }

    public m2m_childResourceRef(m2m_resource childResource) {
        this(childResource.ri, childResource.nm, childResource.ty);
    }

    public m2m_childResourceRef(String value, String name, Integer type) {
        this.v = value;
        this.nm = name;
        this.ty = type;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        m2m_childResourceRef ref = (m2m_childResourceRef) o;

        if (v != null ? !v.equals(ref.v) : ref.v != null) return false;
        if (nm != null ? !nm.equals(ref.nm) : ref.nm != null) return false;
        return ty.equals(ref.ty);

    }

    @Override public int hashCode() {
        int result = v != null ? v.hashCode() : 0;
        result = 31 * result + (nm != null ? nm.hashCode() : 0);
        result = 31 * result + (ty != null ? ty.hashCode() : 0);
        return result;
    }
}
