package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.enumeration.m2m_consistencyStrategy;
import lab.mars.m2m.protocol.enumeration.m2m_memberType;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"mt",
		"cnm",
		"mnm",
		"mid",
		"macp",
		"mtv",
		"csy",
		"gn",
		"cr",
		"ch"
})
@XmlRootElement(name = "grp", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_Group extends m2m_announceableResource implements HasChildren {
	/** member ty */
	public m2m_memberType mt;
	/** current number of member */
	public Integer cnm;
	/** max number of member */
	public Integer mnm;
	@XmlList
	@XmlSchemaType(name = "anyURI")
	/**member identifiers*/
	public List<String> mid;
	@XmlSchemaType(name = "anyURI")
	/**membersAccessControlPolicyIDs*/
	public String macp;
	/** memberTypeValidated */
	public Boolean mtv;
	/** consistencyStrategy */
	public m2m_consistencyStrategy csy;
	/** groupName */
	public String gn;
	@XmlSchemaType(name = "anyURI")
	/**creator*/
	public String cr;
	/** children */
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
//
//	public static m2m_Group create(String nm, String parentID, m2m_resource _grp) {
//		m2m_Group group = new m2m_Group();
//		m2m_Group refGroup;
//		if (_grp instanceof m2m_Group)
//			refGroup = (m2m_Group) _grp;
//		else
//			refGroup = group;
//
//		group.ty = m2m_resourceType.group;
//		group.nm = nm;
//		group.pi = new m2m_nhURI(parentID);
//		group.ct = LocalDateTime.now();
//		group.lt = LocalDateTime.now();
//		group.et = LocalDateTime.now().plusHours(1);
//
//		group.mt = (refGroup.mt == null ? m2m_memberType.mixed : refGroup.mt);
//		group.mid = refGroup.mid;
//		//TODO member ID could be remote resource and this requires some attention
//		group.cnm = (group.mid == null ? 0 : group.mid.size());
//		group.mnm = (refGroup.mnm == null ? 10 : refGroup.mnm);
//		group.gn = refGroup.gn;
//		group.ch = new LinkedList<>();
//		group.validate();
//
//		return group;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_Group))
//			return out;
//		m2m_Group rout = (m2m_Group) out;
//		if (rout.mt != null) rout.mt = this.mt;
//		if (rout.cnm != null) rout.cnm = this.cnm;
//		if (rout.mnm != null) rout.mnm = this.mnm;
//		if (rout.mid != null) rout.mid = this.mid;
//		if (rout.mtv != null) rout.mtv = this.mtv;
//		if (rout.csy != null) rout.csy = this.csy;
//		if (rout.gn != null) rout.gn = this.gn;
//		if (rout.cr != null) rout.cr = this.cr;
//		if (rout.ch != null) rout.ch = this.ch;
//		return rout;
//	}
//
//	public boolean update(m2m_resource _u) {
//		if (!(_u instanceof m2m_Group) || !super.update(_u))
//			return false;
//		m2m_Group u = (m2m_Group) _u;
//		if (u.mt != null)
//			this.mt = u.mt;
//		if (u.mid != null)
//			this.mid = u.mid;
//		this.cnm = (this.mid == null ? 0 : this.mid.size());
//		if (u.mnm != null)
//			this.mnm = u.mnm;
//		if (u.gn != null)
//			this.gn = u.gn;
//		validate();
//		return true;
//	}
//
//	public void validate() {
//		//TODO dynamic validate. this requires nami add some features like schedule.
//		if (mt != m2m_memberType.mixed) {//need to validate
//
//		} else {
//			mtv = true;
//		}
//	}
}
