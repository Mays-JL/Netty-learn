package maysjl.com.cn.springdemo.factory;

import maysjl.com.cn.springdemo.BeansException;
import maysjl.com.cn.springdemo.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: netty-demo
 * @description: BeanFactory，代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取
 * @author: May's_JL
 * @create: 2025-11-12 11:30
 **/
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
