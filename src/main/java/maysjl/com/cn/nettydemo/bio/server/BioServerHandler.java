package maysjl.com.cn.nettydemo.bio.server;

import maysjl.com.cn.nettydemo.bio.ChannelAdapter;
import maysjl.com.cn.nettydemo.bio.ChannelHandler;

import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: netty-demo
 * @description: 消息处理器
 * @author: May's_JL
 * @create: 2025-11-03 16:40
 **/
public class BioServerHandler extends ChannelAdapter {

    public BioServerHandler(Socket socket, Charset charset) {
        super(socket, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx){
        System.out.println("链接报告LocalAddress: "+ ctx.socket().getLocalAddress());
        ctx.writeAndFlush("hi, 我是maysjl.com.cn.nettydemo-netty学习实验 | BioServer to msg for you \r\n");
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg);
        ctx.writeAndFlush("hi 我已经收到了你的消息Success! \r\n");
    }
}
