package cn.bugstack.gateway.session;

import io.netty.channel.Channel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: netty-demo
 * @description: 泛化调用会话工厂接口
 * @author: May's_JL
 * @create: 2025-11-26 10:08
 **/
public interface IGenericReferenceSessionFactory {

    Future<Channel> openSession() throws ExecutionException, InterruptedException;
}
