package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.resource.m2m_resource;

import javax.xml.bind.annotation.*;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 * <p/>
 * * <p>Java class for childResourceRef complex ty.
 * <p/>
 * <p>The following schema fragment specifies the expected pc contained within this class.
 * <p/>
 * <pre>
 * &lt;xs:complexType nm="childResourceRef">
 *      &lt;xs:simpleContent>
 *          &lt;xs:extension base="xs:anyURI">
 *              &lt;xs:attribute nm="nm" ty="xs:string"/>
 *              &lt;xs:attribute nm="ty" ty="m2m:ty"/>
 *          &lt;/xs:extension>
 *      &lt;/xs:simpleContent>
 * &lt;/xs:complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "childResourceRef", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_childResourceRef {
	@XmlValue
	@XmlSchemaType(name = "anyURI")
	public String v;
	@XmlAttribute
	public String rn;
	@XmlAttribute
	public Integer ty;

	public m2m_childResourceRef() {
	}

	public m2m_childResourceRef(m2m_resource childResource) {
		this(childResource.ri, childResource.rn, childResource.ty);
	}

	public m2m_childResourceRef(String value, String name, Integer type) {
		this.v = value;
		this.rn = name;
		this.ty = type;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		m2m_childResourceRef ref = (m2m_childResourceRef) o;

		if (v != null ? !v.equals(ref.v) : ref.v != null) return false;
		if (rn != null ? !rn.equals(ref.rn) : ref.rn != null) return false;
		return ty.equals(ref.ty);

	}

	@Override public int hashCode() {
		int result = v != null ? v.hashCode() : 0;
		result = 31 * result + (rn != null ? rn.hashCode() : 0);
		result = 31 * result + (ty != null ? ty.hashCode() : 0);
		return result;
	}

	//	@Override
//	public boolean equals(Object o) {
//		if (o instanceof m2m_childResourceRef) {
//			m2m_childResourceRef child = (m2m_childResourceRef) o;
//			return ty.equals(child.ty) && v.equals(child.v) && nm.equals(child.nm);
//		}
//		return false;
//	}
}
