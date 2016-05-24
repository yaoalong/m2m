package lab.mars.m2m.protocol.informal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 2015/6/15.
 * Email: wumo@outlook.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartialRetrieve", namespace = "http://www.onem2m.org/xml/protocols")
public class PartialRetrieve {
    @XmlList
    public List<String> attributes;
}
