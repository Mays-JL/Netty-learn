package maysjl.com.cn.nettydemo.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import maysjl.com.cn.nettydemo.codec.ObjDecoder;
import maysjl.com.cn.nettydemo.codec.ObjEncoder;
import maysjl.com.cn.nettydemo.domain.MsgInfo;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 12:03
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }
}
