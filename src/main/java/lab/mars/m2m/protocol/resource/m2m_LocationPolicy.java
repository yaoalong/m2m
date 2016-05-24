package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.DurationAdapter;
import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.common.m2m_nodeID;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Duration;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "los",
        "lou",
        "lot",
        "lor",
        "loi",
        "lon",
        "lost",
        "ch"
})
@XmlRootElement(name = "lcp", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_LocationPolicy extends m2m_announceableResource implements HasChildren{
    public Integer los;
    @XmlJavaTypeAdapter(DurationAdapter.class)
    public Duration lou;
    public m2m_nodeID lot;
    @XmlSchemaType(name = "anyURI")
    public String lor;
    @XmlSchemaType(name = "anyURI")
    public String loi;
    public String lon;
    public String lost;
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
