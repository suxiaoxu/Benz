package com.sxx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

class ProxyExample implements InvocationHandler{
	
	private Object object;
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before");
		Object result = method.invoke(object, args);
		System.out.println("after");
		return result;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
interface TnnIn{
	public void print();
}

class Tnn implements TnnIn{
	public void print(){
		System.out.println("this is my book");
	}
}

public class TnLLProxy{
	@Test
	public void main(){
		ProxyExample proxy = new ProxyExample();
		TnnIn tn = new Tnn();
		proxy.setObject(tn);
		TnnIn tnnProxy = (TnnIn)Proxy.newProxyInstance(tn.getClass().getClassLoader(), tn.getClass().getInterfaces(), proxy);
		tnnProxy.print();
	}
}
