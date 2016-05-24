package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 * <p>
 * * <p>Java class for anonymous complex ty.
 * <p>
 * <p>The following schema fragment specifies the expected pc contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableResourceType">
 *       &lt;sequence>
 *         &lt;element nm="appName" ty="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element nm="App-ID" ty="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element nm="AE-ID" ty="{http://www.onem2m.org/xml/protocols}ID"/>
 *         &lt;element nm="pointOfAccess" ty="{http://www.onem2m.org/xml/protocols}pOAList" minOccurs="0"/>
 *         &lt;element nm="ontologyRef" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="nodeLink" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="childResource" ty="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ae", propOrder = {
        "apn",
        "api",
        "aei",
        "poa",
        "or",
        "nl",
        "rr",
        "ch"
})
@XmlRootElement(name = "ae", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_AE extends m2m_announceableResource implements HasChildren {
    public String apn;
    public String api;
    public String aei;
    @XmlList
    @XmlSchemaType(name = "anySimpleType")
    public List<String> poa;
    @XmlSchemaType(name = "anyURI")
    public String or;
    @XmlSchemaType(name = "anyURI")
    public String nl;
    public Boolean rr;
    public List<m2m_childResourceRef> ch;

    //	//TODO 每个resource中都添加一个FieldAccess用来get/set属性
//	private static final FieldAccess access = FieldAccess.get(m2m_AE.class);
//
//	static {
//
//	}
//
//	public FieldAccess getFieldAccess() {
//		return access;
//	}
//
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
