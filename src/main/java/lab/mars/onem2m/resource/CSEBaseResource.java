package lab.mars.onem2m.resource;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import lab.mars.ds.reflection.ResourceReflection;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.common.m2m_childResourceRef;
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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

import static lab.mars.network.http.M2MHttpBindings.encodeResponse;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class CSEBaseResource implements M2mResource {
    OneM2MClient oneM2MClient;

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
    private ThreadLocal<Marshaller> marshaller;
    private ThreadLocal<Unmarshaller> unmarshaller;
    JAXBContext jc = null;
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
        m2m_ID m2m_id = req.rqi;
        String id = m2m_id.value;
        Object value;
        byte[] result;
        m2m_rsp m2m_rsp = new m2m_rsp();
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
                byte[] dataResult= oneM2MClient.getData(id);

                m2m_rsp.pc=new m2m_primitiveContentType();

                m2m_rsp.pc.value=ResourceReflection.deserializeKryo(dataResult);
                break;
            case Update:
                value = req.pc.value;
                result = ResourceReflection.serializeKryo(value);
                oneM2MClient.setData(id, result);
                break;
            case Delete:
                oneM2MClient.delete(id);
                break;
        }
        System.out.println("接收");
        m2m_rsp.rsc = m2m_responseStatusCodeType.Success;
        m2m_rsp.rqi = m2m_id;
        FullHttpResponse response = encodeResponse(m2m_rsp);
        m.ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        System.out.println("发送");
    }
}
