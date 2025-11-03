package maysjl.com.cn.nettydemo.aio.service;

import maysjl.com.cn.nettydemo.aio.ChannelInitializer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @program: netty-demo
 * @description: 初始化
 * @author: May's_JL
 * @create: 2025-11-03 15:39
 **/
public class AioServerChannelInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(AsynchronousSocketChannel channel) throws Exception {
        channel.read(ByteBuffer.allocate(1024), 10, TimeUnit.SECONDS, null, new AioServerHandler(channel, Charset.forName("GBK")));
    }
}
