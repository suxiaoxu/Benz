package com.sxx.retry.smaple;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

	@Autowired
    private ServiceInterface service;

    private void test() {
        service.hello();// ����׳��쳣��hahaha�ᱻ����ִ��һ��
        service.hi(); // hahaha�����ص��ã������Ƿ��׳��쳣��hahaha�����ᱻ����
        service.hahaha(); // ����׳��쳣��hahaha�ᱻ����ִ��һ��
    }

}
