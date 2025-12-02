package maysjl.com.cn.springdemo.factory.config;

import maysjl.com.cn.springdemo.PropertyValues;

/**
 * @program: netty-demo
 * @description: 用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
 * @author: May's_JL
 * @create: 2025-11-12 11:30
 **/
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues){
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class beanClass){
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues(){
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues){
        this.propertyValues = propertyValues;
    }
}
