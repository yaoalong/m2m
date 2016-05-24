package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.enumeration.m2m_mgmtDefinition;
import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mgo", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "mgd",
        "obis",
        "obps",
        "mgmtLink",
        "description",
        "ch"
})
public class m2m_MgmtObj extends m2m_regularResource implements HasChildren{
    protected m2m_mgmtDefinition mgd;
    @XmlList
    @XmlSchemaType(name = "anyURI")
    protected List<String> obis;
    @XmlList
    @XmlSchemaType(name = "anyURI")
    protected List<String> obps;
    @XmlList
    @XmlSchemaType(name = "anyURI")
    protected List<String> mgmtLink;
    protected String description;
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
}
