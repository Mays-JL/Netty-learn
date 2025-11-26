package cn.bugstack.gateway.session;

import cn.bugstack.gateway.session.defaults.GenericReferenceSessionFactory;
import io.netty.channel.Channel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: netty-demo
 * @description: 会话工厂建造类
 * @author: May's_JL
 * @create: 2025-11-26 10:07
 **/
public class GenericReferenceSessionFactoryBuilder {

    public Future<Channel> build(Configuration configuration){
        IGenericReferenceSessionFactory genericReferenceSessionFactory  = new GenericReferenceSessionFactory(configuration);
        try{
            return genericReferenceSessionFactory.openSession();
        }catch (ExecutionException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
