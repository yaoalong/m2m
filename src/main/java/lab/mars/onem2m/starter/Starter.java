package lab.mars.onem2m.starter;

import lab.mars.network.HttpServer;
import lab.mars.onem2m.resource.CSEBaseResource;
import lab.mars.onem2m.resource.Nami;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class Starter {
    private String oneM2MServer;

    public Starter(String oneM2MServer) {
        this.oneM2MServer = oneM2MServer;
    }

    public static void main(String args[]) {
        Starter starter = new Starter("192.168.10.131:2183,192.168.10.131:2184,192.168.10.131:2185");
        starter.start();
    }

    public void start() {
        Nami.resources.put("csebase", new CSEBaseResource(oneM2MServer));
        new HttpServer().bindAsync("localhost", 8088);
    }
}
