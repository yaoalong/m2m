package lab.mars.m2m.protocol.accessControlPolicy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/12/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accessControlContexts", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "accessControlWindows",
        "accessControlIpAddresses",
        "accessControlLocationRegions"
})
public class m2m_accessControlContexts {
    public List<m2m_accessControlWindows> accessControlWindows;
    public List<m2m_accessControlIpAddresses> accessControlIpAddresses;
    public List<m2m_accessControlLocationRegions> accessControlLocationRegions;
}
