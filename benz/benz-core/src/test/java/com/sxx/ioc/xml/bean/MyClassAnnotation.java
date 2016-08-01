package com.sxx.ioc.xml.bean;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE) 
public @interface MyClassAnnotation
{
    String uri();
    String desc();
}
