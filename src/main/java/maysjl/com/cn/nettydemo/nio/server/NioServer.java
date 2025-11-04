package maysjl.com.cn.nettydemo.nio.server;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;

/**
 * @program: netty-demo
 * @description: 服务端
 * @author: May's_JL
 * @create: 2025-11-04 10:42
 **/
public class NioServer {
    private Selector selector;
    private ServerSocketChannel socketChannel;

    public static void main(String[] args) {
        new NioServer().bind(7397);
    }

    public void bind(int port){
        try{
            selector = Selector.open();
            socketChannel = ServerSocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.socket().bind(new InetSocketAddress(port), 1024);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("maysjl.com.cn server start done");
            new NioServerHandler (selector, Charset.forName("GBK")).start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
