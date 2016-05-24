package lab.mars.onem2m.resource;

import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import lab.mars.ds.reflection.ResourceReflection;
import lab.mars.m2m.protocol.common.m2m_ID;
import lab.mars.m2m.protocol.enumeration.m2m_operation;
import lab.mars.m2m.protocol.enumeration.m2m_responseStatusCodeType;
import lab.mars.m2m.protocol.primitive.m2m_req;
import lab.mars.m2m.protocol.primitive.m2m_rsp;
import lab.mars.network.NetworkEvent;
import lab.mars.network.http.M2MHttpBindings;
import lab.mars.network.http.MissingContentBodyException;
import lab.mars.network.http.MissingParameterException;
import lab.mars.onem2m.client.OneM2MClient;

import javax.xml.bind.JAXBException;
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
    }

    @Override
    public void processRequest(NetworkEvent<FullHttpRequest> m) {
        m2m_req req = null;
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
        Object value = null;
        byte[] result = null;
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
                oneM2MClient.getData(id);
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
        m2m_rsp m2m_rsp = new m2m_rsp();
        m2m_rsp.rsc = m2m_responseStatusCodeType.Success;
        m2m_rsp.rqi = m2m_id;
        FullHttpResponse response = encodeResponse(m2m_rsp);
        m.ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        System.out.println("发送");
    }
}
