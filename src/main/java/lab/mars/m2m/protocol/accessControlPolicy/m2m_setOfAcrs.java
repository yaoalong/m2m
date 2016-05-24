package lab.mars.m2m.protocol.accessControlPolicy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setOfAcrs", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "accessControlRule"
})
public class m2m_setOfAcrs {
//    @XmlElement(required = true)
    protected List<m2m_accesControlRule> accessControlRule;
}
