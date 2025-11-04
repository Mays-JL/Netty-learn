package maysjl.com.cn.nettydemo.hiNetty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;


/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-04 11:13
 **/
public class MyChannelInitializer extends ChannelInitializer<io.netty.channel.socket.SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        System.out.println("链接报告开始");
        System.out.println("链接报告信息：有一客户端链接到本服务端");
        System.out.println("链接报告IP:" + channel.localAddress().getHostString());
        System.out.println("链接报告Port:" + channel.localAddress().getPort());
        System.out.println("链接报告完毕");
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }


}
