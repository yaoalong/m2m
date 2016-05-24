package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.common.m2m_externalID;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 * <p>Java class for anonymous complex ty.
 * <p>The following schema fragment specifies the expected pc contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableResourceType">
 *       &lt;sequence>
 *         &lt;element nm="cseType" ty="{http://www.onem2m.org/xml/protocols}cseTypeID" minOccurs="0"/>
 *         &lt;element nm="pointOfAccess" ty="{http://www.onem2m.org/xml/protocols}pOAList" minOccurs="0"/>
 *         &lt;element nm="CSEBase" ty="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element nm="CSE-ID" ty="{http://www.onem2m.org/xml/protocols}id"/>
 *         &lt;element nm="M2M-Ext-ID" ty="{http://www.onem2m.org/xml/protocols}externalId" minOccurs="0"/>
 *         &lt;element nm="Trigger-Recipient-ID" ty="{http://www.onem2m.org/xml/protocols}triggerRecipientId" minOccurs="0"/>
 *         &lt;element nm="requestReachability" ty="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element nm="nodeLink" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="childResource" ty="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"cst",
		"poa",
		"cb",
		"csi",
		"mei",
		"tri",
		"rr",
		"nl",
		"ch"
})
@XmlRootElement(name = "csr", namespace = "http://www.onem2m.org/xml/protocols")

public class m2m_RemoteCSE extends m2m_announceableResource implements HasChildren {
	/**cse ty*/
	public Integer cst;
	@XmlList
	/**point of access*/
	public List<String> poa;
	@XmlSchemaType(name = "anyURI")
	/**csebase*/
	public String cb;
	/**CSE-ID*/
	public m2m_ID csi;
	/**M2M-Ext-ID*/
	public m2m_externalID mei;
	@XmlSchemaType(name = "unsignedInt")
	/**Trigger-Recipient-ID*/
	public Integer tri;
	/**requestReachability*/
	public Boolean rr;
	/**nodelink*/
	public URI nl;
	/**children*/
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
//	public static m2m_RemoteCSE create(String nm, String parentID, m2m_resource rcse) {
//		m2m_RemoteCSE resource = new m2m_RemoteCSE();
//		m2m_RemoteCSE ref;
//		if (rcse instanceof m2m_RemoteCSE)
//			ref = (m2m_RemoteCSE) rcse;
//		else
//			ref = resource;
//
//		resource.ty = m2m_resourceType.remoteCSE;
//		resource.pi = new m2m_nhURI(parentID);
//		resource.ct = (ref.ct == null ? LocalDateTime.now() : ref.ct);
//		resource.lt = (ref.lt == null ? LocalDateTime.now() : ref.lt);
//		resource.et = (ref.et == null ? LocalDateTime.now().plusHours(1) : ref.et);
//		resource.nm = ref.nm;
//		resource.lbl = ref.lbl;
//
//		resource.cst = ref.cst;
//		resource.csi = ref.csi;
//
//		resource.poa = ref.poa;
//		resource.nl = ref.nl;
//		resource.cb = ref.cb;
//		resource.ch = ref.ch;
//		resource.mei = ref.mei;
//		resource.tri = ref.tri;
//		resource.rr = ref.rr;
//		return resource;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_RemoteCSE))
//			return out;
//		m2m_RemoteCSE rout = (m2m_RemoteCSE) out;
//		if (rout.cst != null) rout.cst = this.cst;
//		if (rout.csi != null) rout.csi = this.csi;
//		if (rout.cb != null) rout.cb = this.cb;
//		if (rout.poa != null) rout.poa = this.poa;
//		if (rout.mei != null) rout.mei = this.mei;
//		if (rout.tri != null) rout.tri = this.tri;
//		if (rout.rr != null) rout.rr = this.rr;
//		if (rout.nl != null) rout.nl = this.nl;
//		if (rout.ch != null) rout.ch = this.ch;
//		return rout;
//	}
//
//	public boolean update(m2m_resource _u) {
//		if (!(_u instanceof m2m_RemoteCSE) || !super.update(_u))
//			return false;
//		m2m_RemoteCSE u = (m2m_RemoteCSE) _u;
//
//		if (u.cst != null)  this.cst =u.cst;
//		if (u.csi != null) this.csi =u.csi ;
//		if (u.cb != null) this.cb =u.cb ;
//		if (u.poa != null) this.poa =u.poa ;
//		if (u.mei != null) this.mei =u.mei ;
//		if (u.tri != null) this.tri =u.tri ;
//		if (u.rr != null) this.rr =u.rr ;
//		if (u.nl != null) this.nl =u.nl ;
//		return true;
//	}
}
