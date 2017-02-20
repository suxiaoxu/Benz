package com.sxx.spring.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by xiaoxu.sxx on 2016/12/21.
 */
public class CglibInterceptorTwo implements MethodInterceptor {

    private Object one;

    public void setOne(Object one) {
        this.one = one;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("456");
        Object o = method.invoke(one, args);
        System.out.println("456");
        return o;
    }
}
