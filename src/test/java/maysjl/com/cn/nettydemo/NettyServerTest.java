package maysjl.com.cn.nettydemo;

import maysjl.com.cn.nettydemo.server.NettyServer;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-10 20:22
 **/
public class NettyServerTest {
    public static void main(String[] args) {
        System.out.println("hi this is maysjl");
        //启动服务
        new NettyServer().bing(7397);
    }
}
