package com.sxx.spring.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by xiaoxu.sxx on 2016/12/21.
 */
public class CallbackFilterOne implements CallbackFilter {
    public int accept(Method method) {
        if(method.getName().contains("test")){
            return 1;
        }
        return 0;
    }
}
