package maysjl.com.cn.nettydemo.nio.client;


import maysjl.com.cn.nettydemo.nio.ChannelAdapter;
import maysjl.com.cn.nettydemo.nio.ChannelHandler;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: netty-demo
 * @description: 消息处理器
 * @author: May's_JL
 * @create: 2025-11-03 19:57
 **/
public class NioClientHandler extends ChannelAdapter {

    public NioClientHandler(Selector selector, Charset charset) {
        super(selector, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try{
            System.out.println("链接报告LocalAddress："+ctx.channel().getLocalAddress());
            ctx.writeAndFlush("hi 我是maysjl.com.cn BioClient to msg for you \r\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+" 接收到消息："+msg);
        ctx.writeAndFlush("hi 我已经收到你的消息Success \r\n");
    }

}
