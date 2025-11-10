package maysjl.com.cn.nettydemo;

import io.netty.channel.ChannelFuture;
import maysjl.com.cn.nettydemo.client.NettyClient;
import maysjl.com.cn.nettydemo.domain.FileTransferProtocol;
import maysjl.com.cn.nettydemo.util.MsgUtil;

import java.io.File;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-10 20:19
 **/
public class NettyClientTest {
    public static void main(String[] args) {
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1",7397);

        //文件信息{文件大于1024kb方便测试断点续传}
        File file = new File("D:\\JAVAPor\\netty-demo\\src\\test\\java\\maysjl\\com\\cn\\nettydemo\\测试传输文件.rar");
        FileTransferProtocol fileTransferProtocol = MsgUtil.buildRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());

        channelFuture.channel().writeAndFlush(fileTransferProtocol);
    }
}
