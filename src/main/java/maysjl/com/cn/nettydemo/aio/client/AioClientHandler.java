package maysjl.com.cn.nettydemo.aio.client;

import maysjl.com.cn.nettydemo.aio.ChannelAdaptor;
import maysjl.com.cn.nettydemo.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @program: netty-demo
 * @description: AIO 客户端消息处理器
 * @author: May's_JL
 * @create: 2025-11-03 15:20
 **/
public class AioClientHandler extends ChannelAdaptor {

    public AioClientHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try{
            System.out.println("maysjl.com.cn.nettydemo-netty学习实验 | 链接报告信息:"+ ctx.channel().getRemoteAddress());
            // 通知客户端链接建立成功
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void channelInactive(ChannelHandler ctx) {
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("maysjl.com.cn.nettydemo-netty学习实验 | 服务器端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("客户端信息处理success！\r\n");
    }

}
