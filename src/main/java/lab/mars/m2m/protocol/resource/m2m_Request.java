package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.HasStateTag;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.common.m2m_metaInformation;
import lab.mars.m2m.protocol.common.m2m_requestID;
import lab.mars.m2m.protocol.primitive.m2m_primitiveContentType;
import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "op",
        "tg",
        "og",
        "rid",
        "mi",
        "pc",
        "rs",
        "ol",
        "ch"
})
@XmlRootElement(name = "req")
public class m2m_Request extends m2m_regularResource implements HasChildren,HasStateTag {
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer st;
    public Integer op;
    @XmlSchemaType(name = "anyURI")
    public String tg;
    @XmlSchemaType(name = "anyURI")
    public String og;
    public m2m_requestID rid;
    public m2m_metaInformation mi;
    public m2m_primitiveContentType pc;
    public Integer rs;
    public Integer ol;
    public List<m2m_childResourceRef> ch;

    @Override public List<m2m_childResourceRef> children() {
        return ch;
    }
    @Override public void setChildren(List<m2m_childResourceRef> children) {
        this.ch = children;
    }

    @Override public void remove(m2m_childResourceRef child) {
        if (ch != null)
            ch.remove(child);
    }

    @Override public void add(m2m_childResourceRef child) {
        if (ch != null)
            ch.add(child);
    }

    @Override public Integer getStateTag() {return st;}
}
