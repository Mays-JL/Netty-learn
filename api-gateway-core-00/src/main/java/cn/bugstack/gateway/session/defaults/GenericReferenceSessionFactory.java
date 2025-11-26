package cn.bugstack.gateway.session.defaults;

import cn.bugstack.gateway.session.Configuration;
import cn.bugstack.gateway.session.IGenericReferenceSessionFactory;
import cn.bugstack.gateway.session.SessionServer;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: netty-demo
 * @description: 泛化调用会话工厂
 * @author: May's_JL
 * @create: 2025-11-26 10:05
 **/
public class GenericReferenceSessionFactory implements IGenericReferenceSessionFactory {

    private final Logger logger = LoggerFactory.getLogger(GenericReferenceSessionFactory.class);

    private final Configuration configuration;

    public GenericReferenceSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public Future<Channel> openSession() throws ExecutionException, InterruptedException {
        SessionServer server = new SessionServer(configuration);

        Future<Channel> future = Executors.newFixedThreadPool(2).submit(server);
        Channel channel = future.get();

        if (null == channel) throw new RuntimeException("netty server start error channel is null");

        while (!channel.isActive()){
            logger.info("netty server gateway start Ing ...");
            Thread.sleep(500);
        }
        logger.info("netty server gateway start Done! {} ",channel.localAddress());

        return future;
    }
}
