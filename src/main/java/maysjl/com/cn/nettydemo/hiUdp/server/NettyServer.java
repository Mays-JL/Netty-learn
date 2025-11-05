package maysjl.com.cn.nettydemo.hiUdp.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-05 19:07
 **/
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true) // 广播
                    .option(ChannelOption.SO_RCVBUF, 2048 * 1024) // 接收缓冲区大小为2M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024) // 设置UDP写缓冲区为1M
                    .handler(new MyChannelInitializer());

            ChannelFuture f = b.bind(7397).sync();
            System.out.println("maysjl.com.cn udp server start done.");
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }
}
