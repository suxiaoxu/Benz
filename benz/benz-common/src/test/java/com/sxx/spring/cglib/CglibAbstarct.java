package com.sxx.spring.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


public abstract class CglibAbstarct implements MethodInterceptor{
	
	

	@SuppressWarnings("unchecked")  
    public <T> T proxyTarget(T t) {  
        Enhancer en = new Enhancer();  
        en.setSuperclass(t.getClass());  
        en.setCallback((Callback) getCglibAbstarct());  
        T tt = (T) en.create();  
        return tt;  
    }  
	
	public abstract Object getCglibAbstarct();

}
