package maysjl.com.cn.springdemo.factory.support;

import maysjl.com.cn.springdemo.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-12 11:50
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> stringObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return stringObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject){
        stringObjects.put(beanName, singletonObject);
    }
}
