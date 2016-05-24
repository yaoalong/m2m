package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cst",
        "poa",
        "cb",
        "cseid",
        "rr",
        "nl",
        "ch"
})
@XmlRootElement(name = "csrA", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_RemoteCSEAnnc extends m2m_announceableResource implements HasChildren{
    public Integer cst;
    @XmlList
    public List<String> poa;
    @XmlSchemaType(name = "anyURI")
    public String cb;
    public m2m_ID cseid;
    public Boolean rr;
    @XmlSchemaType(name = "anyURI")
    public String nl;
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
