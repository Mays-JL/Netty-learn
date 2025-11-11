package maysjl.com.cn.nettydemo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 10:46
 **/
@Component("nettyServer")
public class NettyServer {

    private EventLoopGroup parentGroup = new NioEventLoopGroup();
    private EventLoopGroup childGroup = new NioEventLoopGroup();
    private Channel channel;
    public ChannelFuture bing(InetSocketAddress address){
        ChannelFuture channelFuture = null;
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new MyChannelInitializer());
            channelFuture = b.bind(address).syncUninterruptibly();
            this.channel = channelFuture.channel();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                System.out.println("maysjl server start done. ");
            } else {
                System.out.println("maysjl server start error. ");
            }
        }
        return channelFuture;
    }

    public void destroy() {
        if (null == channel) return;
        channel.close();
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public Channel getChannel() {
        return channel;
    }
}
