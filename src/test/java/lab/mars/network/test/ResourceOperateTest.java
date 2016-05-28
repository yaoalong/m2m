package lab.mars.network.test;

import lab.mars.m2m.protocol.primitive.m2m_primitiveContentType;
import lab.mars.m2m.protocol.resource.m2m_AE;
import org.junit.Test;

import java.io.StringWriter;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * Author:yaoalong.
 * Date:2016/5/28.
 * Email:yaoalong@foxmail.com
 */
public class ResourceOperateTest extends TestBase {

    @Test
    public void createAE() throws Exception {

        m2m_primitiveContentType m2m_primitiveContentType = new m2m_primitiveContentType();
        StringWriter sw = new StringWriter();

        m2m_AE rsp = new m2m_AE();
        rsp.api = "sss";
        m2m_primitiveContentType.value = rsp;

        marshaller.get().marshal(m2m_primitiveContentType, sw);
        String value = sw.toString();
        testCreate(path, value, OK);//创建一个A
    }

    @Test
    public void testDeleteAE() throws Exception {
        testDelete("/cse/ae1", OK);
    }

    @Test
    public void testRetrieveAE() throws Exception {
        String ss = testRetrieve(path, OK);
        System.out.println("result:" + ss);
    }

    @Test
    public void testUpdateAE() throws Exception {
        m2m_primitiveContentType m2m_primitiveContentType = new m2m_primitiveContentType();
        StringWriter sw = new StringWriter();
        m2m_AE rsp = new m2m_AE();
        rsp.api = "fff";
        m2m_primitiveContentType.value = rsp;
        marshaller.get().marshal(m2m_primitiveContentType, sw);
        String value = sw.toString();
        testUpdate(path, value, OK);
    }
}
