package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rebootArgsType", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_rebootArgsType {
    public List<m2m_anyArgType> anyArg;
}
