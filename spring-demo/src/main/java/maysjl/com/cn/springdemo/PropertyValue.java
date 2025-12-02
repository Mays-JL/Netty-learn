package maysjl.com.cn.springdemo;

/**
 * @program: netty-demo
 * @description: bean 属性信息
 * @author: May's_JL
 * @create: 2025-12-02 10:13
 **/
public class PropertyValue {

    private final String name;

    private final Object value;


    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public Object getValue(){
        return value;
    }

}
