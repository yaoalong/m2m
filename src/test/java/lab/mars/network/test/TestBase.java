package lab.mars.network.test;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import lab.mars.network.NetworkEvent;
import lab.mars.network.client.HttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class TestBase {
    protected HttpClient client;
    String path = "/cse/ae";

    @Before
    public void setUp() {
        client = new HttpClient();
    }

    @Test
    public void test() throws Exception {
        testDelete("dd", OK);
    }

    @Test
    public void testCreate() throws Exception {
        testCreate("/ae", "aa", OK);
    }

    @Test
    public void testRetrieve() throws Exception {
        testRetrieve("/ae", OK);
    }

    @Test
    public void testUpdate() throws Exception {
        testUpdate("path", "value", OK);
    }

    protected void testCreate(String path, String value, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.POST, path, statusCode, null, value);
    }

    protected void testDelete(String path, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.DELETE, path, statusCode, null, null);
    }

    protected void testRetrieve(String path, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.GET, path, statusCode, null, null);
    }

    protected void testUpdate(String path, String value, HttpResponseStatus statusCode) throws Exception {
        testRequest(HttpMethod.PUT, path, statusCode, null, value);
    }

    public void testRequest(HttpMethod method, String path, HttpResponseStatus statusCode, String contentPath, String requestBody) throws Exception {

        String[][] req_headers = new String[][]{
                {"Host", "/cse01"},
                {"Accept", "application/onem2m-resource+xml"},
                {"Content-type", "application/onem2m-resource+xml"},
                {"From", "/AE01"},
                {"X-M2M-RI", "00001"},
        };
        //   String requestBody = contentPath != null ? IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource(contentPath)) : null;
        String[][] rsp_headers = new String[][]{
//				{"X-M2M-RI", "00001"},
        };

        testRequest(method, path, req_headers, requestBody, statusCode, rsp_headers);
    }

    protected void testRequest(
            HttpMethod method,
            String path,
            String[][] req_headers,
            String requestBody,
            HttpResponseStatus status,
            String[][] rsp_headers) throws InterruptedException, IOException, URISyntaxException {

        CountDownLatch latchNami = new CountDownLatch(1);
        URI uri = new URI("http://localhost:8080");
        HttpRequest httpRequest = HttpClient.makeRequest(method, path, req_headers, requestBody);
        // m2m_rsp m_rsp[] = new m2m_rsp[1];
        client.requestAsync(uri, httpRequest)
                .<NetworkEvent<FullHttpResponse>>then(resp -> {
                    System.out.println(resp.toString());
//                    Assert.assertEquals(status, resp.msg.getStatus());
//                    if (rsp_headers != null)
//                        for (String[] header : rsp_headers)
//                            Assert.assertEquals(header[1], resp.msg.headers().get(header[0]));

                    latchNami.countDown();
                });

        latchNami.await();
    }

}
