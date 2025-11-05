package maysjl.com.cn.nettydemo.hiUdp.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-05 19:07
 **/
public class MyServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String msg = packet.content().toString(Charset.forName("GBK"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "UDP服务端接收到消息：" + msg);

        //向客户端回复消息
        String json = "这里是UDP服务端 我已经收到你的消息\r\n";
        //由于数据报的数据是以字符数组串的形式存储的，所以传转数据
        byte[] bytes = json.getBytes(Charset.forName("GBK"));
        DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes),packet.sender());
        ctx.writeAndFlush(data);
    }
}
