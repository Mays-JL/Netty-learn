package maysjl.com.cn.springdemo.factory.support;

import maysjl.com.cn.springdemo.factory.config.BeanDefinition;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-12 11:50
 **/
public interface BeanDefinitionRegistry {

    /**
     *
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
