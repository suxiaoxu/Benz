package com.sxx.retry.smaple;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class RetryMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
       //cglib�����jvm�����ڻ�ȡannotationʱ�ǲ���������
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
