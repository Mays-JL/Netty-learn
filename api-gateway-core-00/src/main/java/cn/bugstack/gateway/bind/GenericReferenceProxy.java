package cn.bugstack.gateway.bind;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.dubbo.rpc.service.GenericService;

import java.lang.reflect.Method;

/**
 * @program: netty-demo
 * @description: 泛化调用静态代理：方便做一些拦截处理。给http对应的RPC调用，做一层代理控制，每调用到一个http对应的网关方法，就会代理的方式调用到RPC对应的泛化调用方法上
 * @author: May's_JL
 * @create: 2025-11-25 10:40
 **/
public class GenericReferenceProxy implements MethodInterceptor {
    /**
     * RPC 泛化调用服务
     */
    private final GenericService genericService;
    /**
     * RPC 泛化调用方法
     */
    private final String methodName;


    public GenericReferenceProxy(GenericService genericService, String methodName) {
        this.genericService = genericService;
        this.methodName = methodName;
    }

    /**
     *做一层代理控制，后续不止是可以使用Dubbo泛化调用，也可以是其他服务的泛化调用
     * 泛化调用文档： <a href="https://dubbo.apache.org/zh/docsv2.7/user/examples/generic-reference/">...</a>
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String[] parameters = new String[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i ++){
            parameters[i] = parameterTypes[i].getName();
        }
        // 举例：genericService.$invoke("sayHi", new String[]{"java.lang.String"}, new Object[]{"world"});
        return genericService.$invoke(methodName,parameters, objects);
    }
}
