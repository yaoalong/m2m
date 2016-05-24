package lab.mars.m2m.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class m2m_filterCriteria {
    public LocalDateTime crb;
    public LocalDateTime cra;
    public LocalDateTime ms;
    public LocalDateTime us;
    /** The stateTag attribute of the resource is smaller than the specified v. */
    public Integer sts;
    /** The stateTag attribute of the resource is bigger than the specified v. */
    public Integer stb;
    public LocalDateTime exb;
    public LocalDateTime exa;
    /** The labels attributes of the resource matches the specified v. */
    public m2m_labelsType lbl;
    /** The ty attribute of the resource is the same as the specified v. It also allows differentiating between normal and announced resources
     * . */
    m2m_resourceType rty;
    /** The contentSize attribute of the &lt;contentinstance> resource is equal to_servAddr or greater than the specified v. */
    public Integer sza;
    /** The contentSize attribute of the &lt;contentinstance> resource is smaller than the specified v. */
    public Integer szb;
    /** The typeOfContent attribute of the &lt;contentinstance> resource matches the specified v. */
    public String cty;
    /** Limitation the number of matching resources to_servAddr the specified v. */
    public Integer lim;
    /**
     * This is an attribute of resource types (clause 9.6). Therefore, a real tag nm is variable and depends on its usage. E.g. creator of container
     * resource ty can be used as a filter criteria tag as "creator=Sam".
     */
    public m2m_attribute atr;
    /**
     * Indicates how the filter criteria is used. E.g. if this parameter is not provided, the Retrieve op is for generic retrieve op. If filterUsage
     * is provided, the Retrieve op is for resource <discovery> (clause 10.2.6).
     */
    public String fu;

    public boolean check(m2m_resource resource) {
        //TODO impl
        return true;
    }
}
