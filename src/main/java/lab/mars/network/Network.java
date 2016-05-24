package lab.mars.network;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class Network {
    public static final int NCPU = Runtime.getRuntime().availableProcessors();
    public static final EventLoopGroup bossGroup;
    public static final EventLoopGroup workerGroup;

    public Network() {
    }

    public static void shutdown() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    static {
        bossGroup = new NioEventLoopGroup(NCPU);
        workerGroup = new NioEventLoopGroup(NCPU);
    }
}
