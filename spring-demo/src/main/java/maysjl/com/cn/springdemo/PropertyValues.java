package maysjl.com.cn.springdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-12-02 10:13
 **/
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : this.propertyValueList){
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }
}
