package com.red.springdemo.dubb2;

import com.sun.jmx.snmp.ServiceName;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理，需要注意的是，这里用到的是JDK自带的动态代理，代理对象只能是接口，不能是类
 * @author lichuang
 */
 
public class ServiceProxy implements InvocationHandler {
 

    private String serviceName;
 
    public ServiceProxy( String serviceName) {
        this.serviceName = serviceName;
    }
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this,args);
        }
        System.out.println(serviceName);
        System.out.println("调用前，参数：{}" + args[0]);
        //这里可以得到参数数组和方法等，可以通过反射，注解等，进行结果集的处理
        //mybatis就是在这里获取参数和相关注解，然后根据返回值类型，进行结果集的转换
        Object result = args[0].toString();
        System.out.println("调用后，结果：{}" + result);
        return result;
    }
}
