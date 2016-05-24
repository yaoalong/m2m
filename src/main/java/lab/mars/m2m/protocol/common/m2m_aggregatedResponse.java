package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.primitive.m2m_rsp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * User: Gxkl
 * Time: 2016.3.29
 * Copyright © Gxkl. All Rights Reserved.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agr", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "rsp"
})
@XmlRootElement(name = "agr", namespace = "http://www.onem2m.org/xml/protocols")
public class m2m_aggregatedResponse {
    public List<m2m_rsp> rsp;
}
