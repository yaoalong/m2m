package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.resource.m2m_announceableSubordinateResource;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cin", propOrder = {
		"st",
		"cr",
		"cnf",
		"cs",
		"or",
		"con",
})
@XmlRootElement(name = "cin", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_ContentInstance extends m2m_announceableSubordinateResource {
	@XmlSchemaType(name = "nonNegativeInteger")
	/**stateTag*/
	public Integer st;
	/**creator*/
	public String cr;
	/** contentInfo */
	public String cnf;
	@XmlSchemaType(name = "nonNegativeInteger")
	/**contentSize*/
	public Integer cs;
	@XmlSchemaType(name = "anyURI")
	/**ontologyRef*/
	public String or;
	/** content */
	public byte[] con;//温度信息
//
//	public static m2m_ContentInstance create(String nm, String parentID, m2m_resource _cin) {
//		m2m_ContentInstance cin = new m2m_ContentInstance();
//		m2m_ContentInstance refCin;
//		if (_cin instanceof m2m_ContentInstance)
//			refCin = (m2m_ContentInstance) _cin;
//		else
//			refCin = cin;
//
//		cin.ty = m2m_resourceType.contentinstance;
////		nm = (nm == null ? "contentinstance" + (++count) : nm);
////		cin.resourceID = new m2m_ID(parentID + "/" + nm);
//		cin.pi = new m2m_nhURI(parentID);
//		cin.ct = LocalDateTime.now();
//		cin.lt = LocalDateTime.now();
//		cin.nm = nm;
//
//		cin.st = 0;
//		cin.cs = (refCin.con != null ? refCin.con.length : 0);
//		cin.con = refCin.con;
//		return cin;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_ContentInstance))
//			return out;
//		m2m_ContentInstance rout = (m2m_ContentInstance) out;
//		if (rout.st != null) rout.st = this.st;
//		if (rout.cnf != null) rout.cnf = this.cnf;
//		if (rout.cs != null) rout.cs = this.cs;
//		if (rout.or != null) rout.or = this.or;
//		if (rout.con != null) rout.con = this.con;
//		return rout;
//	}
//
//	public boolean update(m2m_resource _u) {
//		return false;
//	}
}
