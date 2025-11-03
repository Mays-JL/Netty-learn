package maysjl.com.cn.nettydemo.bio.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @program: netty-demo
 * @description: 客户端
 * @author: May's_JL
 * @create: 2025-11-03 16:23
 **/
public class BioClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("192.168.1.116",7397);
            System.out.println("maysjl.com.cn.nettydemo-netty学习实验 | client start done！");
            BioClientHandler bioClientHandler = new BioClientHandler(socket, Charset.forName("GBK"));
            bioClientHandler.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
