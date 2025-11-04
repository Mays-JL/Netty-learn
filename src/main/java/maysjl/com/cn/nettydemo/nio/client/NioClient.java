package maysjl.com.cn.nettydemo.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @program: netty-demo
 * @description: 客户端
 * @author: May's_JL
 * @create: 2025-11-03 19:59
 **/
public class NioClient {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        boolean isConnect = socketChannel.connect(new InetSocketAddress("192.168.1.116",7397));
        if (isConnect){
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }
        System.out.println("maysjl.com.cn client done.");
        new NioClientHandler(selector, Charset.forName("GBK")).start();
    }
}
