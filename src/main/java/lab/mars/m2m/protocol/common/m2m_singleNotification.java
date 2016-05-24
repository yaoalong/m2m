package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlSchemaType;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
public class m2m_singleNotification {
    public m2m_notificationEvent notificationEvent;
    public Boolean verificationRequest;
    public Boolean subscriptionDeletion;
    @XmlSchemaType(name = "anyURI")
    public String subscriptionReference;

    public m2m_ID creator;
    @XmlSchemaType(name = "anyURI")
    public String notificationForwardingURI;
}
