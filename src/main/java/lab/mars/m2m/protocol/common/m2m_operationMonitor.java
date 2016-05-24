package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.enumeration.m2m_operation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationMonitorType", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "opr",
        "org"
})
public class m2m_operationMonitor {
    public m2m_operation opr;
    public m2m_ID org;
}
