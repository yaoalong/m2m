package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.DurationAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Duration;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "batchNotify", propOrder = {
        "num",
        "dur"
})
public class m2m_batchNotify {
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer num;
    @XmlJavaTypeAdapter(DurationAdapter.class)
    public Duration dur;
}
