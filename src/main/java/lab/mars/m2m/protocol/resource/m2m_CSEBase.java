package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_acpType;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.resource.m2m_resource;

import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 * <p>Java class for anonymous complex ty.
 * <p>The following schema fragment specifies the expected pc contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}regularResourceType">
 *       &lt;sequence>
 *         &lt;element nm="cseType" ty="{http://www.onem2m.org/xml/protocols}cseTypeID" minOccurs="0"/>
 *         &lt;element nm="CSE-ID" ty="{http://www.onem2m.org/xml/protocols}id"/>
 *         &lt;element nm="supportedResourceType" ty="{http://www.onem2m.org/xml/protocols}resourceTypeList"/>
 *         &lt;element nm="pointOfAccess" ty="{http://www.onem2m.org/xml/protocols}pOAList"/>
 *         &lt;element nm="nodeLink" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="notificationCongestionPolicy" ty="{http://www.onem2m.org/xml/protocols}notificationCongestionPolicy" minOccurs="0"/>
 *         &lt;element nm="childResource" ty="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csb", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "acpi",
        "cst",
        "csi",
        "srt",
        "poa",
        "nl",
        "ch"
})
@XmlRootElement(name = "csb", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_CSEBase extends m2m_resource implements HasChildren {
    /** accessControlPolicyIDs */
    public m2m_acpType acpi;
    /** cse ty */
    public Integer cst;
    /** CSE-ID */
    public String csi;
    /** supportedResourceType */
    public List<Integer> srt;
    @XmlList
    /**point of access*/
    public List<String> poa;
    /** node link */
    public URI nl;
    /** children */
    public List<m2m_childResourceRef> ch;
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_CSEBase))
//			return out;
//		m2m_CSEBase rout = (m2m_CSEBase) out;
//		if (rout.cst != null) rout.cst = this.cst;
//		if (rout.csi != null) rout.csi = this.csi;
//		if (rout.srt != null) rout.srt = this.srt;
//		if (rout.poa != null) rout.poa = this.poa;
//		if (rout.nl != null) rout.nl = this.nl;
//		if (rout.ncp != null)
//			rout.ncp = this.ncp;
//		if (rout.ch != null) rout.ch = this.ch;
//		return rout;
//	}
//
//	public boolean update(m2m_resource u) {
//		return false;
//	}

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
