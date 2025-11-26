package maysjl.com.cn.springdemo;


import maysjl.com.cn.springdemo.bean.UserService;
import maysjl.com.cn.springdemo.factory.BeanFactory;
import maysjl.com.cn.springdemo.factory.config.BeanDefinition;
import maysjl.com.cn.springdemo.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-12 11:34
 **/
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
    }
}
