package com.sxx.retry.smaple;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class RetryMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
       //cglib代理和jvm代理在获取annotation时是不是有区别？
        int retryTimes = invocation.getMethod().getAnnotation(RetryExecution.class).retryTimes();
        while (--retryTimes >= 0) {
            try {
                return invocation.proceed();
            } catch (Throwable t) {
            	System.out.println("this is exception");
            }
        }
        return invocation.proceed();
    }
}
