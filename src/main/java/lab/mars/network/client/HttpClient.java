package lab.mars.network.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lab.mars.network.Network;
import lab.mars.network.NetworkEvent;
import lab.mars.util.async.AsyncStream;

import java.io.IOException;
import java.net.URI;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Author:yaoalong.
 * Date:2016/5/24.
 * Email:yaoalong@foxmail.com
 */
public class HttpClient
{
    public static HttpRequest makeRequest(HttpMethod method,
                                          String rawPath,
                                          String[][] req_headers,
                                          String requestBody) {
        ByteBufOutputStream out = new ByteBufOutputStream(Unpooled.buffer());
        if (requestBody != null)
            try {
                out.write(requestBody.getBytes(CharsetUtil.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, method, rawPath, out.buffer());
        if (req_headers != null)
            for (String[] head : req_headers)
                request.headers().set(head[0], head[1]);
//		request.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, Integer.toString(request.content().readableBytes()));
        return request;
    }

    public void connectAsync(String inetHost, int inetPort) {

        Bootstrap clientBootstrap = new Bootstrap();
        clientBootstrap.group(Network.workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new HttpClientCodec())
                                .addLast(new HttpContentDecompressor())
                                .addLast(new HttpObjectAggregator(1048576))
                                .addLast(new SimpleChannelInboundHandler<FullHttpResponse>(false) {
                                    @Override protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
                                     //   async.onEvent(new NetworkEvent<>(ctx, msg));
                                    }

                                    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                            super.exceptionCaught(ctx, cause);
                                    }
                                });
                    }
                });

        clientBootstrap.connect(inetHost, inetPort).addListener((m)->{
            System.out.println("连接成功");
        });
    }

    /**
     * if fail, put null into asyncStream.
     */
    public AsyncStream requestAsync(URI uri, HttpRequest request) {
        AsyncStream async = AsyncStream.deferredAsync();
        Bootstrap clientBootstrap = new Bootstrap();
        clientBootstrap.group(Network.workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new HttpClientCodec())
                                .addLast(new HttpContentDecompressor())
                                .addLast(new HttpObjectAggregator(1048576))
                                .addLast(new SimpleChannelInboundHandler<FullHttpResponse>(false) {
                                    @Override protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
                                       async.onEvent(new NetworkEvent<>(ctx, msg));
                                    }

                                    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                            super.exceptionCaught(ctx, cause);
                                    }
                                });
                    }
                });

        clientBootstrap.connect(uri.getHost(), uri.getPort())
                .addListener((ChannelFuture channelFuture) -> {
                    Channel ch = channelFuture.channel();
                    if (channelFuture.isSuccess()) {
                        ch.writeAndFlush(request);
                    }else
                        async.onEvent(null);
                });
        return async;

    }
}
