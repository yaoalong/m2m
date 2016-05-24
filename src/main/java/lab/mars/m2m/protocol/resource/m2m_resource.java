package lab.mars.m2m.protocol.resource;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resource", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
		"ty",
		"ri",
		"pi",
		"ct",
		"lt",
		"lbl"
})
//@XmlRootElement(nm = "resource", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_resource {
	/**resource ty*/
	public Integer ty;
	/**resourceID*/
	public String ri;
	/**parentID*/
	public String pi;
	@XmlElement(defaultValue  = "2014-06-09T23:15:04")
//	@XmlJavaTypeAdapter(DateAdapter.class)
	/**creationTime*/
	public Date ct;
	@XmlElement(defaultValue  = "2014-06-09T23:15:04")
//	@XmlJavaTypeAdapter(DateAdapter.class)
	/**lastModifiedTime*/
	public Date lt;
	@XmlList
	/**label*/
	public List<String> lbl;
	@XmlAttribute
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "token")
	/**nm*/
	public String rn;

//	public boolean update(m2m_resource u) {
//		if (u == null)
//			return false;
//		this.lt = LocalDateTime.now();
//		if (u.lbl != null)
//			this.lbl = u.lbl;
//		return true;
//	}
//
//	public m2m_resource retrieve(m2m_resource out) {
//		if (out == null)
//			return this;
//		if (out.ty != null) out.ty = this.ty;
//		if (out.ri != null) out.ri = this.ri;
//		if (out.pi != null) out.pi = this.pi;
//		if (out.ct != null) out.ct = this.ct;
//		if (out.lt != null) out.lt = this.lt;
//		if (out.lbl != null) out.lbl = this.lbl;
//		if (out.nm != null) out.nm = this.nm;
//		return out;
//	}
}
