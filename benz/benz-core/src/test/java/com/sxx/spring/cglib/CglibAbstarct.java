package com.sxx.spring.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public abstract class CglibAbstarct implements MethodInterceptor{
	
private Object CglibStudyN;
	
	private CglibAbstarct(Object o) {  
        this.CglibStudyN = o;  
    }  

	@SuppressWarnings("unchecked")  
    public static <T> T proxyTarget(T t) {  
        Enhancer en = new Enhancer();  
        en.setSuperclass(t.getClass());  
        en.setCallback((Callback) getCglibAbstarct());  
        T tt = (T) en.create();  
        return tt;  
    }  
	
	public static Object getCglibAbstarct(){
		
		return null;
	}
	

}
