package com.sxx.ioc.xml.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // SpringӦ�������Ļ���

    /*

     * ʵ����ApplicationContextAware �ӿڣ�����ʵ�ָ÷�����

     *ͨ������applicationContext������ʼ����Ա����applicationContext

     */

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
          SpringContextUtil.applicationContext = applicationContext;
    }



    public static ApplicationContext getApplicationContext() {
           return applicationContext;
    }


     @SuppressWarnings("unchecked")
     public static <T> T getBean(String name) throws BeansException {
                return (T) applicationContext.getBean(name);
      }

}
