package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pollingData"
})
@XmlRootElement(name = "pollingChannelURI", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_PollingChannelURI extends m2m_regularResource {
    public List<String> pollingData;
}
