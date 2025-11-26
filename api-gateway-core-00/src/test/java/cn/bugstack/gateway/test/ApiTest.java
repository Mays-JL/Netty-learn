package cn.bugstack.gateway.test;


import cn.bugstack.gateway.session.Configuration;
import cn.bugstack.gateway.session.GenericReferenceSessionFactoryBuilder;
import cn.bugstack.gateway.session.SessionServer;
import io.netty.channel.Channel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Configuration configuration  = new Configuration();
        configuration.addGenericReference("api-gateway-test",
                "cn.bugstack.gateway.rpc.IActivityBooth","sayHi");

        GenericReferenceSessionFactoryBuilder builder = new GenericReferenceSessionFactoryBuilder();
        Future<Channel> future = builder.build(configuration);

        logger.info("服务启动完成 {}", future.get().id());

        Thread.sleep(Long.MAX_VALUE);
    }

}
