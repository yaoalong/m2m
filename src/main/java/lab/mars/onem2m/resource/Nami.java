package lab.mars.onem2m.resource;

import io.netty.handler.codec.http.FullHttpRequest;
import lab.mars.network.NetworkEvent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class Nami {

    public static ConcurrentHashMap<String, M2mResource> resources = new ConcurrentHashMap<>();

    public static  void send(NetworkEvent<FullHttpRequest> m) {
        resources.get("csebase").processRequest(m);
    }
}
