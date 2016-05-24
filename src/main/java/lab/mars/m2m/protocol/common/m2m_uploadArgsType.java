package lab.mars.m2m.protocol.common;

import javax.xml.bind.annotation.*;

/**
 * Created by haixiao on 14/11/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadArgsType", namespace = "http://www.onem2m.org/xml/protocols", propOrder = {
        "fileType",
        "url",
        "username",
        "password",
        "anyArg"
})
public class m2m_uploadArgsType {

    //    @XmlElement(nm = "FileType", required = true)
    @XmlElement(name = "FileType")
    protected String fileType;
    //    @XmlElement(nm = "URL", required = true)
    @XmlElement(name = "URL")
    @XmlSchemaType(name = "anyURI")
    protected String url;
    //    @XmlElement(nm = "Username", required = true)
    @XmlElement(name = "Username")
    protected String username;
    //    @XmlElement(nm = "Password", required = true)
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "AnyArg")
    protected m2m_anyArgsListType anyArg;
}
