package maysjl.com.cn.springdemo;

/**
 * @program: netty-demo
 * @description: 定义Bean异常
 * @author: May's_JL
 * @create: 2025-11-12 11:50
 **/
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause){
        super(msg, cause);
    }
}
