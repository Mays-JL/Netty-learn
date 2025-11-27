package maysjl.com.cn.springdemo.factory.support;

import maysjl.com.cn.springdemo.BeansException;
import maysjl.com.cn.springdemo.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @program: netty-demo
 * @description: Bean 实例化策略
 * @author: May's_JL
 * @create: 2025-11-27 10:09
 **/
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
