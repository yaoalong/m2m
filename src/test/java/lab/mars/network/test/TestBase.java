package lab.mars.network.test;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import lab.mars.m2m.protocol.primitive.m2m_primitiveContentType;
import lab.mars.m2m.protocol.primitive.m2m_req;
import lab.mars.m2m.protocol.primitive.m2m_rsp;
import lab.mars.m2m.protocol.resource.m2m_AE;
import lab.mars.network.NetworkEvent;
import lab.mars.network.client.HttpClient;
import lab.mars.network.http.M2MHttpBindings;
import lab.mars.network.http.MissingContentBodyException;
import lab.mars.network.http.MissingParameterException;
import org.junit.Before;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class TestBase {
    protected HttpClient client;
    protected ThreadLocal<Marshaller> marshaller;
    protected ThreadLocal<Unmarshaller> unmarshaller;
    String path = "/cse/ae1";
    JAXBContext jc = null;

    @Before
    public void setUp() {
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
        client = new HttpClient();
    }


    protected void testCreate(String path, String value, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.POST, path, statusCode, null, value);
    }

    protected void testDelete(String path, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.DELETE, path, statusCode, null, null);
    }

    protected String testRetrieve(String path, HttpResponseStatus statusCode) throws Exception {
        m2m_rsp m_rsp = testRequest(HttpMethod.GET, path, statusCode, null, null);
        if (m_rsp.pc != null && m_rsp.pc.value instanceof m2m_AE)
            return ((m2m_AE) m_rsp.pc.value).api;
        return null;
    }

    protected void testUpdate(String path, String value, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.PUT, path, statusCode, null, value);
    }

    public m2m_rsp testRequest(HttpMethod method, String path, HttpResponseStatus statusCode, String contentPath, String requestBody) throws Exception {

        String[][] req_headers = new String[][]{
                {"Host", "/cse01"},
                {"Accept", "application/onem2m-resource+xml"},
                {"Content-type", "application/onem2m-resource+xml"},
                {"From", "/AE01"},
                {"X-M2M-RI", "00002"},
        };
        //   String requestBody = contentPath != null ? IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource(contentPath)) : null;
        String[][] rsp_headers = new String[][]{
//				{"X-M2M-RI", "00001"},
        };

        return testRequest(method, path, req_headers, requestBody, statusCode, rsp_headers);
    }

    protected m2m_rsp testRequest(
            HttpMethod method,
            String path,
            String[][] req_headers,
            String requestBody,
            HttpResponseStatus status,
            String[][] rsp_headers) throws InterruptedException, IOException, URISyntaxException {

        CountDownLatch latchNami = new CountDownLatch(1);
        URI uri = new URI("http://localhost:8080");
        HttpRequest httpRequest = HttpClient.makeRequest(method, path, req_headers, requestBody);
        m2m_rsp m_rsp[] = new m2m_rsp[1];
        client.requestAsync(uri, httpRequest)
                .<NetworkEvent<FullHttpResponse>>then(resp -> {
                    try {
                        m_rsp[0] = M2MHttpBindings.decodeResponse(resp.msg);
                    } catch (JAXBException | MissingParameterException | MissingContentBodyException e) {
                        e.printStackTrace();
                    }
                    latchNami.countDown();
                });

        latchNami.await();
        return m_rsp[0];
    }

}
