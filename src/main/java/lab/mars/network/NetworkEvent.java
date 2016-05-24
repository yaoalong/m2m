package lab.mars.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class NetworkEvent<T> implements Cleanable
{   public final ChannelHandlerContext ctx;
    public final T msg;

    public NetworkEvent(ChannelHandlerContext ctx, T msg) {
        this.ctx = ctx;
        this.msg = msg;
    }
    @Override
    public void clean() {
        ReferenceCountUtil.release(this.msg);
    }
}
