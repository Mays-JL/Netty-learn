package maysjl.com.cn.nettydemo.hiUdp.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-05 19:07
 **/
public class MyClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    //接收服务端发送的内容
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String msg = packet.content().toString(Charset.forName("GBK"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 客户端接收到消息：" + msg);
    }
}
