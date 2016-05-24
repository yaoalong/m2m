package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.DurationAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Duration;

/**
 * Created by haixiao on 14/12/1.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rateLimit", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "number",
        "rateLimitWindow"
})
public class m2m_rateLimit {
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer number;
    @XmlJavaTypeAdapter(DurationAdapter.class)
    public Duration rateLimitWindow;
}
