package maysjl.com.cn.springdemo.factory.support;

import maysjl.com.cn.springdemo.BeansException;
import maysjl.com.cn.springdemo.factory.BeanFactory;
import maysjl.com.cn.springdemo.factory.config.BeanDefinition;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-12 11:50
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null){
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
