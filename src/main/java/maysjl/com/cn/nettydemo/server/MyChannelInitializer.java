package maysjl.com.cn.nettydemo.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import maysjl.com.cn.nettydemo.codec.ObjDecoder;
import maysjl.com.cn.nettydemo.codec.ObjEncoder;
import maysjl.com.cn.nettydemo.domain.FileTransferProtocol;
import maysjl.com.cn.nettydemo.domain.MsgInfo;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 10:46
 **/
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 对象传输处理
        channel.pipeline().addLast(new ObjDecoder(FileTransferProtocol.class));
        channel.pipeline().addLast(new ObjEncoder(FileTransferProtocol.class));
        //在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler());
    }
}
