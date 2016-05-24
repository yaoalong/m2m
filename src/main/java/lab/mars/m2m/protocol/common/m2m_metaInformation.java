package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.DurationAdapter;
import lab.mars.m2m.protocol.enumeration.m2m_discResType;
import lab.mars.m2m.protocol.enumeration.m2m_resourceType;
import lab.mars.m2m.protocol.enumeration.m2m_responseType;
import lab.mars.m2m.protocol.enumeration.m2m_resultContent;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by haixiao on 14/12/1.
 * according to_servAddr TS0004 v0.8.0
 */
public class m2m_metaInformation {
    public m2m_resourceType resourceType;
    public LocalDateTime originatingTimestamp;
    public LocalDateTime requestExpirationTimestamp;
    public LocalDateTime resultExpirationTimestamp;
    public LocalDateTime operationalExecutionTime;
    public m2m_responseType responseType;
    @XmlJavaTypeAdapter(DurationAdapter.class)
    public Duration resultPersistence;
    public m2m_resultContent resultContent;
    public m2m_eventCat eventCategory;
    public Boolean deliveryAggregation;
    public String groupRequestIdentifier;
    public m2m_filterCriteria filterCriteria;
    public m2m_discResType discoveryResultType;
    public String role;
}
