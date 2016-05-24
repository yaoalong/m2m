package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.HasStateTag;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 * *<p>Java class for anonymous complex ty.
 * <p>The following schema fragment specifies the expected pc contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableResourceType">
 *       &lt;sequence>
 *         &lt;element nm="creator" ty="{http://www.onem2m.org/xml/protocols}id"/>
 *         &lt;element nm="maxNrOfInstances" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element nm="maxByteSize" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element nm="maxInstanceAge" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element nm="currentNrOfInstances" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element nm="currentByteSize" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element nm="latest" ty="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element nm="locationID" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="ontologyRef" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="childResource" ty="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cnt", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "st",
        "cr",
        "mni",
        "mbs",
        "mia",
        "cni",
        "cbs",
        "li",
        "or",
        "la",
        "ol",
        "ch",
})
@XmlRootElement(name = "cnt", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_Container extends m2m_announceableResource implements HasChildren, HasStateTag {

    @XmlSchemaType(name = "nonNegativeInteger")
    /**stateTag*/
    public Integer st;
    /** creator */
    public String cr;
    @XmlSchemaType(name = "nonNegativeInteger")
    /**maxNrOfInstances*/
    public Integer mni;
    @XmlSchemaType(name = "nonNegativeInteger")
    /**maxByteSize*/
    public Integer mbs;
    @XmlSchemaType(name = "nonNegativeInteger")
    /**maxInstanceAge*/
    public Integer mia;
    @XmlSchemaType(name = "nonNegativeInteger")
    /**currentNrOfInstances*/
    public Integer cni;
    @XmlSchemaType(name = "nonNegativeInteger")
    /**currentByteSize*/
    public Integer cbs;
    @XmlSchemaType(name = "anyURI")
    /**locationID*/
    public String li;
    @XmlSchemaType(name = "anyURI")
    /**ontologyRef*/
    public String or;

    /** latest */
    public String la;
    /** oldest */
    public String ol;
    /** children */
    public List<m2m_childResourceRef> ch;

//
//	public m2m_Container() {}
//
//	public static m2m_Container create(String nm, String parentID, m2m_resource _cnt) {
//		m2m_Container cnt = new m2m_Container();
//		m2m_Container refCnt;
//		if (_cnt instanceof m2m_Container)
//			refCnt = (m2m_Container) _cnt;
//		else
//			refCnt = cnt;
//
//		cnt.ty = m2m_resourceType.container;
////		nm = (nm == null ? "container" + (++count) : nm);
////		cnt.resourceID = new m2m_ID(parentID + "/" + nm);
//		cnt.pi = new m2m_nhURI(parentID);
//		cnt.ct = LocalDateTime.now();
//		cnt.lt = LocalDateTime.now();
//		cnt.et = LocalDateTime.now().plusHours(1);
//		cnt.nm = nm;
//
//		cnt.st = 0;
//		//        cnt.creator = new m2m_ID("cse01");
//		cnt.mni = (refCnt.mni == null ? Integer.MAX_VALUE : refCnt.mni);
//		cnt.mbs = (refCnt.mbs == null ? Integer.MAX_VALUE : refCnt.mbs);
//		cnt.mia = (refCnt.mia == null ? Integer.MAX_VALUE : refCnt.mia);
//		cnt.cbs = 0;
//		cnt.cni = 0;
//		cnt.la = null;
//		cnt.li = null;
//		//        cnt.ontologyRef = "/containerOntology01";
//
//		cnt.ch = new LinkedList<>();
//		return cnt;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_Container))
//			return out;
//		m2m_Container rout = (m2m_Container) out;
//		if (rout.st != null) rout.st = this.st;
//		if (rout.cr != null) rout.cr = this.cr;
//		if (rout.mni != null) rout.mni = this.mni;
//		if (rout.mbs != null) rout.mbs = this.mbs;
//		if (rout.mia != null) rout.mia = this.mia;
//		if (rout.cni != null) rout.cni = this.cni;
//		if (rout.cbs != null) rout.cbs = this.cbs;
//		if (rout.la != null) rout.la = this.la;
//		if (rout.li != null) rout.li = this.li;
//		if (rout.or != null) rout.or = this.or;
//		if (rout.ch != null) rout.ch = this.ch;
//		return rout;
//	}
//
//	public boolean update(m2m_resource _u) {
//		if (!(_u instanceof m2m_Container) || !super.update(_u))
//			return false;
//		m2m_Container u = (m2m_Container) _u;
//		this.st++;
//		if (u.mni != null)
//			this.mni = u.mni;
//		if (u.mbs != null)
//			this.mbs = u.mbs;
//		if (u.mia != null)
//			this.mia = u.mia;
//		if (u.li != null)
//			this.li = u.li;
//		if (u.or != null)
//			this.or = u.or;
//		return true;
//	}

    @Override public List<m2m_childResourceRef> children() {
        return ch;
    }

    @Override public void setChildren(List<m2m_childResourceRef> children) {
        this.ch = children;
    }

    @Override public void remove(m2m_childResourceRef child) {
        if (ch != null) ch.remove(child);
    }

    @Override public void add(m2m_childResourceRef child) {
        if (ch != null) ch.add(child);
    }

    @Override public Integer getStateTag() {return st;}
}
