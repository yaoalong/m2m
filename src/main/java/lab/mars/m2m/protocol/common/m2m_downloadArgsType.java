package lab.mars.m2m.protocol.common;

import lab.mars.m2m.protocol.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadArgsType", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "fileType",
        "url",
        "username",
        "password",
        "filesize",
        "targetFile",
        "delaySeconds",
        "successURL",
        "startTime",
        "anyArg"
})
public class m2m_downloadArgsType {

//    @XmlElement(nm = "FileType", required = true)
    @XmlElement(name = "FileType")
    public String fileType;
//    @XmlElement(nm = "URL", required = true)
    @XmlElement(name = "URL")
    @XmlSchemaType(name = "anyURI")
    public String url;
//    @XmlElement(nm = "Username", required = true)
    @XmlElement(name = "Username")
    public String username;
//    @XmlElement(nm = "Password", required = true)
    @XmlElement(name = "Password")
    public String password;
//    @XmlElement(nm = "Filesize", required = true)
    @XmlElement(name = "Filesize")
    public String filesize;
//    @XmlElement(nm = "TargetFile", required = true)
    @XmlElement(name = "TargetFile")
    public String targetFile;
    @XmlElement(name = "DelaySeconds")
    public Integer delaySeconds;
//    @XmlElement(nm = "SuccessURL", required = true)
    @XmlElement(name = "SuccessURL")
    @XmlSchemaType(name = "anyURI")
    public String successURL;
//    @XmlElement(nm = "StartTime", required = true)
    @XmlElement(name = "StartTime")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDateTime startTime;
    @XmlElement(name = "AnyArg")
    public m2m_anyArgsListType anyArg;
}
