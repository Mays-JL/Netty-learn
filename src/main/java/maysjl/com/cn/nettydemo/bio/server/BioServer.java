package maysjl.com.cn.nettydemo.bio.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @program: netty-demo
 * @description: 服务端
 * @author: May's_JL
 * @create: 2025-11-03 16:37
 **/
public class BioServer extends Thread{
    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        bioServer.start();
    }

    @Override
    public void run(){
        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(7397));
            System.out.println("maysjl.com.cn.nettydemo-netty学习实验 | server start done！");
            while(true){
                Socket socket = serverSocket.accept();
                BioServerHandler handler = new BioServerHandler(socket, Charset.forName("GBK"));
                handler.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
