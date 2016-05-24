package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventNotificationCriteria", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_eventNotificationCriteria {
	/** The creationTime attribute of the resource is chronologically before the specified v. */
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date crb;
	/** The creationTime attribute of the resource is chronologically after the specified v. */
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date cra;
	/** The lastModifiedTime attribute of the resource is chronologically after the specified v. */
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date ms;
	/** The lastModifiedTime attribute of the resource is chronologically before the specified v. */
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date us;
	/** The stateTag attribute of the resource is smaller than the specified v. */
	@XmlSchemaType(name = "positiveInteger")
	public Integer sts;
	/** The stateTag attribute of the resource is bigger than the specified v. */
	@XmlSchemaType(name = "nonNegativeInteger")
	public Integer stb;
	/** The expirationTime attribute of the resource is chronologically before the specified v. */
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date exb;
	/** The expirationTime attribute of the resource is chronologically after the specified v. */
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date exa;
	/** The contentSize attribute of the &lt;contentinstance> resource is equal to_servAddr or greater than the specified v. */
	@XmlSchemaType(name = "nonNegativeInteger")
	public Integer sza;
	/** The contentSize attribute of the &lt;contentinstance> resource is smaller than the specified v. */
	@XmlSchemaType(name = "positiveInteger")
	public Integer szb;
	public List<Integer> rss;
	public List<Integer> om;
	/** This is an attribute of resource types (clause 9.6). Therefore, a real tag nm is variable and depends on its usage. E.g. creator of container resource ty can be used as a filter criteria tag as "creator=Sam" */
	public List<m2m_attribute> atr;
}
