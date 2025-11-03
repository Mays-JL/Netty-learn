package maysjl.com.cn.nettydemo.aio.service;

import maysjl.com.cn.nettydemo.aio.ChannelAdaptor;
import maysjl.com.cn.nettydemo.aio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @program: netty-demo
 * @description: 处理消息
 * @author: May's_JL
 * @create: 2025-11-03 16:03
 **/
public class AioServerHandler extends ChannelAdaptor {
    public AioServerHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try{
            System.out.println("maysjl.com.cn.nettydemo-netty学习实验 | 链接报告信息:"+ ctx.channel().getRemoteAddress());
            //通知客户端链接建立成功
            ctx.writeAndFlush("maysjl.com.cn.nettydemo-netty学习实验 | 通知服务端链接建立成功:"+ " "+ new Date() +
                    " "+ ctx.channel().getRemoteAddress()+"\r\n");
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
        ctx.writeAndFlush("服务端信息处理Success!\r\n");
    }
}
