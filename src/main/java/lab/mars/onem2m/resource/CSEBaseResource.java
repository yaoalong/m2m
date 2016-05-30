package lab.mars.onem2m.resource;

import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import lab.mars.ds.reflection.ResourceReflection;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.enumeration.m2m_operation;
import lab.mars.m2m.protocol.enumeration.m2m_responseStatusCodeType;
import lab.mars.m2m.protocol.primitive.m2m_primitiveContentType;
import lab.mars.m2m.protocol.primitive.m2m_req;
import lab.mars.m2m.protocol.primitive.m2m_rsp;
import lab.mars.network.NetworkEvent;
import lab.mars.network.http.M2MHttpBindings;
import lab.mars.network.http.MissingContentBodyException;
import lab.mars.network.http.MissingParameterException;
import lab.mars.onem2m.client.OneM2MClient;
import org.lab.mars.onem2m.M2mKeeperException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

import static lab.mars.network.http.M2MHttpBindings.encodeResponse;
import static org.lab.mars.onem2m.M2mKeeperException.Code.*;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class CSEBaseResource implements M2mResource {
    OneM2MClient oneM2MClient;
    JAXBContext jc = null;
    private ThreadLocal<Marshaller> marshaller;
    private ThreadLocal<Unmarshaller> unmarshaller;

    public CSEBaseResource(String client) {
        oneM2MClient = new OneM2MClient(client);
        marshaller = new ThreadLocal<Marshaller>() {
            @Override
            public Marshaller initialValue() {
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
        unmarshaller = new ThreadLocal<Unmarshaller>() {
            @Override
            public Unmarshaller initialValue() {
                try {
                    return jc.createUnmarshaller();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        try {
            jc = JAXBContext.newInstance(m2m_primitiveContentType.class, m2m_req.class, m2m_rsp.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processRequest(NetworkEvent<FullHttpRequest> m) {
        m2m_req req = null;
        //TODO 进行错误处理
        try {
            req = M2MHttpBindings.decodeRequest(m.msg);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MissingParameterException e) {
            e.printStackTrace();
        } catch (MissingContentBodyException e) {
            e.printStackTrace();
        }
        m2m_operation op = req.op;
        m2m_ID m2m_id = req.fr;
        String id = req.to;
        System.out.println("id" + id);
        Object value;
        byte[] result;
        m2m_rsp m2m_rsp = new m2m_rsp();
        m2m_responseStatusCodeType responseStatusCodeType = m2m_responseStatusCodeType.Success;
        try {
            switch (op) {
                case Create:
                    value = req.pc.value;
                    result = ResourceReflection.serializeKryo(value);
                    try {
                        oneM2MClient.create(id, result);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case Retrieve:
                    byte[] dataResult = oneM2MClient.getData(id);
                    m2m_rsp.pc = new m2m_primitiveContentType();
                    m2m_rsp.pc.value = ResourceReflection.deserializeKryo(dataResult);
                    break;
                case Update:
                    value = req.pc.value;
                    result = ResourceReflection.serializeKryo(value);
                    System.out.println("data:" + result.length);
                    oneM2MClient.setData(id, result);
                    System.out.println("result:" + id);
                    break;
                case Delete:
                    oneM2MClient.delete(id);
                    break;
            }
        } catch (M2mKeeperException e) {
            if (e.getCode() == NODEEXISTS.getCode()) {
                responseStatusCodeType = m2m_responseStatusCodeType.Create_error_already_exists;
            } else if (e.getCode() == NONODE.getCode()) {
                responseStatusCodeType = m2m_responseStatusCodeType.External_object_not_found;
            } else if (e.getCode() == PARAM_ERROR.getCode()) {
                responseStatusCodeType = m2m_responseStatusCodeType.Create_error_missing_mandatory_parameter;
            }

        }
        m2m_rsp.rsc = responseStatusCodeType;
        m2m_rsp.rqi = m2m_id;
        FullHttpResponse response = encodeResponse(m2m_rsp);
        m.ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
