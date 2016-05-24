package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.DateAdapter;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 */
public class m2m_filterCriteria {
    /**
     * The creationTime attribute of the resource is chronologically before the specified v.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime crb;
    /**
     * The creationTime attribute of the resource is chronologically after the specified v.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime cra;
    /**
     * The lastModifiedTime attribute of the resource is chronologically after the specified v.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime ms;
    /**
     * The lastModifiedTime attribute of the resource is chronologically before the specified v.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime us;
    /**
     * The stateTag attribute of the resource is smaller than the specified v.
     */
    public Integer sts;
    /**
     * The stateTag attribute of the resource is bigger than the specified v.
     */
    public Integer stb;
    /**
     * The expirationTime attribute of the resource is chronologically before the specified v.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime exb;
    /**
     * The expirationTime attribute of the resource is chronologically after the specified v.
     */
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime exa;
    /**
     * The labels attributes of the resource matches the specified v.
     */
//	public m2m_labelsType lbl;
    @XmlList
    public List<String> lbl;
    /**
     * The ty attribute of the resource is the same as the specified v. It also allows differentiating between normal and announced resources
     * .
     */
//	m2m_resourceType rty;
    @XmlList
    public List<Integer> rty;
    /**
     * The contentSize attribute of the &lt;contentinstance> resource is equal to_servAddr or greater than the specified v.
     */
    public Integer sza;
    /**
     * The contentSize attribute of the &lt;contentinstance> resource is smaller than the specified v.
     */
    public Integer szb;
    /**
     * The typeOfContent attribute of the &lt;contentinstance> resource matches the specified v.
     */
    public List<String> cty;
    /**
     * Limitation the number of matching resources to_servAddr the specified v.
     */
    public Integer lim;
    /**
     * This is an attribute of resource types (clause 9.6). Therefore, a real tag nm is variable and depends on its usage. E.g. creator of container
     * resource ty can be used as a filter criteria tag as "creator=Sam".
     */
    @XmlList
    public List<m2m_attribute> atr;
    /**
     * Indicates how the filter criteria is used. E.g. if this parameter is not provided, the Retrieve op is for generic retrieve op. If filterUsage
     * is provided, the Retrieve op is for resource <discovery> (clause 10.2.6).
     */
    public String fu;

}
