package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.common.m2m_acpType;
import lab.mars.m2m.protocol.resource.m2m_CSEBase;
import lab.mars.m2m.protocol.resource.m2m_resource;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regularResource", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
		"acpi",
		"et"
})
@XmlSeeAlso({
		m2m_CSEBase.class
})
public class m2m_regularResource extends m2m_resource {
	/**accessControlPolicyIDs*/
	public m2m_acpType acpi;
	@XmlElement(defaultValue  = "2014-06-09T23:15:04")
//	@XmlJavaTypeAdapter(DateAdapter.class)
	/**expirationTime*/
	public Date et;

//	public boolean update(m2m_resource _u) {
//		if (!(_u instanceof m2m_regularResource) || !super.update(_u))
//			return false;
//		m2m_regularResource u = (m2m_regularResource) _u;
//		if (u.acpi != null)
//			this.acpi = u.acpi;
//		if (u.et != null)
//			this.et = u.et;
//		return true;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		super.retrieve(out);
//		if (!(out instanceof m2m_regularResource))
//			return out;
//		m2m_regularResource rout = (m2m_regularResource) out;
//		if (rout.acpi != null) rout.acpi = this.acpi;
//		if (rout.et != null) rout.et = this.et;
//		return rout;
//	}


}
