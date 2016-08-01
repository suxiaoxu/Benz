package com.sxx.retry.smaple;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

	@Autowired
    private ServiceInterface service;

    private void test() {
        service.hello();// 如果抛出异常，hahaha会被重新执行一次
        service.hi(); // hahaha被本地调用，无论是否抛出异常，hahaha都不会被重试
        service.hahaha(); // 如果抛出异常，hahaha会被重新执行一次
    }

}
