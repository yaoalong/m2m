package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_aggregatedNotification;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.common.m2m_deliveryMetaData;
import lab.mars.m2m.protocol.common.m2m_eventCat;
import lab.mars.m2m.protocol.resource.m2m_regularResource;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 * according to_servAddr TS0004 v0.8.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"sr",
		"tg",
		"ls",
		"ec",
		"dmd",
		"arg",
		"ch"
})
@XmlRootElement(name = "dlv")
public class m2m_Delivery extends m2m_regularResource implements HasChildren {
	@XmlSchemaType(name = "anyURI")
	public String sr;
	@XmlSchemaType(name = "anyURI")
	public String tg;
//	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date ls;
	public m2m_eventCat ec;
	public m2m_deliveryMetaData dmd;
	public m2m_aggregatedNotification arg;
	public List<m2m_childResourceRef> ch;


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
