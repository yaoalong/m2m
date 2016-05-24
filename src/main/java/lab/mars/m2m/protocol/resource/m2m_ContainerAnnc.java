package lab.mars.m2m.protocol.resource;

import lab.mars.m2m.protocol.HasChildren;
import lab.mars.m2m.protocol.HasStateTag;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
import lab.mars.m2m.protocol.resource.m2m_announceableResource;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by haixiao on 14/11/17.
 * according to_servAddr TS0004 v0.8.0
 * *<p>Java class for anonymous complex ty.
 * <p>The following schema fragment specifies the expected pc contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.onem2m.org/xml/protocols}announceableResourceType">
 *       &lt;sequence>
 *         &lt;element nm="creator" ty="{http://www.onem2m.org/xml/protocols}id"/>
 *         &lt;element nm="maxNrOfInstances" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element nm="maxByteSize" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element nm="maxInstanceAge" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element nm="currentNrOfInstances" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element nm="currentByteSize" ty="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element nm="latest" ty="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element nm="locationID" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="ontologyRef" ty="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element nm="childResource" ty="{http://www.onem2m.org/xml/protocols}childResourceRef" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cntA", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "st",
        "mni",
        "mbs",
        "mia",
        "cni",
        "cbs",
        "la",
        "li",
        "or",
        "ch",
})
@XmlRootElement(name = "cntA", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_ContainerAnnc extends m2m_announceableResource implements HasChildren, HasStateTag {
    //    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer st;
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer mni;
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer mbs;
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer mia;
    //    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer cni;
    //    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    public Integer cbs;
    public String la;
    @XmlSchemaType(name = "anyURI")
    public String li;
    @XmlSchemaType(name = "anyURI")
    public String or;
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

    @Override public Integer getStateTag() {return st;}

//     @XmlElements({
//    @XmlElement(nm = "contentinstance", namespace = "http://www.onem2m.org/xml/protocols", ty = ContentInstanceType.class),
//    @XmlElement(nm = "container", namespace = "http://www.onem2m.org/xml/protocols", ty = ContainerType.class),
//    @XmlElement(nm = "subscription", namespace = "http://www.onem2m.org/xml/protocols", ty = lab.mars.m2m.jaxb.container.Subscription.class),
//    @XmlElement(nm = "containerAnnc", namespace = "http://www.onem2m.org/xml/protocols", ty = ContainerAnnc.class)
//})
//    public List<m2m_resource> childResources;
}
