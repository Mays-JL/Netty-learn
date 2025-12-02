package maysjl.com.cn.springdemo.factory.config;

/**
 * @program: netty-demo
 * @description: Bean 的引用
 * @author: May's_JL
 * @create: 2025-11-30 21:14
 **/
public class BeanReference {

    private final String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName(){
        return beanName;
    }
}
