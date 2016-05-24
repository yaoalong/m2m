package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.*;
import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "enc",
        "exc",
        "nu",
        "gi",
        "nfu",
        "bn",
        "rl",
        "psn",
        "pn",
        "nsp",
        "ln",
        "nct",
        "nec",
        "cr",
        "su",
        "ch"
})
@XmlRootElement(name = "sub", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_Subscription extends m2m_regularResource implements HasChildren {
    /** eventNotificationCriteria */
    public m2m_eventNotificationCriteria enc;//TODO 事件类型
    @XmlSchemaType(name = "positiveInteger")
    /**expirationCounter*/
    public Integer exc;
    /** notificationURI */
    public m2m_AnyURIList nu;  //TODO 发到哪里
    @XmlSchemaType(name = "anyURI")
    /**groupID*/
    public String gi;
    @XmlSchemaType(name = "anyURI")
    /**notificationForwardingURI*/
    public String nfu;
    /** batchNotify */
    public m2m_batchNotify bn;
    /** rateLimit */
    public m2m_rateLimit rl;
    @XmlSchemaType(name = "positiveInteger")
    /**preSubscriptionNotify*/
    public Integer psn;
    /** pendingNotification */
    public Integer pn;
    @XmlSchemaType(name = "positiveInteger")
    /**notificationStoragePriority*/
    public Integer nsp;
    @XmlElement(defaultValue = "false")
    /**latestNotify*/
    public Boolean ln;
    @XmlElement(required = true)
    /**notificationContentType*/
    public Integer nct;
    /** notificationEventCat */
    public m2m_eventCat nec;
    /** creator */
    public String cr;
    @XmlSchemaType(name = "anyURI")
    /**subscriberURI*/
    public String su;
    /** children */
    public List<m2m_childResourceRef> ch;


//	public static m2m_Subscription create(String nm, String parentID, m2m_resource _sub) {
//		m2m_Subscription sub;
//		if (_sub == null || !(_sub instanceof m2m_Subscription))
//			sub = new m2m_Subscription();
//		else
//			sub = (m2m_Subscription) _sub;
//		sub.ty = m2m_resourceType.subscription;
//		sub.pi = new m2m_nhURI(parentID);
//		sub.ct = LocalDateTime.now();
//		sub.lt = LocalDateTime.now();
//		sub.et = LocalDateTime.now().plusHours(1);
//		sub.nm = nm;
//
//		sub.cr = new m2m_ID(parentID);
//		sub.ch = new ArrayList<>();
//		return sub;
//	}

    @Override public List<m2m_childResourceRef> children() {
        return ch;
    }

    @Override public void setChildren(List<m2m_childResourceRef> children) {
        this.ch = children;
    }

    @Override public void remove(m2m_childResourceRef child) {
        if (ch != null)
            ch.remove(child);
    }

    @Override public void add(m2m_childResourceRef child) {
        if (ch != null)
            ch.add(child);
    }
}
