package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.enumeration.m2m_resourceStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificationEvent", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "representation",
        "rss",
        "om"
})
public class m2m_notificationEvent {
    public String representation;
    public m2m_resourceStatus rss;
    public m2m_operationMonitor om;
}
