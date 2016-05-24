package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.common.m2m_AnyURIList;
import lab.mars.m2m.protocol.resource.m2m_Container;
import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "announceableResource", namespace = "http://www.onem2m.org/xml/protocols")
@XmlSeeAlso({
		m2m_Container.class
})
public class m2m_announceableResource extends m2m_regularResource {
	@XmlElement
	/**announceTo*/
	public m2m_AnyURIList at;
	@XmlList
	/**announcedAttribute*/
	public List<String> aa;

//	public boolean update(m2m_resource _u) {
//		if (!(_u instanceof m2m_announceableResource) || !super.update(_u))
//			return false;
//		m2m_announceableResource u = (m2m_announceableResource) _u;
//		if (u.at != null)
//			this.at = u.at;
//		if (u.aa != null)
//			this.aa = u.aa;
//		return true;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_announceableResource))
//			return out;
//		m2m_announceableResource rout = (m2m_announceableResource) out;
//		if (rout.at != null) rout.at = this.at;
//		if (rout.aa != null) rout.aa = this.aa;
//		return rout;
//	}

}
