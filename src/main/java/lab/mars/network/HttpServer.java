package lab.mars.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lab.mars.onem2m.resource.Nami;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class HttpServer

{
    private Set<Channel> channels = new HashSet();

    public HttpServer() {
    }
    public void bindAsync(String host, int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(Network.bossGroup, Network.workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_BACKLOG, 1000)
                .handler(new ChannelInboundHandlerAdapter() {
                    @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        channels.add(ctx.channel());
                    }

                    @Override public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                        channels.remove(ctx.channel());
                    }
                })
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new HttpServerCodec())
                                .addLast(new HttpObjectAggregator(512 * 1024))
                                .addLast(new HttpContentCompressor())
                                .addLast(new SimpleChannelInboundHandler<FullHttpRequest>(false) {
                                    @Override protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
                                        Nami.send(new NetworkEvent<>(ctx, msg));
                                    }

                                    @Override
                                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                            super.exceptionCaught(ctx, cause);
                                    }
                                });
                    }
                });

        bootstrap.bind(host, port).addListener((ChannelFuture channelFuture) -> {
            channels.add(channelFuture.channel());

        });
    }


    public void close() {
        Iterator var1 = this.channels.iterator();

        while (var1.hasNext()) {
            Channel channel = (Channel) var1.next();
            if (channel != null) {
                channel.close();
            }
        }

    }
}
