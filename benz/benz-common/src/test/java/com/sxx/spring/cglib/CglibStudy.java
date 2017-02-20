package com.sxx.spring.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibStudy implements MethodInterceptor{
	
	private Object CglibStudyN;
	
	private CglibStudy(Object o) {  
        this.CglibStudyN = o;  
    }  

	@SuppressWarnings("unchecked")  
    public static <T> T proxyTarget(T t) {  
        Enhancer en = new Enhancer();  
        en.setSuperclass(t.getClass());  
        en.setCallback(new CglibStudy(t));  
        T tt = (T) en.create();  
        return tt;  
    }  
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = CglibStudy.proxyTarget(new Person());
		person.testLn(1,2);

	}*/

	public static void main(String[] args){

	}

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("234");
		Object o = method.invoke(CglibStudyN, args);
		System.out.println("543");
		return o;
	}

}
class Person{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	public void test(){
		System.out.println("today is now");
	}
	
	public int testLn(int a,int b){
		return a+b;
	}
	
}
