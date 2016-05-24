package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "execReqArgsType", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "download",
        "upload",
        "reboot",
        "reset",
        "anyArg"
})
public class m2m_execReqArgsType {

    @XmlElement(name = "Download")
    public m2m_downloadArgsType download;
    @XmlElement(name = "Upload")
    public m2m_uploadArgsType upload;
    @XmlElement(name = "Reboot")
    public m2m_rebootArgsType reboot;
    @XmlElement(name = "Reset")
    public m2m_resetArgsType reset;
    @XmlElement(name = "AnyArg")
    public m2m_anyArgsListType anyArg;
}
