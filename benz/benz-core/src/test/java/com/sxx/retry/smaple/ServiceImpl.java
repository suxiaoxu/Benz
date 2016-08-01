package com.sxx.retry.smaple;

import java.lang.annotation.Annotation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceInterface {

    ServiceImpl self;

    @Autowired
    private ApplicationContext applicationContext;

    // 在Service初始化完成之后，注入其Reference
    @PostConstruct
    private void init() {
        self = applicationContext.getBean("ServiceImpl", ServiceImpl.class);
    }

    public void hello(){
        self.hahaha();
    }

    public void hi(){
        hahaha();
    }

    @RetryExecution
    public void hahaha() {
    	
    }
}
