package lab.mars.onem2m.resource;

import io.netty.handler.codec.http.FullHttpRequest;
import lab.mars.network.NetworkEvent;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public interface M2mResource
{

     void processRequest(NetworkEvent<FullHttpRequest> m);
}
