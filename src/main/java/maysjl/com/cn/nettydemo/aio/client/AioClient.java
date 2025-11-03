package maysjl.com.cn.nettydemo.aio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

/**
 * @program: netty-demo
 * @description: AIO 客户端
 * @author: May's_JL
 * @create: 2025-11-03 15:13
 **/
public class AioClient {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        Future<Void> future = socketChannel.connect(new InetSocketAddress("192.168.1.116",7397));
        System.out.println("maysjl.com.cn.nettydemo-netty学习实验");
        future.get();
        socketChannel.read(ByteBuffer.allocate(1024),null,new AioClientHandler(socketChannel, Charset.forName("GBK")));
        Thread.sleep(100000);
    }
}
