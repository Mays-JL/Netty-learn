package maysjl.com.cn.nettydemo.aio;

import maysjl.com.cn.nettydemo.aio.service.AioServer;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-03 15:27
 **/
public  abstract class ChannelInitializer implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    @Override
    public void completed(AsynchronousSocketChannel channel, AioServer attachment) {
        try {
            initChannel(channel);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            attachment.serverSocketChannel().accept(attachment, this);// 再此接收客户端连接
        }
    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.getStackTrace();
    }

    protected abstract void initChannel(AsynchronousSocketChannel channel) throws Exception;

}

