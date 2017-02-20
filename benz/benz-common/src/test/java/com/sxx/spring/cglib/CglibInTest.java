package com.sxx.spring.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Created by xiaoxu.sxx on 2016/12/21.
 */
public class CglibInTest {

    public static void main(String args[]){
        Enhancer en = new Enhancer();
        en.setSuperclass(Person.class);
        Person personT = new Person();
        CglibInterceptorOne cglibInterceptorOne = new CglibInterceptorOne();
        cglibInterceptorOne.setOne(personT);

        CglibInterceptorTwo cglibInterceptorTwo = new CglibInterceptorTwo();
        cglibInterceptorTwo.setOne(personT);

        MethodInterceptor[] methodInterceptors = new MethodInterceptor[] {cglibInterceptorOne,cglibInterceptorTwo};
        //en.setCallback(cglibInterceptorOne);
        en.setCallbacks(methodInterceptors);
        en.setCallbackFilter(new CallbackFilterOne());
        Person person = (Person) en.create();
        person.testLn(1,2);
        //person.test();
        person.setAge(2);
    }
}
