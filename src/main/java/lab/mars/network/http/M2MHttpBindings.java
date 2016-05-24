package lab.mars.network.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.*;
import lab.mars.m2m.model.*;
import lab.mars.m2m.protocol.enumeration.m2m_responseStatusCodeType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaders.Names.*;
import static io.netty.handler.codec.http.HttpMethod.*;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static lab.mars.m2m.model.m2m_operation.*;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class M2MHttpBindings {
    public static final String X_M2M_RI = "X-M2M-RI";
    public static final String X_M2M_OT = "X-M2M-OT";
    public static final String X_M2M_RST = "X-M2M-RST";
    public static final String X_M2M_ECT = "X-M2M-ECT";
    public static final String X_M2M_ECN = "X-M2M-ECN";
    public static final String X_M2M_RSC = "X-M2M-RSC";
    public static final String APPLICATION_ONEM2M_RESOURCE_XML = "application/onem2m-resource+xml";
    private static final JAXBContext jc;
    private static final ThreadLocal<Unmarshaller> unmarshaller = new ThreadLocal<Unmarshaller>() {
        @Override
        public Unmarshaller get() {
            try {
                return jc.createUnmarshaller();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    private static final ThreadLocal<Marshaller> marshaller = new ThreadLocal<Marshaller>() {
        @Override
        public Marshaller get() {
            try {
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                return marshaller;
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    static {
        JAXBContext _jc = null;
        try {
            _jc = JAXBContext.newInstance(m2m_primitiveContentType.class, m2m_req.class, m2m_rsp.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        jc = _jc;
    }

    public static FullHttpResponse encodeResponse(m2m_rsp resp) {

        HttpResponseStatus status = mapped(resp.rsc);

        ByteBufOutputStream out = new ByteBufOutputStream(Unpooled.buffer());
        if (resp.pc != null) {
            try {
                marshaller.get().marshal(resp.pc, out);//using proved xml serialization to_servAddr test json serialization.
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, status, out.buffer());
        response.headers().set(CONTENT_TYPE, APPLICATION_ONEM2M_RESOURCE_XML);
        if (resp.pc != null && resp.pc.value instanceof m2m_childResourceRef) {
            response.headers().set(LOCATION, ((m2m_childResourceRef) resp.pc.value).v);
        }
        response.headers().set(X_M2M_RI, resp.rqi.value);
        response.headers().set(X_M2M_RSC, Integer.toString(m2m_responseStatusCodeType.encode(resp.rsc)));

        return response;
    }

    private static HttpResponseStatus mapped(m2m_responseStatusCodeType responseStatusCode) {
        switch (responseStatusCode) {
            case Success:
                return OK;
            case Accepted:
                return ACCEPTED;
            case Location_info_not_authorized:
            case Create_error_no_privilege:
            case Create_error_already_exists:
            case Retrieve_error_no_privilege:
            case Update_error_no_privilege:
            case Delete_error_no_privilege:
            case Create_delivery_not_able_to_take_on_responsibility:
            case Create_mgmtObj_memory_shortage:
            case Cancel_execInstance_not_cancellable:
            case Cancel_execInstance_already_complete:
            case Delete_execInstance_not_cancellable:
            case Delete_execInstance_already_complete:
            case CMDH_rules_non_compliant:
            case Target_is_not_subscribable:
            case Cannot_initiate_subscription_verification:
            case Subscription_verification_failed:
                return FORBIDDEN;
            case Unsupported_resource:
            case Unsupported_attribute:
            case Cannot_forward_target_not_reachable:
            case Cannot_forward_other_reason_TBD:
            case Retrieve_error_does_not_exist:
            case Update_error_does_not_exist:
            case Delete_error_does_not_exist:
            case External_object_not_found:
                return NOT_FOUND;
            case Create_error_missing_mandatory_parameter:
            case Retrieve_CSEBase_format_error:
                return BAD_REQUEST;
            case Update_error_unacceptable_contents:
                return UNSUPPORTED_MEDIA_TYPE;
            case Create_fanoutpoint_group_request_identifier_exists:
            case Retrieve_fanoutpoint_group_request_identifier_exists:
            case Update_fanoutpoint_group_request_identifier_exists:
            case Delete_fanoutpoint_group_request_identifier_exists:
                return CONFLICT;
        }
        return BAD_REQUEST;
    }

    /**
     * decodeRequest HttpServerRequest into m2m_req
     */
    public static m2m_req decodeRequest(FullHttpRequest request) throws JAXBException, MissingParameterException, MissingContentBodyException {
        m2m_req req = new m2m_req();
        req.op = op(request.getMethod());
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());
        Map<String, List<String>> params = queryStringDecoder.parameters();
        req.to = queryStringDecoder.path();
        req.nm = returnFirstOrNull(params.get("nm"));
        String ty = returnFirstOrNull(params.get("ty"));
        if (ty == null && req.op == Create)
            throw new MissingParameterException("create operation needs ty param");
        req.ty = (ty == null ? null : Integer.parseInt(ty));
        String rset = returnFirstOrNull(params.get("rset"));
        req.rset = (rset == null ? null : dateTime(rset));
        String oet = returnFirstOrNull(params.get("oet"));
        req.oet = (oet == null ? null : dateTime(oet));
        String rt = returnFirstOrNull(params.get("rt"));
        req.rt = (rt == null ? null : m2m_responseType.parse(rt));
        String rp = returnFirstOrNull(params.get("rp"));
        req.rp = (rp == null ? null : Duration.parse(rp));
        String rc = returnFirstOrNull(params.get("rc"));
        req.rcn = (rc == null ? null : m2m_resultContent.parse(rc));
        String da = returnFirstOrNull(params.get("da"));
        req.da = (da == null ? null : new m2m_ID(da));
        req.gid = returnFirstOrNull(params.get("gid"));
        String fc = returnFirstOrNull(params.get("fc"));//TODO process it.
        String drt = returnFirstOrNull(params.get("drt"));
        req.drt = (drt == null ? null : m2m_discResType.parse(drt));

        HttpHeaders headers = request.headers();
        CharSequence host = headers.get(HOST);
        CharSequence Accept = headers.get(ACCEPT);
        CharSequence Content_type = request.headers().get(CONTENT_TYPE);
        CharSequence Content_Location = request.headers().get(CONTENT_LOCATION);
        CharSequence Content_Length = request.headers().get(CONTENT_LENGTH);
        CharSequence Etag = request.headers().get(ETAG);
        CharSequence From = request.headers().get(FROM);
        req.fr = (From == null ? null : new m2m_ID(From.toString()));
        CharSequence Location = request.headers().get(LOCATION);
        CharSequence X_M2M_RI = request.headers().get(M2MHttpBindings.X_M2M_RI);
        if (X_M2M_RI == null)
            throw new MissingParameterException("missing X-M2M-RI header");
        req.rqi = new m2m_ID(X_M2M_RI.toString());
        CharSequence X_M2M_OT = request.headers().get(M2MHttpBindings.X_M2M_OT);
        CharSequence X_M2M_RST = request.headers().get(M2MHttpBindings.X_M2M_RST);
        CharSequence X_M2M_ECT = request.headers().get(M2MHttpBindings.X_M2M_ECT);
        CharSequence X_M2M_ECN = request.headers().get(M2MHttpBindings.X_M2M_ECN);
        CharSequence X_M2M_RSC = request.headers().get(M2MHttpBindings.X_M2M_RSC);

        ByteBuf data = request.content();
        if (data.isReadable()) {
            req.pc = (m2m_primitiveContentType) unmarshaller.get().unmarshal(new ByteBufInputStream(data));
        } else if (req.op == Create || req.op == Update) {
            throw new MissingContentBodyException("Create/Update operation needs pc body!");
        }

        return req;
    }

    private static String returnFirstOrNull(List<String> list) {
        if (list == null || list.isEmpty()) return null;
        return list.listIterator().next();
    }

    private static Date dateTime(String v) {
        try {
            return Date.from(LocalDateTime.parse(v, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toInstant(ZoneOffset.UTC));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static m2m_operation op(HttpMethod method) {
        return method.equals(POST) ? Create :
                method.equals(GET) ? Retrieve :
                        method.equals(PUT) ? Update :
                                method.equals(DELETE) ? Delete : null;
    }

}
