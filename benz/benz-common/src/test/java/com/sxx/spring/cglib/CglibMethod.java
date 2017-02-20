package com.sxx.spring.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

public class CglibMethod extends CglibAbstarct {

	private Object CglibStudyN;
	
	Object CglibMethod(Object CglibStudyN) {  
        this.CglibStudyN = CglibStudyN;  
        return this.proxyTarget(CglibStudyN);
    }  
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("234");
		Object o = method.invoke(CglibStudyN, args);
		System.out.println("543");
		return o;
	}
	
	@Override
	public Object getCglibAbstarct() {
		return this;
	}
}
