package maysjl.com.cn.springdemo.factory.config;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-12 11:50
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
