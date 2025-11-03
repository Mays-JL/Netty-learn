package maysjl.com.cn.nettydemo.aio.service;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * @program: netty-demo
 * @description: 服务端
 * @author: May's_JL
 * @create: 2025-11-03 15:35
 **/
public class AioServer extends  Thread{
    private AsynchronousServerSocketChannel serverSocketChannel;

    @Override
    public void run(){
        try{
            serverSocketChannel = AsynchronousServerSocketChannel.open(AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(),10));
            serverSocketChannel.bind(new InetSocketAddress(7397));
            System.out.println("maysjl.com.cn.nettydemo-netty学习实验 | server start done！");
            //等待
            CountDownLatch latch = new CountDownLatch(1);
            serverSocketChannel.accept(this,new AioServerChannelInitializer());
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public AsynchronousServerSocketChannel serverSocketChannel(){
        return serverSocketChannel;
    }

    public static void main(String[] args) {
        new AioServer().start();
    }
}
