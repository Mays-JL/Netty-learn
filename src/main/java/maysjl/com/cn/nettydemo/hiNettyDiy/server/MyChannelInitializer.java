package maysjl.com.cn.nettydemo.hiNettyDiy.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import maysjl.com.cn.nettydemo.hiNettyDiy.codec.MyDecoder;
import maysjl.com.cn.nettydemo.hiNettyDiy.codec.MyEncoder;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-04 16:34
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel){
        //自定义解码器
        channel.pipeline().addLast(new MyDecoder());
        //自定义编码器
        channel.pipeline().addLast(new MyEncoder());
        //在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }
}
