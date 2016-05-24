package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 2015/4/1.
 * Email: wumo@outlook.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notification", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
		"nev",
		"vrq",
		"sud",
		"sur",
		"cr",
		"nfu"
})
public class m2m_notification {
	public m2m_notificationEvent nev;
	public boolean vrq;
	public boolean sud;
	@XmlSchemaType(name = "anyURI")
	public String sur;
	@XmlSchemaType(name = "anyURI")
	public String cr;
	@XmlSchemaType(name = "anyURI")
	public String nfu;
}
